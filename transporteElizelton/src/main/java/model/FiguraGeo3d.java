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
abstract public class FiguraGeo3d {

    double alt;
    Material material;
    boolean fragil;
    double diametro;

    abstract public double getAreaDaBase();

    abstract public double getVolume();
    
    abstract public boolean isBaseCircular();

    public double getAlt() {
        return alt;
    }

    public void setAlt(double alt) {
        if (alt > 0) {
            this.alt = alt;
        } else {
            alt = 0.1;
        }
    }

    public Material getMaterial() {
        return material;
    }

    public void setMaterial(Material material) {
        this.material = material;
    }

    public double getPeso() {
        return this.getVolume() * this.material.getDensidade();
    }

    public boolean isFragil() {
        return fragil;
    }

    public void setFragil(boolean fragil) {
        this.fragil = fragil;
    }
}
