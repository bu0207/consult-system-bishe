package com.consult_system.repo;

import com.consult_system.entity.SystemDevelopDirection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author jacob
 * @date 2020/3/22
 */

@Repository
public interface SystemDevelopDirectionRepo extends JpaRepository<SystemDevelopDirection,Integer> {
    @Query("select a from SystemDevelopDirection a where a.trainDirectionId = ?1")
    List<SystemDevelopDirection> findAllByTrainDirectionId(Integer trainDirectionId);
}
