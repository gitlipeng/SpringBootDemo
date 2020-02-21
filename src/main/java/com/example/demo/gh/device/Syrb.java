package com.example.demo.gh.device;

/**
 * 水源热泵
 */
public class Syrb {
    private double edzl = 1213;
    private double zjhdl = 319.21;
    private double lqsgshz = 75.68;
    private double lqshshz = 121.69;
    private double lqsll;

    public static void main(String[] args) {
        Syrb syrb = new Syrb();
        System.out.println(syrb.getLqsll());
    }
    public double getEdzl() {
        return edzl;
    }

    public void setEdzl(double edzl) {
        this.edzl = edzl;
    }

    public double getZjhdl() {
        return zjhdl;
    }

    public void setZjhdl(double zjhdl) {
        this.zjhdl = zjhdl;
    }

    public double getLqsgshz() {
        return lqsgshz;
    }

    public void setLqsgshz(double lqsgshz) {
        this.lqsgshz = lqsgshz;
    }

    public double getLqshshz() {
        return lqshshz;
    }

    public void setLqshshz(double lqshshz) {
        this.lqshshz = lqshshz;
    }

    public double getLqsll() {
        return (edzl + zjhdl) / (lqshshz - lqsgshz) * 3.6;
    }

    public void setLqsll(double lqsll) {
        this.lqsll = lqsll;
    }
}
