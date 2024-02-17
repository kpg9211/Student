package com.Mark1.Urvashi.db2Repository;

import com.Mark1.Urvashi.db2Dao.StudentPOJO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<StudentPOJO,Integer> {
}


