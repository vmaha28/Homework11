package com.fastrack.Exercise1;

import java.io.IOException;
import java.io.File;

public class Main {
    public static void main(String[] args) throws IOException {
        Classroom classroom = new Classroom(new FileReader("files/grades.txt").readStudents());
        ReportGenerator report = new ReportGenerator(new FileReader("files/grades.txt").readStudents());

        report.writeReport();

        System.out.println("Average grade for Computer Science is " + String.format("%.2f", classroom.getAverageGrade("Computer Science")));
        System.out.println("Best grade for Physics is " + classroom.getMaxGrade("Physics"));
        System.out.println("Worst Grade for History is " + classroom.getWorstGrade("History"));
        System.out.println("Best overall grade is " + classroom.getMaxGrade());
        System.out.println("Grades for Mathematics are " + classroom.getGradesForDiscipline("Mathematics"));
        System.out.println("Duilio Marius has the following grades " + classroom.getGradesForStudent("Duilio Marius"));
    }
}
