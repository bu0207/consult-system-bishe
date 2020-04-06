package com.consult_system.repo;

import com.consult_system.entity.TrainDirection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TrainDirectionRepo extends JpaRepository<TrainDirection,Integer> {
    @Query("select a from TrainDirection a where a.isDeleted=0")
    List<TrainDirection> getAllTrainDirection();

    @Query("select a from TrainDirection a where a.keyId=?1 and a.isDeleted=0")
    TrainDirection findByKeyId(Integer id);
}
