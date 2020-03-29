package com.consult_system.repo;

import com.consult_system.entity.TrainDirection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TrainDirectionRepo extends JpaRepository<TrainDirection,Integer> {
    @Query("select a from TrainDirection a")
    List<TrainDirection> getAllTrainDirection();

    @Query("select a from TrainDirection a where a.keyId=?1")
    TrainDirection findByKeyId(Integer id);
}
