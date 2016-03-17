package com.joana.genericfilter.utils;

/**
 * Created by Cardoso on 14-Mar-16.
 */
public interface Predicate <T> {
    boolean evaluate (T t);
}
