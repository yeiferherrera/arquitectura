/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sys.bean;

import java.util.List;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import sys.dao.empleadoDao;
import sys.dao.empleadoDaoImp;
import sys.model.Tbempleado;

/**
 *
 * @author Administrador
 */
@Named(value = "empleadoBean")
@ViewScoped
public class empleadoBean {

    /**
     * Creates a new instance of empleadoBean
     */
    
    private List<Tbempleado> listar;
    private Tbempleado empleado;
    
    public empleadoBean() {
    }

    public Tbempleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Tbempleado empleado) {
        this.empleado = empleado;
    }

    public List<Tbempleado> getListar() {
        empleadoDao eDao = new empleadoDaoImp();
        listar = eDao.mostrarEmpleados();
        return listar;
    }
    
    public void nuevoEmpleado(){
        empleadoDao eDao = new empleadoDaoImp();
        eDao.nuevoEmpleado(empleado);
        empleado = new Tbempleado();
    }

    
}
