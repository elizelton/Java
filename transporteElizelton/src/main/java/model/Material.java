/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author gab_a
 */
public class Material {
    private String nome;
    private double densidade;

    public Material(String nome, double densidade) {
        setNome(nome);
        setDensidade(densidade);
    }
    
    public Material(double densidade) {
        setNome("");
        setDensidade(densidade);
    }
    
    public Material() {
        this.nome = "Vazio";
        this.densidade = 0.1;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        if(!nome.isEmpty()){
            this.nome = nome;
        }else{
            this.nome = "Não definido";
        }
    }

    public double getDensidade() {
        return densidade;
    }

    public void setDensidade(double densidade) {
        if(densidade > 0){
            this.densidade = densidade;
        }else{
            this.densidade = 0.1;
        }
    }

    @Override
    public String toString() {
        return nome;
    }
    
    
}
