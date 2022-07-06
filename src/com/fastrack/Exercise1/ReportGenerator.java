package com.fastrack.Exercise1;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReportGenerator {
    private List<Student> list = new ArrayList<>();
    BufferedWriter writer = new BufferedWriter(new FileWriter("files/grade-report.out"));

    public ReportGenerator(List<Student> list) throws IOException {
        this.list = list;
    }

    public void writeReport () throws IOException {
        writer.write(String.format("%d was the best grade and it was earned by %s", bestStudentGrade().getGrade(), bestStudentGrade().getName()));
        writer.newLine();
        writer.write(String.format("The average grade was %d", averageGrade()));
        writer.newLine();
        writer.write(String.format("%d was the worst grade and it was earned by %s", worstStudentGrade().getGrade(), worstStudentGrade().getName()));
        writer.flush();
    }

    private Student bestStudentGrade(){
        int index = 0;
        int maxGrade = -1;
        for(int i = 0; i < list.size(); i++){
            if(maxGrade < list.get(i).getGrade()){
                maxGrade = list.get(i).getGrade();
                index = i;
            }
        }
        return list.get(index);
    }

    private int averageGrade(){
        int sum = 0;
        for(Student student : list){
            sum += student.getGrade();
        }
        return sum / list.size();
    }

    private Student worstStudentGrade (){
        int index = 0;
        int minGrade = 10;
        for (int i = 0; i < list.size(); i++){
            if(minGrade > list.get(i).getGrade()){
                minGrade = list.get(i).getGrade();
                index = i;
            }
        }
        return list.get(index);
    }
}
