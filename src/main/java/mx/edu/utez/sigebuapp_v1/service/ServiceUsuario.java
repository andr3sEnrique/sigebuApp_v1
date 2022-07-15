package mx.edu.utez.sigebuapp_v1.service;

import mx.edu.utez.sigebuapp_v1.model.BeanUsuario;
import mx.edu.utez.sigebuapp_v1.model.DaoUsuario;
import mx.edu.utez.sigebuapp_v1.utils.ResultAction;

import java.util.List;

public class ServiceUsuario {
    DaoUsuario daoUsuario = new DaoUsuario();
    public List<BeanUsuario> getAll(){
        return daoUsuario.findAll();
    }
    public ResultAction save(BeanUsuario usuario){
        ResultAction result = new ResultAction();
        if (daoUsuario.agregar(usuario)){
            result.setResult(true);
            result.setMessage("Usuario registrado correctamente");
            result.setStatus(200);
        }else{
            result.setResult(false);
            result.setMessage("Ocurrio un error al registrar");
            result.setStatus(400);
        }
        return result;
    }
    public BeanUsuario getUsuario(int id){
        return daoUsuario.findOne(id);
    }
    public ResultAction update(BeanUsuario usuario){
        ResultAction result = new ResultAction();
        if (daoUsuario.update(usuario)){
            result.setStatus(200);
            result.setResult(false);
            result.setMessage("Usuario actualizado correctamente");
        }else{
            result.setStatus(400);
            result.setResult(true);
            result.setMessage("Ocurrio un error");
        }
        return result;
    }
}
