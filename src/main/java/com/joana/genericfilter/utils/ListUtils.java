package com.joana.genericfilter.utils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Cardoso on 15-Mar-16.
 */
public class ListUtils {

    private ListUtils(){
    };

    public static <T> List<T> filter(List<T> items, Predicate<T> predicate) {
        if (items == null || items.isEmpty()) {
            System.out.println("No items in the list");
            return null;
        }

        List<T> list = new ArrayList<T>();
        for (T item : items) {
            if (predicate.evaluate(item)) {
                 list.add(item);
            }
        }
        return list;
    }
}
