package com.company;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by morteza on 6/2/16 AD.
 */
public class idGenerator {
    //definition
    /*______________________________________________*/
    private static final AtomicInteger counter = new AtomicInteger();
    /*______________________________________________*/

    //this function generate int values as ID
    /*______________________________________________*/
    public int nextValue() {
        return counter.getAndIncrement();
    }
    /*______________________________________________*/
}
