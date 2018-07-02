package model;

abstract public class Funcionario {

    private String nome;
    private double salario;
    private String sexo;

    protected Funcionario(String nome, double salario, String sexo) {
        setNome(nome);
        setSalario(salario);
        setSexo(sexo);
    }

    abstract public double getSalarioFinal();

    public String getTipo() {
        return this.getClass().getSimpleName();
    }

    abstract public double getExtras();

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        if (nome.isEmpty()) {
            this.nome = "Indefinido";
        } else {
            this.nome = nome;
        }
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        if (salario < 954) {
            this.salario = 954;
        } else {
            this.salario = salario;
        }
    }

    public String getSexoExibir() {
        if (sexo.equals("M")) {
            return "Masculino";
        } else {
            return "Feminino";
        }

    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo.toUpperCase();
        if (!sexo.equals("M") && !sexo.equals("F")) {
            this.sexo = "I";
        }
    }

    @Override
    public String toString() {
        return (String.format("NOME =%s | SEXO = %s %s | FUNCAO = %s | SALARIO = %.2f | EXTRAS = %s", getNome(), getSexo(), getSexoExibir(), getTipo(), getSalario(), getExtras()));
    }
}
