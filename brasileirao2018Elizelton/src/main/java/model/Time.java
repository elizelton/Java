package model;

import java.util.ArrayList;
import java.util.List;

public class Time {

    private String nome;
    private int vitorias = 0;
    private int derrotas = 0;
    private int empates = 0;
    private int golsPro = 0;
    private int golsContra = 0;
    private List<Jogo> jogos = new ArrayList<Jogo>();

    public Time(String nome) {
        this.nome = nome;
    }

    public Time() {
    }

    public Time(String nome, int vitorias, int derrotas, int empates, int golPro, int golsContra) {
        this.nome = nome;
        this.vitorias = vitorias;
        this.derrotas = derrotas;
        this.empates = empates;
        this.golsPro = golPro;
        this.golsContra = golsContra;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getVitorias() {
        return vitorias;
    }

    public int getDerrotas() {
        return derrotas;
    }

    public int getEmpates() {
        return empates;
    }

    public int getGolPro() {
        return golsPro;
    }

    public int getGolsContra() {
        return golsContra;
    }

    public byte getClas() {
        return clas;
    }

    public void setClas(byte clas) {
        this.clas = clas;
    }
    private byte clas = 0;

    public void addVitoria() {
        this.vitorias++;
    }

    public void addDerrota() {
        this.derrotas++;
    }

    public void addEmpate() {
        this.empates++;
    }

    public void addGolsPro(int gols) {
        this.golsPro += gols;
    }

    public void addGolsContra(int gols) {
        this.golsPro += gols;
    }

    public int getSaldoGols() {
        return golsPro - golsContra;
    }

    public int getPartidas() {
        return (vitorias + empates + derrotas);
    }

    public int getPontos() {
        return (vitorias * 3) + empates;
    }

    @Override
    public String toString() {
        return "Time{" + "nome=" + nome + ", vitorias=" + vitorias + ", derrotas=" + derrotas + ", empates=" + empates + ", golsPro=" + golsPro + ", golsContra=" + golsContra + ", clas=" + clas + '}';
    }

}
