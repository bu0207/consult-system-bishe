package com.consult_system.repo;

import com.consult_system.entity.TrainProgram;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TrainProgramRepo extends JpaRepository<TrainProgram, Integer> {

    @Query("select d from TrainProgram d where d.isDeleted=0")
    List<TrainProgram> trainProgramPageInit();

}
