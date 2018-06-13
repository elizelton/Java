package model;

import java.util.ArrayList;
import java.util.List;

public class Time {

    private String nome;
    private int vitorias = 0;
    private int derrotas = 0;
    private int empates = 0;
    private int golPro = 0;
    private int golContra = 0;
    private byte clas = 0;
    private List<Jogo> jogos = new ArrayList<Jogo>();

    public Time() {

    }

    public Time(String nome) {
        this.nome = nome;
    }

    public Time(String nome, int vitorias, int derrotas, int empates, int golPro, int golContra) {
        this.nome = nome;
        this.vitorias = vitorias;
        this.derrotas = derrotas;
        this.empates = empates;
        this.golPro = golPro;
        this.golContra = golContra;
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
        return golPro;
    }

    public int getGolContra() {
        return golContra;
    }

    public byte getClas() {
        return clas;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void addVitorias() {
        this.vitorias++;
    }

    public void addDerrotas() {
        this.derrotas++;
    }

    public void addEmpates() {
        this.empates++;
    }

    public void addGolPro(int gols) {
        this.golPro += gols;
    }

    public void addGolContra(int gols) {
        this.golContra += gols;
    }

    public String getNome() {
        return nome;
    }

    public void setClas(byte clas) {
        this.clas = clas;
    }

    public int getSaldoGols() {
        return golPro = golContra;
    }

    public int getPontos() {
        return (vitorias * 3) + empates;
    }

    public int getPartidas() {
        return vitorias + empates + derrotas;
    }

    public List<Jogo> getJogos() {
        return jogos;
    }

    public void setJogos(List<Jogo> jogos) {
        this.jogos = jogos;
    }

    public List<Jogo> getVitoriasCasa() {
        List<Jogo> jogosCasa = new ArrayList<Jogo>();
        for (Jogo j : jogos) {
            if (j.getTimeA() == this.getNome() && j.getGolA() > j.getGolB()) {
                jogosCasa.add(j);
            }
        }
        return jogosCasa;
    }

    @Override
    public String toString() {
        return "Time{" + "nome=" + nome + ", vitorias=" + vitorias + ", derrotas=" + derrotas + ", empates=" + empates + ", golPro=" + golPro + ", golContra=" + golContra + ", clas=" + clas + '}';
    }

}
