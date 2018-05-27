package model;

public class Jogo {

    private String timeA;
    private String timeB;
    private byte golA;
    private byte golB;

    public Jogo(String timeA, String timeB, byte golA, byte golB) {
        this.timeA = timeA;
        this.timeB = timeB;
        this.golA = golA;
        this.golB = golB;
    }

    public String getTimeA() {
        return timeA;
    }

    public void setTimeA(String timeA) {
        this.timeA = timeA;
    }

    public String getTimeB() {
        return timeB;
    }

    public void setTimeB(String timeB) {
        this.timeB = timeB;
    }

    public byte getGolA() {
        return golA;
    }

    public void setGolA(byte golA) {
        this.golA = golA;
    }

    public byte getGolB() {
        return golB;
    }

    public void setGolB(byte golB) {
        this.golB = golB;
    }

    @Override
    public String toString() {
        return "Jogo{" + "timeA=" + timeA + ", timeB=" + timeB + ", golA=" + golA + ", golB=" + golB + '}';
    }

}
