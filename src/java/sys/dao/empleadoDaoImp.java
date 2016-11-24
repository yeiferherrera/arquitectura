/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sys.dao;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import sys.model.Tbempleado;
import sys.util.HibernateUtil;

/**
 *
 * @author Administrador
 */
public class empleadoDaoImp implements empleadoDao{

    @Override
    public List<Tbempleado> mostrarEmpleados() {
        List<Tbempleado> ListarEmpleados = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        
        String hql ="FROM Tbempleado as e inner join fetch e.tbpais left join fetch e.tbdepartamento left join fetch e.tbmunicipio";
        
        try {
            ListarEmpleados = session.createQuery(hql).list();
            transaction.commit();
            session.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            transaction.rollback();
        }
        
        
    return ListarEmpleados;
    }
    
    @Override
    public void nuevoEmpleado(Tbempleado tbempleado) {
        Session session = null;
        
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(tbempleado);
            session.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            session.beginTransaction().rollback();
        }finally{
            if (session!=null){
                session.close();
            }
        }
    }
}
