package com.consult_system.repo;

import com.consult_system.entity.CourseJsonDate;
import com.consult_system.entity.CourseSystem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author jacob
 */
@Repository
public interface CourseSystemRepo extends JpaRepository<CourseJsonDate, Integer> {
//    extends JpaRepository<CourseSystem,Integer>

//    @Query("select a from CourseSystem a where a.keyId=?1")
//    CourseSystem findOneById(Integer id);

    @Query("select a from CourseJsonDate a where a.keyId = ?1 and a.isDeleted = 0")
    CourseJsonDate findOneByKeyId(Integer keyId);

    @Query("select a from CourseJsonDate a where a.isDeleted = 0")
    List<CourseJsonDate> findCourseJsonDateList();

    @Query("select a from CourseJsonDate a where a.courseSystemName = ?1 and a.courseType = ?2 and a.isDeleted = 0")
    List<CourseJsonDate> findList(String courseSystemName, String courseType);
}
