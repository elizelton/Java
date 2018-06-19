package model;

public class Vendedor extends Funcionario {
    
    private double venda;
    
    public Vendedor(String nome, double salario, String sexo, double venda) {
        setNome(nome);
        setSalario(salario);
        setSexo(sexo);
        this.venda = venda;
    }

    public double getVenda() {
        return venda;
    }

    public void setVenda(double venda) {
        this.venda = venda;
    }
    
    @Override
    public double getSalarioFinal() {
        return (salario + (venda * 0.04));
    }
    
}
