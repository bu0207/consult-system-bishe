package com.consult_system.repo;

import com.consult_system.entity.Grade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface GradeRepo extends JpaRepository<Grade, Integer> {

    @Query("select a from Grade a where a.isDeleted=0")
    List<Grade> getGradeAll();
}
