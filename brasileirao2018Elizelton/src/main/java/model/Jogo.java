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

    public Jogo(String linha) {
        String[] partes = linha.split("\\,");   // Dividir a string em partes. 
        this.timeA = partes[0];

        this.golA = Byte.parseByte(partes[1]);

        this.timeB = partes[2];

        this.golB = Byte.parseByte(partes[3]);

    }

    public String getTimeA() {
        return timeA;
    }

    public String getTimeB() {
        return timeB;
    }

    public byte getGolA() {
        return golA;
    }

    public byte getGolB() {
        return golB;
    }

    public void setTimeA(String timeA) {
        this.timeA = timeA;
    }

    public void setTimeB(String timeB) {
        this.timeB = timeB;
    }

    public void setGolA(byte golA) {
        this.golA = golA;
    }

    public void setGolB(byte golB) {
        this.golB = golB;
    }

}
