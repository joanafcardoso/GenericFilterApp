package com.joana.genericfilter.utils;

import com.joana.genericfilter.model.Student;

import java.util.*;

/**
 * Created by Cardoso on 15-Mar-16.
 */
public class StudentFilter {

    List<Student> student = Arrays.asList(
                new Student("John", 17.5),
                new Student("Ben", 5.3),
                new Student("Karl", 15.5),
                new Student("Mark", 8.0),
                new Student("Sue", 14.3),
                new Student("Albert", 10.0),
                new Student("Peter", 18.6),
                new Student("Zoe", 11.8),
                new Student("Mary", 9.5));


    LinkedList<Student> stud = ListUtils.filter(student, new Predicate<Student>(){
        @Override
        public boolean evaluate(Student t) {
            return (t.getScore() >= 12);
        }

    });

    private void sortStudentsByScore() {
            Collections.sort(stud, Collections.reverseOrder(new Comparator<Student>() {
                @Override
                public int compare(Student o1, Student o2) {
                    return o1.getScore().compareTo(o2.getScore());
                }
            }));
        }

    private void printStudents(){
            System.out.println("Accepted students");
            System.out.println("Name      " + "Score");
            System.out.println("------    " + "-----");

            for (Student sd : stud)
                System.out.format("%-10s%-4s%n", sd.getName(), sd.getScore());
        }

    public static void main(String[] args) {
        StudentFilter studentFilter = new StudentFilter();
        studentFilter.sortStudentsByScore();
        studentFilter.printStudents();

    }
}