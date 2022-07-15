package mx.edu.utez.sigebuapp_v1.controller;

import mx.edu.utez.sigebuapp_v1.model.BeanUsuario;
import mx.edu.utez.sigebuapp_v1.service.ServiceUsuario;
import mx.edu.utez.sigebuapp_v1.utils.ResultAction;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
@WebServlet(name = "ServletUsuario",
urlPatterns = {
        "/get-usuarios",
        "/add-usuario",
        "/create-usuario",
        "/save-usuario",
        "/get-usuario",
})

public class ServletUsuario extends HttpServlet {
    Logger logger = Logger.getLogger("ServletUsuario");
    String action;
    String urlRedirect = "/get-usuarios";
    ServiceUsuario serviceUsuario = new ServiceUsuario();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        action = request.getServletPath();
        logger.log(Level.INFO, "Path-> "+action);
        String accion = request.getParameter("accion");
        if (accion.equalsIgnoreCase("Listar")){
            request.setAttribute("usuarios",serviceUsuario.getAll());
            urlRedirect = "../webapp/views/sigebu/catalogoUsuarios.jsp";
        }
        switch (accion){
            case "listar":
                request.setAttribute("usuarios",serviceUsuario.getAll());
                urlRedirect = "../webapp/views/sigebu/catalogoUsuarios.jsp";
                break;
            case "/create-usuario":
                urlRedirect = "/views/sigebu/registro.jsp";
                break;
            case "/get-usuario":
                String id = request.getParameter("id");
                id = (id == null) ? "0":id;
                try{
                    BeanUsuario usuario = serviceUsuario.getUsuario(Integer.parseInt(id));
                    request.setAttribute("usuario", usuario);
                    urlRedirect = "/views/sigebu/catalogoUsuarios.jsp";
                }catch (Exception e){
                    urlRedirect = "/get-usuarios";
                }
                break;
            default:
                request.setAttribute("usuarios", serviceUsuario.getAll());
                urlRedirect = "/get-usuarios";
                break;
        }
        request.getRequestDispatcher(urlRedirect).forward(request, response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException{
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");
        action = request.getServletPath();
        switch (action){
            case "/add-usuario":
                String nombre = request.getParameter("nombre");
                String apellidos = request.getParameter("apellidos");
                String matriculaCurp = request.getParameter("matriculaCurp");
                String edad = request.getParameter("edad");
                String tipo = "Alumno";
                String direccion = request.getParameter("direccion");
                String email = request.getParameter("email");
                String password = request.getParameter("password");
                BeanUsuario usuario = new BeanUsuario();
                usuario.setNombre(nombre);
                usuario.setApellidos(apellidos);
                usuario.setMatricula(matriculaCurp);
                usuario.setEdad(Integer.parseInt(edad));
                usuario.setTipo(tipo);
                usuario.setDireccion(direccion);
                usuario.setEmail(email);
                usuario.setPassword(password);
                ResultAction result = serviceUsuario.save(usuario);
                urlRedirect = "/get-usuarios?result="+
                        result.isResult()+"&message="+result.getMessage()
                        +"&status="+result.getStatus();
                break;
            default:
                urlRedirect = "/get-usuarios";
                break;
        }
        response.sendRedirect(request.getContextPath()+urlRedirect);
    }
}
