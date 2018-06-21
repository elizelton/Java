package model;

public class Gerente extends Funcionario {

    private double bonificacao;

    public Gerente(String nome, double salario, String sexo, double bonificacao) {
        super(nome, salario, sexo);
        this.setBonificacao(bonificacao);
    }

    @Override
    public double getSalarioFinal() {
        return (salario + bonificacao);
    }

    public double getBonificacao() {
        return bonificacao;
    }

    public void setBonificacao(double bonificacao) {
        if (bonificacao >= 0) {
            this.bonificacao = bonificacao;
        } else {
            this.bonificacao = 0;
        }
    }

    @Override
    public double getExtras() {
        return getBonificacao();
    }

}
