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
public class TesteAlterarPais {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("IFSULModelPU");
        EntityManager em = emf.createEntityManager();
        
        //Carregar objeto do banco de dados
        Pais p = em.find(Pais.class, 3);
        p.setNome("Chile");
        p.setIso("CHL");
        
        em.getTransaction().begin();
        //Responsável por mesclar o estado persistênte do dado do objeto com os dados alterados
        em.merge(p);
        em.getTransaction().commit();
        em.close();
        emf.close();
    }
}
