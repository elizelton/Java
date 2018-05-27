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
public class Paralelepipedo extends FiguraGeo3d {

    double larg;
    double prof;

    public Paralelepipedo(double alt, double larg, double prof, Material material,boolean fragil) {
        setAlt(alt);
        setLarg(larg);
        setProf(prof);
        setMaterial(material);
        setFragil(fragil);
    }

    public double getLarg() {
        return larg;
    }

    public void setLarg(double larg) {
        if (larg > 0) {
            this.larg = larg;
        } else {
            larg = 0.1;
        }
    }

    public double getProf() {
        return prof;
    }

    public void setProf(double prof) {
        if (prof > 0) {
            this.prof = prof;
        } else {
            prof = 0.1;
        }
    }

    @Override
    public double getAreaDaBase() {
        return larg * prof;
    }

    @Override
    public double getVolume() {
        return getAreaDaBase() * alt;
    }
    
    @Override
    public boolean isBaseCircular() {
        return (false);
    }

    @Override
    public String toString() {
        return "Paralelepipedo";
    }

}
