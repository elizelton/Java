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
public class Prisma extends FiguraGeo3d {

    double lado;

    public double getLado() {
        return lado;
    }

    public void setLado(double lado) {
        if (lado > 0) {
            this.lado = lado;
        } else {
            lado = 0.1;
        }
    }

    public double getRaiz3() {
        return raiz3;
    }

    public void setRaiz3(double raiz3) {
        this.raiz3 = raiz3;
    }
    double raiz3 = Math.sqrt(3);

    @Override
    public double getAreaDaBase() {
        return (lado * lado * raiz3) / 4;
    }

    @Override
    public boolean isBaseCircular() {
        return (false);
    }

    @Override
    public double getVolume() {
        return getAreaDaBase() * alt;
    }
}
