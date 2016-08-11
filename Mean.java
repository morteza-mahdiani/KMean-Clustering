package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
* Created by morteza on 6/2/16 AD.
*/
public class KMean {
    //definitions
    /*______________________________________________*/
    private int num_cluster;
    private int min_bound = 0;
    private int max_bound = 2;
    boolean flag = false;
    int counter = 0;

    private List<C_Point> points;
    private List<Cluster> clusters;
    /*______________________________________________*/

    //definitions of getter and setter and add_point functions
    /*______________________________________________*/
    public int getNum_cluster()
    {
        return num_cluster;
    }

    public List<C_Point> getPoints()
    {
        return points;
    }

    public void setNum_cluster(int numberOfClusters)
    {
        num_cluster = numberOfClusters;
    }

    public List<Cluster> getClusters()
    {
        return clusters;
    }

    public void addPoint(C_Point point) {
        points.add(point);
    }
    /*______________________________________________*/

    //definitions of search function
    /*______________________________________________*/
    public C_Point searchBestVector(double cosinesValue)
    {
        double temp1 = Double.POSITIVE_INFINITY;
        Cluster returnValue = new Cluster();
        for(Cluster c : clusters)
        {
                double temp2 = cosinesValue - c.getCentroid().getCosinesValue();
                if (temp2 < temp1) {
                    temp1 = temp2;
                    returnValue = c;
                }
        }

        C_Point test =  returnValue.nearestPointInCluster(cosinesValue);
//        for(Cluster c: clusters)
//        {
//            c.getCentroid().getX()
//        }
        return test;
    }
    /*______________________________________________*/

    //constructor
    /*______________________________________________*/
    public KMean() {
        this.points = new ArrayList();
        this.clusters = new ArrayList();
    }
    /*______________________________________________*/

    //generating random centroids for each cluster
    /*______________________________________________*/
    public C_Point createRandomPoint(int min_bound, int max_bound)
    {
        Random r = new Random();
        double x = min_bound + (max_bound - min_bound) * r.nextDouble();
        double y = min_bound + (max_bound - min_bound) * r.nextDouble();

        return new C_Point(x, y);
    }

    public void setCentroids()
    {
        Cluster temp = new Cluster();
        temp.setCentroid(createRandomPoint(min_bound, max_bound));
        clusters.add(temp);
    }
    /*______________________________________________*/

    //this function calculate the distance between two points
    /*______________________________________________*/
    public double distance(C_Point p, C_Point centroid)
    {
        return Math.sqrt(Math.pow((centroid.getX() - p.getX()), 2) + Math.pow((centroid.getY() - p.getY()), 2) );
    }
    /*______________________________________________*/

    //this function adds points to cluster according to their distance from centroid of cluster
    /*______________________________________________*/
    public void addPointsToClusters()
    {
        for (C_Point p: points)
        {
            double temp = Double.POSITIVE_INFINITY;
            int temp_id = -1 ;

            for (Cluster c: clusters)
            {
                if(distance(p, c.getCentroid()) < temp)
                {
                    temp = distance(p, c.getCentroid());
                    temp_id = c.getId();
                    flag = true;
                }
            }

            if (flag)
            {
                clusters.get(temp_id).addPoint(p);
                flag = false;
            }
        }
    }
    /*______________________________________________*/

    //this function do steps of KMean algorithm___________________________________
    //first: calculating centroids with setCentroids function_____________________
    //second: adding points to clusters and updating centroids with while loop____
    //third: after last updating points add to proper clusters____________________
    //fourth: print clusters with plot function___________________________________
    /*______________________________________________*/
    public void do_alg ()
    {
        for (int i = 1; i <= num_cluster; i++ )
            this.setCentroids();

        while (counter != num_cluster)
        {
            addPointsToClusters();

            int temp_x = 0, temp_y = 0;
            counter = 0;
            for (Cluster c: clusters)
            {
                temp_x = (int)c.getCentroid().getX() * 100 ;
                temp_y = (int)c.getCentroid().getY() * 100 ;

                c.updateCentroids();
                c.clear();
                if (temp_x == ((int)c.getCentroid().getX() * 100) && (temp_y == (int)c.getCentroid().getY() * 100))
                {
                    counter++;
                }
            }
        }

        addPointsToClusters();

        for (Cluster c: clusters)
        {
            c.plotCluster();
        }

    }
    /*______________________________________________*/
}
