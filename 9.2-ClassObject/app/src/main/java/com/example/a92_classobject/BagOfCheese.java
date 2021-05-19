package com.example.a92_classobject;

public class BagOfCheese {
    public String kind;
    public double weight;
    public int daysAged;
    public boolean isDomestic;

    public BagOfCheese(){

    }

    public BagOfCheese(String kind, double weight, int daysAged, boolean isDomestic) {
        this.kind = kind;
        this.weight = weight;
        this.daysAged = daysAged;
        this.isDomestic = isDomestic;
    }
    public String toString() {
        return kind +","+ weight + ", " +
                daysAged + ", " + isDomestic + "\n";
    }
}
