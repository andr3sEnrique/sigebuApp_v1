package mx.edu.utez.sigebuapp_v1.model;

import mx.edu.utez.sigebuapp_v1.utils.MySQLConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DaoUsuario {
    Connection conn;
    PreparedStatement ps;
    CallableStatement cstm;
    ResultSet rs;
    public List<BeanUsuario> findAll(){
        List<BeanUsuario> usuarios = new ArrayList<>();
        BeanUsuario usuario = null;
        try{
            conn = new MySQLConnection().getConnection();
            String query = "SELECT * FROM usuario;";
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()){
                usuario = new BeanUsuario();
                usuario.setId(rs.getInt("id"));
                usuario.setNombre(rs.getString("nombre"));
                usuario.setApellidos(rs.getString("apellidos"));
                usuario.setCurp(rs.getString("curp"));
                usuario.setMatricula(rs.getString("matricula"));
                usuario.setEdad(rs.getInt("edad"));
                usuario.setTipo(rs.getString("tipo"));
                usuario.setDireccion(rs.getString("direccion"));
                usuario.setEmail(rs.getString("correo"));
                usuario.setPassword(rs.getString("contraseña"));
                usuarios.add(usuario);
            }
        }catch (SQLException e){
            Logger.getLogger(DaoUsuario.class.getName())
                    .log(Level.SEVERE, "Error findAll", e);
        }finally {
            closeConnection();
        }
        return usuarios;
    }
    public boolean agregar(BeanUsuario usuario){
        try{
            conn= new MySQLConnection().getConnection();
            String query = "INSERT INTO usuario"+
                    "(nombre, apellidos, matricula, edad, tipo, direccion, correo, contraseña)"+
                    "VALUES (?,?,?,?,?,?,?,?)";
            ps=conn.prepareStatement(query);
            ps.setString(1, usuario.getNombre());
            ps.setString(2, usuario.getApellidos());
            ps.setString(3, usuario.getMatricula());
            ps.setInt(4, usuario.getEdad());
            ps.setString(5, usuario.getTipo());
            ps.setString(6, usuario.getDireccion());
            ps.setString(7, usuario.getEmail());
            ps.setString(8, usuario.getPassword());
            return ps.executeUpdate() == 1;

        }catch (Exception e){
            Logger.getLogger(DaoUsuario.class.getName())
                    .log(Level.SEVERE, "Error save", e);
            return false;
        }finally {
            closeConnection();
        }

    }
    public BeanUsuario findOne(int id){
        try {
            conn = new MySQLConnection().getConnection();
            String query = "SELECT * FROM USUARIO WHERE ID =?";
            ps = conn.prepareStatement(query);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if (rs.next()){
                BeanUsuario usuario = new BeanUsuario();
                usuario.setId(rs.getInt("id"));
                usuario.setNombre(rs.getString("nombre"));
                usuario.setApellidos(rs.getString("apellidos"));
                usuario.setCurp(rs.getString("curp"));
                usuario.setMatricula(rs.getString("matricula"));
                usuario.setEdad(rs.getInt("edad"));
                usuario.setTipo(rs.getString("tipo"));
                usuario.setDireccion(rs.getString("direccion"));
                usuario.setEmail(rs.getString("correo"));
                usuario.setPassword(rs.getString("contraseña"));
                return usuario;
            }
        }catch (SQLException e){
            Logger.getLogger(DaoUsuario.class.getName())
                    .log(Level.SEVERE, "Error save", e);
        }finally {
            closeConnection();
        }
        return null;
    }
    public boolean update(BeanUsuario usuario){
        try{
            conn = new MySQLConnection().getConnection();
            String query = "UPDATE usuario SET nombre = ?, apellidos=?,"+
                    "curp=?, matricula=?, edad=?, tipo=?, direccion=?,"+
                    "correo=?, contraseña=? WHERE id =?";
            ps = conn.prepareStatement(query);
            ps.setString(1, usuario.getNombre());
            ps.setString(2, usuario.getApellidos());
            ps.setString(3, usuario.getCurp());
            ps.setString(4, usuario.getMatricula());
            ps.setInt(5, usuario.getEdad());
            ps.setString(6, usuario.getTipo());
            ps.setString(7, usuario.getDireccion());
            ps.setString(8, usuario.getEmail());
            ps.setString(9, usuario.getPassword());
            ps.setInt(10, usuario.getId());
            return ps.executeUpdate() == 1;
        }catch (SQLException e){
            Logger.getLogger(DaoUsuario.class.getName())
                    .log(Level.SEVERE, "Error save", e);
            return false;
        }finally {
            closeConnection();
        }
    }
    public void closeConnection(){
        try{
            if(conn != null){
                conn.close();
            }
            if(ps != null){
                ps.close();
            }
            if(cstm != null){
                cstm.close();
            }
            if(rs != null){
                rs.close();
            }
        }catch (SQLException e){

        }
    }
}
