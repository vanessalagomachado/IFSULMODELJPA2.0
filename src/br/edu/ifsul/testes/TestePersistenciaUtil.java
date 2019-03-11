/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.testes;

import br.edu.ifsul.jpa.EntityManagerUtil;
import br.edu.ifsul.modelo.Pais;
import java.util.Set;
import javax.persistence.EntityManager;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;

/**
 *
 * @author vanes
 */
public class TestePersistenciaUtil {
    public static void main(String[] args) {
        EntityManager em = EntityManagerUtil.getEntityManager();
        
        Pais obj = new Pais();
        obj.setNome("Chile");
        obj.setIso("CHI");
        
        em.getTransaction().begin();
        
        Validator validador = Validation.buildDefaultValidatorFactory().getValidator();
        Set<ConstraintViolation<Pais>> erros = validador.validate(obj);
        
        if(erros.size()>0){
            for(ConstraintViolation<Pais> e: erros){
                System.err.println("Erro: "+e.getMessage());
            }
        } else {
            em.persist(obj);
        }
        em.getTransaction().commit();
        em.close();
    }
}
