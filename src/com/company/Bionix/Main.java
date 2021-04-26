package com.company.Bionix;


import com.company.Bionix.print.BaseOnStudentConvertAndPrint;

import java.util.*;

public class Main {

    private static ArrayList<Student> students = new ArrayList();

    public static void main(String[] args) {

//        Comparator<Student> comparator;
//        comparator = Student.defaultComparator();
//        Student student1 = new Student("Eric", 23);
//        Student student2 = new Student("Conor",  25);
//        int result = comparator.compare(student1, student2);
//        Student[] students = new Student[2];
//        students[0] = student1;
//        students[1] = student2;
//        Arrays.sort(students, Student.comparatorByName());
//        System.out.println(student1.name);

        Student student1 = new Student("Conor", 23);
        Student student2 = new Student("Erica", 21);
        Student student3 = new Student("Pon", 22);
        Student student4 = new Student("Pon", 23);

        students.add(student1);
        students.add(student2);
        students.add(student3);
        students.add(student4);
        System.out.println(students.get(2).name + " , " + students.get(2).age);

        Collections.sort(students, student1.comparatorNamePar);
//        Collections.sort(students, Student.comparatorByName());
//        System.out.println(student1.comparatorNamePar.compare(student3,student4));

        print(students);

        System.out.println("............................IStudentStringConverter AND  IStudentPrinter ..........................");

        BaseOnStudentConvertAndPrint student = new BaseOnStudentConvertAndPrint();
        student.setFirstName("Mitchel");
        student.setId(1);
        student.setAverageMark(11.3);
        student.setGroupId(12);
        student.setFaculty("Medicine");

        student.consoleJson.print(student);
        student.consoleXml.print(student);
        student.consoleSimple.print(student);
        student.consoleEmpty.print(student);
        System.out.println("............................delegating ..........................");
        student.delegatingStudentPrinter.print(student);

    }

    public static void print(Collection collection) {
        System.out.println();
        Iterator<Student> studentIterator = students.iterator();
        {
            while (studentIterator.hasNext()) {
                Student student = studentIterator.next();
                System.out.println(student.name + ", " + student.age);
            }
        }
    }
}