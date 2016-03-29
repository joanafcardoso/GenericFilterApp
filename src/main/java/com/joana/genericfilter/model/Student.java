package com.joana.genericfilter.model;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 * Created by Cardoso on 14-Mar-16.
 */
public class Student {
    private String name;
    private double score;


    public Student(String name, double score) {
        this.name = name;
        this.score = score;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getScore() {
        return this.score;
    }

    public void setScore(double score) {
        this.score = score;
    }

}
