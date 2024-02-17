package com.Mark1.Urvashi.Service;

import com.Mark1.Urvashi.db2Dao.StudentPOJO;

import java.util.List;

public interface StudentService {

    public StudentPOJO getStudent(Long rollNo);
    public List<StudentPOJO> getAllStudent();
    public void saveStudent(StudentPOJO student);
    public void deleteStudent(int rollNo);
}


