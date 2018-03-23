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
import mostrar.banco.ClienteCadastro;
import mostrar.banco.ClienteDeletar;

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
        cliente.setClienteCPF(ClienteCadastro.txtCPF.getText());
        cliente.setClienteNome(ClienteCadastro.txtNome.getText());
        em.getTransaction().begin();
        em.persist(cliente);
        em.getTransaction().commit();
        
    }
    
    public static void Deletar()
    {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("banco1?zeroDateTimeBehavior=convertToNullPU");
        EntityManager em = emf.createEntityManager(); 
        Long coluna =Long.parseLong(ClienteDeletar.txtDeletar.getText());
        Cliente cliente = em.find(Cliente.class, coluna);
        
        em.getTransaction().begin();
        em.remove(cliente);
        em.getTransaction().commit();
    }
}
