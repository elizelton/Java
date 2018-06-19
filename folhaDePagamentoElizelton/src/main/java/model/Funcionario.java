package model;

abstract public class Funcionario {

    String nome;
    double salario;
    String sexo;

    abstract public double getSalarioFinal();

    public Class<? extends Funcionario> getTipo() {
        return this.getClass();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        if (salario < 0) {
            this.salario = 0;
        } else {
            this.salario = salario;
        }
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

}
