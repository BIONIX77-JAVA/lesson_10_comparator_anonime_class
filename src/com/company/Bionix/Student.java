package com.company.Bionix;

import java.util.Comparator;
import java.util.Objects;

public class Student implements Comparator<Student> {

    public String name;
    public int age;

    public Student(String name) {
        this.name = name;
    }

    public Student(String name, int age) {
        this.name = name;
        this.age = age;

    }

    public static Comparator<Student> defaultComparator() {
        return new DefaultComparator();
    }

    public static Comparator<Student> comparatorByName() {
        return new ComparatorByName();
    }

    public static Comparator<Student> comparatorByAge() {
        return new ComparatorByAge();
    }


    private static class DefaultComparator implements Comparator<Student> {
        @Override
        public int compare(Student student1, Student student2) {
            int nameComp = student1.name.compareTo(student2.name);
            if (nameComp != 0) {
                return nameComp;
            } else {
                return Integer.compare(student1.age, student2.age);
            }
        }
    }

    private static class ComparatorByAge implements Comparator<Student> {
        @Override
        public int compare(Student student1, Student student2) {
            Integer st1 = student1.age;
            Integer st2 = student2.age;
            return st1.compareTo(st2);
        }
    }

    private static class ComparatorByName implements Comparator<Student> {
        @Override
        public int compare(Student student1, Student student2) {
            String name1 = student1.name;
            String name2 = student2.name;
            return name1.compareTo(name2);
        }
    }

    Comparator<Student> comparatorTwoPar = new Comparator<Student>() {
        @Override
        public int compare(Student student1, Student student2) {
            int nameComp = student1.name.compareTo(student2.name);
            if (nameComp != 0) {
                return nameComp;
            } else {
                return Integer.compare(student1.age, student2.age);
            }
        }
    };

    Comparator<Student> comparatorNamePar= new Comparator<Student>() {
        @Override
        public int compare(Student student1, Student student2) {
            return student1.name.compareTo(student2.name);
        }
    };

    Comparator<Student> comparatorAgePar = new Comparator<Student>() {
        @Override
        public int compare(Student student1, Student student2) {
            return Integer.compare(student1.age, student2.age);
        }
    };

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Student)) return false;
        Student student = (Student) o;
        return getAge() == student.getAge() && Objects.equals(getName(), student.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getAge());
    }

    @Override
    public int compare(Student student1, Student student2) {
        return student1.name.compareTo(student2.name);
    }


}