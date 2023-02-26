package model;

public class FlyWheel {
    public int l1=100;
    public int l2=500;
    public int d=100;
    public int h = 100;

    public FlyWheel( int d, int h, int l1, int l2){
        this.d = d;
        this.h = h;
        this.l1 = l1;
        this.l2 = l2;
    }

    public Double computeBeta(Double alpha){
        double beta;
        double x1 = l1 * Math.cos(alpha);
        double y1 = l1 * Math.sin(alpha);
        double d1 = d - x1;
        double h1 = h - y1;
        double gamma = Math.atan2(h1,d1);
        beta = alpha - gamma;
        return beta;
    }

    public Double computeGamma(Double alpha){
        double x1 = l1 * Math.cos(alpha);
        double y1 = l1 * Math.sin(alpha);
        double d1 = d - x1;
        double h1 = h - y1;
        double gamma = Math.atan2(h1,d1);
        return gamma;
    }

    public Double[] possition(double alpha){
        Double[] postab = new Double[2];
        Double p1x=l1 * Math.cos(alpha);
        Double p1y = l1 * Math.sin(alpha);
        postab[0] = l2 * Math.cos(computeGamma(alpha))+p1x;
        postab[1] = l2 * Math.sin(computeGamma(alpha))+p1y;
        return postab;
    }



}
