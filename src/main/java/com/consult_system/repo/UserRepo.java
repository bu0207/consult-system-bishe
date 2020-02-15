package com.consult_system.repo;

import com.consult_system.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface UserRepo extends JpaRepository<User, Integer> {

    @Query("select a from User a")
    List<User> findAllBy();

    @Query("select t from User t where t.studentId=?1 and t.isDeleted=0")
    List<User> findUserByStudentId(String studentId);

    @Query("select t from User t where t.password=?1 and t.studentId=?2 and t.role=?3 and t.isDeleted=0")
    List<User> findUserInfo(String password, String studentId, String role);
}
