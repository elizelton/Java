package model;

public class Gerente extends Funcionario {

    private double bonificacao;

    public Gerente(String nome, double salario, String sexo, double bonificacao) {
        setNome(nome);
        setSalario(salario);
        setSexo(sexo);
        this.bonificacao = bonificacao;
    }

    @Override
    public double getSalarioFinal() {
        return (salario + bonificacao);
    }

    @Override
    public String toString() {
        return "Gerente {" + "nome=" + nome + " salario=" +salario + " bonificacao=" + bonificacao + '}';
    }

}
