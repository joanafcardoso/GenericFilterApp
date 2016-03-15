package com.joana.genericfilter.utils;

import java.util.Collection;
import java.util.LinkedList;

/**
 * Created by Cardoso on 15-Mar-16.
 */
public class ListUtils {
    public static <T> LinkedList<T> filter(Collection<T> items, Filter<T> flt) {
        if (items == null || items.isEmpty()) {
            System.out.println("No items in the list");
        }

        LinkedList<T> list = new LinkedList<T>();
        for (T item : items) {
            if (flt.filter(item)) {
                 list.add(item);
            }
        }
        return list;
    }
}