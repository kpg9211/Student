package com.Mark1.Urvashi.ServiceImpl;

import com.Mark1.Urvashi.db2Dao.StudentPOJO;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class StudentConfiguration {

    List<StudentPOJO> studentList= new ArrayList<>();

    public StudentPOJO createStudent(int i){
        StudentPOJO studentPOJO= new StudentPOJO();
        studentPOJO.setFirstName("Kartik"+i);
        studentPOJO.setLastName("aryan");
        studentPOJO.setStandard("0"+i);
        studentPOJO.setSection(i%2==0?"A":"B");


        return studentPOJO;
    }
}


