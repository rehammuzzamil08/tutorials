package com.baeldung.tableformatter;

import java.util.ArrayList;
import java.util.Formatter;
import java.util.List;

import de.vandermeer.asciitable.AsciiTable;
import dnl.utils.text.table.TextTable;

public class TableFormatterExamples {

    private static final String ID = "Id";
    private static final String FULL_NAME = "Full Name";
    private static final String EMAIL_ADDRESS = "Email Address";
    public static void main(String[] args) {
        List<Student> students = getStudentRecords();
        formatUsingJavaFormatter(students);
        formatUsingPrintStream(students);
        formatUsingJTextUtils();
        formatUsingASCIITable(students);
    }

    private static List<Student> getStudentRecords() {
        Student student1 = new Student(1, "Reham Muzzamil", "reham@gmail.com");
        Student student2 = new Student(2, "John Mark", "john@mark.com");
        Student student3 = new Student(3, "Abraham Dales", "ab@dales.com");
        List<Student> students = new ArrayList<>();
        students.add(student1);
        students.add(student2);
        students.add(student3);
        return students;
    }

    private static void formatUsingJavaFormatter(List<Student> students) {
        Formatter formatter = new Formatter();
        formatter.format("%16s %16s %16s %n", ID, FULL_NAME, EMAIL_ADDRESS);
        for (Student s : students) {
            formatter.format("%16d %16s %16s %n", s.getId(), s.getFullName(), s.getEmailAddress());
        }
        System.out.println(formatter);
    }

    private static void formatUsingPrintStream(List<Student> students) {
        System.out.printf("%16s %16s %16s %n", ID, FULL_NAME, EMAIL_ADDRESS);
        for (Student s : students) {
            System.out.printf("%16d %16s %16s %n", s.getId(), s.getFullName(), s.getEmailAddress());
        }
    }

    private static void formatUsingJTextUtils() {
        String[] columnNames = {ID, FULL_NAME, EMAIL_ADDRESS};
        Object[][] studentsData = { { 1, "Reham Muzzamil", "reham@gmail.com" }, { 2, "John Mark", "john@mark.com" }, { 3, "Abraham Dales", "ab@dales.com" } };
        TextTable textTable = new TextTable(columnNames, studentsData);
        textTable.printTable();
    }

    private static void formatUsingASCIITable(List<Student> students) {

        AsciiTable asciiTable = new AsciiTable();
        asciiTable.addRule();
        asciiTable.addRow(ID, FULL_NAME, EMAIL_ADDRESS);
        asciiTable.addRule();
        for (Student student : students) {
            asciiTable.addRow(student.getId(), student.getFullName(), student.getEmailAddress());
            asciiTable.addRule();
        }

        System.out.println(asciiTable.render());
    }

}
