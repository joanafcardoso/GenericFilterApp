package com.joana.genericfilter.utils;

import com.joana.genericfilter.model.Student;
import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by Cardoso on 29-Mar-16.
 */
public class ListUtilsTest {

    @Test
    public void testShouldSelectOne() {

        List<Student> student = Arrays.asList(
                new Student("John", 17.5),
                new Student("Ben", 5.3),
                new Student("Karl", 15.5));

        List<Student> stud = ListUtils.filter(student, new Predicate<Student>() {
            @Override
            public boolean evaluate(Student stud) {
                if (stud.getScore() >= 12) {
                    return true;
                }
                return false;
            }
        });
        assertEquals(Double.valueOf(17.5), stud.get(0).getScore());
        assertEquals(stud.size(), 2);
    }

    @Test
    public void testShouldSelectAll() {

        List<Student> student = Arrays.asList(
                new Student("John", 17.5),
                new Student("Ben", 5.3),
                new Student("Karl", 15.5));

        List<Student> stud = ListUtils.filter(student, new Predicate<Student>() {
            @Override
            public boolean evaluate(Student stud) {
                if (stud.getScore() >= 5) {
                    return true;
                }
                return false;
            }
        });
        assertEquals(student.size(), stud.size());
        assertEquals(student, stud);
    }

    @Test
    public void testShouldSelectNone() throws Exception {

        List<Student> student = Arrays.asList(
                new Student("John", 17.5),
                new Student("Ben", 5.3),
                new Student("Karl", 15.5));

        List<Student> stud = ListUtils.filter(student, new Predicate<Student>() {
            @Override
            public boolean evaluate(Student stud) {
                if (stud.getScore() >= 18) {
                    return true;
                }
                return false;
            }
        });
        assertEquals(stud.size(), 0);

        List<Student> empty = new ArrayList<>();
        List<Student> emptyList = ListUtils.filter(empty, new Predicate<Student>() {
            @Override
            public boolean evaluate(Student stud) {
                return false;
            }
        });
        assertTrue("No items in the list", emptyList == null);
    }

    @Test
    public void testShouldReturnNull() {

        List<Student> student = new ArrayList<>();

        List<Student> stud = ListUtils.filter(student, new Predicate<Student>() {
            @Override
            public boolean evaluate(Student stud) {
                if (stud.getScore() <= 12) {
                    return true;
                }
                return false;
            }
        });
        assertEquals(stud, null);

        List<Student> student2 = null;
        List<Student> stud2 = ListUtils.filter(student2, new Predicate<Student>() {
            @Override
            public boolean evaluate(Student stud2) {
                if (stud2.getScore() <= 12) {
                    return true;
                }
                return false;
            }
        });
        assertEquals(stud2, null);
    }

    @Test
    public void testConstructorIsPrivate() throws NoSuchMethodException, IllegalAccessException,
            InvocationTargetException, InstantiationException {
        Constructor<ListUtils> constructor = ListUtils.class.getDeclaredConstructor();
        assertTrue(Modifier.isPrivate(constructor.getModifiers()));
        constructor.setAccessible(true);
        constructor.newInstance();
    }
}