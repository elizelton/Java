/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import static config.Config.df;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 *
 * @author Muriel
 */
@Document
public class Aluno {

    @Id
    private String id;

    private String nome;
    private String email;

    @Indexed(unique = true)
    private String ra;

    private LocalDate dataNascimento;
    @DBRef
    private Cidade cidade;
    private List<Matricula> matriculas = new ArrayList<>();

    public Aluno() {
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public String getDataNascimentoFormat() {
        if (dataNascimento != null) {
            return df.format(dataNascimento);
        } else {
            return "00/00/0000";
        }
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public List<Matricula> getMatriculas() {
        return matriculas;
    }

    public void setMatriculas(List<Matricula> matriculas) {
        this.matriculas = matriculas;
    }

    public Aluno(String nome, String email, String ra, Cidade cidade) {
        this.nome = nome;
        this.email = email;
        this.ra = ra;
        this.cidade = cidade;
    }

    public Aluno(String nome, String email, String ra, LocalDate dataNascimento, Cidade cidade,
            List<Matricula> matriculas) {
        this.nome = nome;
        this.email = email;
        this.ra = ra;
        this.dataNascimento = dataNascimento;
        this.cidade = cidade;
        this.matriculas = matriculas;
    }

    public int getDisciplinasQtd() {
        return matriculas.size();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRa() {
        return ra;
    }

    public void setRa(String ra) {
        this.ra = ra;
    }

    public Cidade getCidade() {
        return cidade;
    }

    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 47 * hash + (this.id != null ? this.id.hashCode() : 0);
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
        final Aluno other = (Aluno) obj;
        if ((this.id == null) ? (other.id != null) : !this.id.equals(other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return getNome();
    }

}
