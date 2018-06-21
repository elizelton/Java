package model;

public class Vendedor extends Funcionario {

    private double venda;

    public Vendedor(String nome, double salario, String sexo, double venda) {
      super(nome, salario, sexo);
       this.setVenda(venda);
    }

    public double getVenda() {
        return venda;
    }

    public void setVenda(double venda) {
        if (venda >= 0) {
            this.venda = venda;
        } else {
            this.venda = 0;
        }
    }

    @Override
    public double getSalarioFinal() {
        return (salario + getComissao());
    }

    public double getComissao() {
        return (venda * 0.04);
    }

    @Override
    public double getExtras() {
        return getComissao();
    }

}
