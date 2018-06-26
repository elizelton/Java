package model;

public class Administrativo extends Funcionario {

    public Administrativo(String nome, double salario, String sexo) {
       super(nome,salario,sexo);
    }

    @Override
    public double getSalarioFinal() {
        return  getSalario();
    }

    @Override
    public double getExtras() {
        return 0;
    }

}
