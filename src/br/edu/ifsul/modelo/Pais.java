/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.modelo;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author vanes
 */
@Entity
@Table(name = "pais")
public class Pais implements Serializable{
    @Id
    @SequenceGenerator(name = "seq_pais", sequenceName = "seq_pais_id", allocationSize = 1)
    @GeneratedValue(generator = "seq_pais", strategy = GenerationType.SEQUENCE)
//    @Column(name="id", nullable = false, columnDefinition = "serial")
    private Integer id;
    @Length(max=50,message = "O nome deve conter menos de {max} caracteres.")
    @NotBlank(message = "Informe o nome.")
    @NotNull(message = "Nome não pode ser nulo.")
    @Column(name="nome", nullable = false, length = 50)
    private String nome;
    @Length(max=3,message = "O ISO deve conter menos de {max} caracteres.")
    @NotBlank(message = "Informe o ISO.")
    @NotNull(message = "ISO não pode ser nulo.")
    @Column(name="iso", length = 3, nullable = false)
    private String iso;

    public Pais() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getIso() {
        return iso;
    }

    public void setIso(String iso) {
        this.iso = iso;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Pais other = (Pais) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
    
}
