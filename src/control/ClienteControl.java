/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.JTable;
import mostrar.banco.Cliente;

/**
 *
 * @author Italo
 */
public class ClienteControl {
    
    public static void Cadastrar()
    {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("banco1?zeroDateTimeBehavior=convertToNullPU");
        EntityManager em = emf.createEntityManager();   
        
        Cliente cliente = new Cliente();
        cliente.setClienteCPF("11916544436");
        cliente.setClienteNome("Italo caralho");
        em.getTransaction().begin();
        em.persist(cliente);
        em.getTransaction().commit();
        
    }
}
