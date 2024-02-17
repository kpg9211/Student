package com.Mark1.Urvashi.ServiceImpl;

import com.Mark1.Urvashi.db2Dao.StudentPOJO;
import com.Mark1.Urvashi.db2Repository.StudentRepository;
import com.Mark1.Urvashi.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public StudentPOJO getStudent(Long rollNo) {
        System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
        return studentRepository.findById(Math.toIntExact(rollNo)).isPresent()?studentRepository.findById(Math.toIntExact(rollNo)).get():null;
        //return student.isPresent()?student.get():null;
    }

    @Override
    public List<StudentPOJO> getAllStudent() {
        return (List<StudentPOJO>) studentRepository.findAll();
    }

    @Override
    public void saveStudent(StudentPOJO student) {
        studentRepository.save(student);
    }

    @Override
    public void deleteStudent(int rollNo) {

    }
}


