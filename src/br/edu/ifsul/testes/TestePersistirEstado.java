/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.testes;

import br.edu.ifsul.jpa.EntityManagerUtil;
import br.edu.ifsul.modelo.Estado;
import javax.persistence.EntityManager;

/**
 *
 * @author vanes
 */
public class TestePersistirEstado {
    public static void main(String[] args) {
        EntityManager em = EntityManagerUtil.getEntityManager();
        
        em.getTransaction().begin();
        
        Estado obj = new Estado();
    }
}
