/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.testes;

import br.edu.ifsul.modelo.Pais;
import java.util.Set;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;

/**
 *
 * @author vanes
 */
public class TestePersistirPais {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("IFSULModelPU");
        EntityManager em = emf.createEntityManager();
        Pais p = new Pais();
        p.setNome("Uruguay");
        p.setIso("URU");
        
        em.getTransaction().begin();
        Validator validador = Validation.buildDefaultValidatorFactory().getValidator();
        Set<ConstraintViolation<Pais>> erros = validador.validate(p);
        if(erros.size() > 0){
            for(ConstraintViolation<Pais> e: erros){
                System.err.println("Erro: "+e.getMessage());
            }
        } else {
        //Persistir somente se não houver erro de validação
        em.persist(p);
        }
        em.getTransaction().commit();
        em.close();
        emf.close();
    }
}
