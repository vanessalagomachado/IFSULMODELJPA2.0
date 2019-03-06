/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.testes;

import br.edu.ifsul.modelo.Pais;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author vanes
 */
public class TesteExcluirPais {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("IFSULModelPU");
        EntityManager em = emf.createEntityManager();
        
        //Carregar objeto do banco de dados
        Pais p = em.find(Pais.class, 5);
        
        
        em.getTransaction().begin();
        //Responsável por excluir o objeto do banco
        em.remove(p);
        em.getTransaction().commit();
        em.close();
        emf.close();
    }
}
