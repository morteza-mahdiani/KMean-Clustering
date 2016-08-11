package com.company;

/**
* Created by morteza on 6/2/16 AD.
*/
public class C_Point {
    //definitions
    /*______________________________________________*/
    private String document_id;
    private double cosinesValue;
    private double weight;
    private double x;
    private double y;
    private long cluster_id;
    /*______________________________________________*/

    //constructor
    /*______________________________________________*/
    public C_Point(double cosinesValue, double weight)
    {
        this.setCosinesValue(cosinesValue);
        this.setWeight(weight);
        this.setX(weight * Math.cos(cosinesValue));
        this.setY(weight * Math.sin(cosinesValue));
    }
    /*______________________________________________*/

    //functions for set and get private values
    /*______________________________________________*/
    public void setCosinesValue(double cosinesValue) {
        this.cosinesValue = cosinesValue;
    }

    public double getCosinesValue()  {
        return this.cosinesValue;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getWeight() {
        return this.weight;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getX()  {
        return this.x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getY()  {
        return this.y;
    }

    public void setDocument_id(String document_id) {
        this.document_id = document_id;
    }

    public String getDocument_id()  {
        return this.document_id;
    }
    /*____________________________________________*/

    //getter and setter id didn't use but may be required
    /*____________________________________________*/
    public void setCluster_id(int n) {
        this.cluster_id = n;
    }

    public long getCluster_id() {
        return this.cluster_id;
    }
    /*____________________________________________*/
}

