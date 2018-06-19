package model;

public class Gerente extends Funcionario {

    private double bonificacao;
    
    public Gerente(){
        
    }

    public Gerente(String nome, double salario, String sexo, double bonificacao) {
        setNome(nome);
        setSalario(salario);
        setSexo(sexo);
        this.bonificacao = bonificacao;
    }

    public Gerente(String elizelton, int i, String masculino) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public double getSalarioFinal() {
        return (salario + bonificacao);
    }

    @Override
    public String toString() {
        return "Gerente{" +"nome =" + nome + "bonificacao=" + bonificacao + '}';
    }
    
}
