package com.consult_system.repo;

import com.consult_system.entity.SystemDevelopJob;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SystemDevelopJobRepo extends JpaRepository<SystemDevelopJob,Integer> {

    @Query("select a from SystemDevelopJob a where a.systemDevelopDirectionId = ?1")
    List<SystemDevelopJob> findAllBySystemDevelopDirectionId(Integer systemDevelopDirectionId);
}
