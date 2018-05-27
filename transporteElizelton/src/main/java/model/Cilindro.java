/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author gab_a
 */
public class Cilindro extends FiguraGeo3d {

    double diametro;
    double pi = Math.PI;

    public Cilindro(double alt, double diametro, Material material, boolean fragil) {
        setAlt(alt);
        setDiametro(diametro);
        setMaterial(material);
        setFragil(fragil);
    }

    public double getDiametro() {
        return diametro;
    }

    public void setDiametro(double diametro) {
        if (diametro > 0) {
            this.diametro = diametro;
        } else {
            diametro = 0.1;
        }
    }

    public double getPi() {
        return pi;
    }

    public void setPi(double pi) {
        this.pi = pi;
    }

    public double getRaio() {
        return diametro / 2;
    }

    @Override
    public double getVolume() {
        return getAlt() * getAreaDaBase();
    }

    @Override
    public double getAreaDaBase() {
        return pi * getRaio() * getRaio();
    }

    @Override
    public boolean isBaseCircular() {
        return (diametro > 0);
    }

    @Override
    public String toString() {
        return "Cilindro";
    }

}
