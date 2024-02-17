package com.Mark1.Urvashi.Controller;

import com.Mark1.Urvashi.db2Dao.StudentPOJO;
import com.Mark1.Urvashi.Service.StudentService;
import com.Mark1.Urvashi.ServiceImpl.StudentConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Student")
public class StudentController {


    @Autowired
    private StudentService studentService;
    @Autowired
    StudentConfiguration studentConfiguration;


    @GetMapping("/getById/{rollNo}")
    public ResponseEntity<StudentPOJO> getStudent(@PathVariable("rollNo") Long rollNo){
        System.out.println("11111111111111111111111111111111111111111");
        StudentPOJO studentPOJO = studentService.getStudent(rollNo);
        return studentPOJO==null? new ResponseEntity<>(null,HttpStatus.NOT_FOUND):
                new ResponseEntity<>(studentPOJO, HttpStatus.OK);
    }

    @PutMapping("/saveStudent/{i}")
    public void saveStudent(@PathVariable int i){
        StudentPOJO student= studentConfiguration.createStudent(i);
        studentService.saveStudent(student);
    }


}


