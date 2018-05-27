package model;

public class Medida {

    private String descricaoDe;
    private String siglaDe;
    private String descricaoPara;
    private String siglaPara;
    private double fator;

    public Medida(String descricaoDe, String siglaDe, String descricaoPara, String siglaPara, double fator) {
        this.descricaoDe = descricaoDe;
        this.siglaDe = siglaDe;
        this.descricaoPara = descricaoPara;
        this.siglaPara = siglaPara;
        this.fator = fator;
    }

    public String getDescricaoDe() {
        return descricaoDe;
    }

    public void setDescricaoDe(String descricaoDe) {
        this.descricaoDe = descricaoDe;
    }

    public String getSiglaDe() {
        return siglaDe;
    }

    public void setSiglaDe(String siglaDe) {
        this.siglaDe = siglaDe;
    }

    public String getDescricaoPara() {
        return descricaoPara;
    }

    public void setDescricaoPara(String descricaoPara) {
        this.descricaoPara = descricaoPara;
    }

    public String getSiglaPara() {
        return siglaPara;
    }

    public void setSiglaPara(String siglaPara) {
        this.siglaPara = siglaPara;
    }

    public double getFator() {
        return fator;
    }

    public void setFator(double fator) {
        this.fator = fator;
    }

    @Override
    public String toString() {
        return descricaoDe + " - " + descricaoPara;
    }

}
