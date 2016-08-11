package com.company;

import java.util.ArrayList;
import java.util.List;

/**
* Created by morteza on 6/2/16 AD.
*/
public class Cluster{
    //definitions
    private List<C_Point> points;
    private C_Point centroid;
    final int id;

    //define g for generating unique integer values as custer_id
    idGenerator g = new idGenerator();

    //constructor
    public Cluster()
    {
        this.id = g.nextValue();
        this.points = new ArrayList();
        this.centroid = null;
    }

    //functions for set, get and add points to cluster
    /*______________________________________________*/
    public List getPoints() {
        return points;
    }

    public void addPoint(C_Point point) {
        points.add(point);
    }

    public void setPoints(List points) {
        this.points = points;
    }
    /*______________________________________________*/

    //function for returning nearest point in cluster
    /*______________________________________________*/
    public C_Point nearestPointInCluster(double cosinesValue)
    {
        double temp1 = Double.POSITIVE_INFINITY;
        C_Point returnValue = new C_Point(0, 0);
        for(C_Point p: points)
        {
            double temp2 = cosinesValue - p.getCosinesValue();
            if(temp2 < temp1)
            {
                temp1 = temp2;
                returnValue = p;
            }
        }

        return returnValue;
    }
    /*______________________________________________*/

    //functions that handle centroid
    /*______________________________________________*/
    public C_Point getCentroid() {
        return centroid;
    }

    public void setCentroid(C_Point centroid) {
        this.centroid = centroid;
    }
    /*______________________________________________*/

    //access ID
    /*______________________________________________*/
    public int getId() {
        return id;
    }
    /*______________________________________________*/

    //clear list of points in this cluster
    /*______________________________________________*/
    public void clear() {
        points.clear();
    }
    /*______________________________________________*/

    //print cluster in console
    /*______________________________________________*/
    public void plotCluster() {
        System.out.println("[Cluster: " + id+"]");
        System.out.println("[Centroid: " + "(" + centroid.getX() + " , " + centroid.getY() + ")" + "]");
        System.out.println("[Points: \n");
        for(C_Point p : points) {
            System.out.println("x =" + p.getX() + "y =" + p.getY());
        }
        System.out.println("]");
    }
    /*______________________________________________*/

    //use this function for updating center of this cluster after adding points
    /*______________________________________________*/
    public void updateCentroids()
    {
        double sum_x = 0, sum_y = 0;
        for (C_Point p: points)
        {
            sum_x += p.getX();
            sum_y += p.getY();
        }
        centroid.setX(sum_x / points.size());
        centroid.setY(sum_y / points.size());
    }
    /*______________________________________________*/
}
