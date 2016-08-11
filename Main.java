package com.company;

/**
 * Created by morteza on 6/2/16 AD.
 */
public class Main {
    public static void main(String args[]) {
        //define KMean class and adding points to it for testing
        /*______________________________________________*/
        KMean test = new KMean();
        test.setNum_cluster(5);


        C_Point p1 = new C_Point(0.4, 60);
        p1.setDocument_id("0011");
        C_Point p2 = new C_Point(0.01, 90);
        p2.setDocument_id("0012");
        C_Point p3 = new C_Point(0.04, 50);
        p3.setDocument_id("0013");
        C_Point p4 = new C_Point(0.6, 23);
        p4.setDocument_id("0014");
        C_Point p5 = new C_Point(0.12, 12);
        p5.setDocument_id("0015");
        C_Point p6 = new C_Point(0.02, 58);
        p6.setDocument_id("0016");
        C_Point p7 = new C_Point(0.01, 17);
        p7.setDocument_id("0017");
        C_Point p8 = new C_Point(0.3, 52);
        p8.setDocument_id("0018");
        C_Point p9 = new C_Point(0.1, 29);
        p9.setDocument_id("0019");
        C_Point p10 = new C_Point(0.13, 19);
        p10.setDocument_id("0020");
        C_Point p11 = new C_Point(0.8, 49);
        p11.setDocument_id("0021");
        C_Point p12 = new C_Point(0.3, 72);
        p12.setDocument_id("0022");


        test.addPoint(p1);
        test.addPoint(p2);
        test.addPoint(p3);
        test.addPoint(p4);
        test.addPoint(p5);
        test.addPoint(p6);
        test.addPoint(p7);
        test.addPoint(p8);
        test.addPoint(p9);
        test.addPoint(p10);
        test.addPoint(p11);
        test.addPoint(p12);
        /*______________________________________________*/

        //call do function for clustering data by KMean algorithm
        /*______________________________________________*/
        test.do_alg();
        /*______________________________________________*/
        
    }
}
