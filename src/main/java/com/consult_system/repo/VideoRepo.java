package com.consult_system.repo;

import com.consult_system.entity.Video;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VideoRepo extends JpaRepository<Video,Integer> {

    @Query("select a from Video a where a.isDeleted = 0 and a.keyId = ?1")
    Video findOneByKeyId(Integer id);

    @Query("select a from Video a where a.isDeleted = 0")
    List<Video> findList();
}
