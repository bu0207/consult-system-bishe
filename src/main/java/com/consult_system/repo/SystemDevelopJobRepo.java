package com.consult_system.repo;

import com.consult_system.entity.SystemDevelopJob;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SystemDevelopJobRepo extends JpaRepository<SystemDevelopJob,Integer> {

    @Query("select a from SystemDevelopJob a where a.systemDevelopDirectionId = ?1 and a.isDeleted = 0")
    List<SystemDevelopJob> findAllBySystemDevelopDirectionId(Integer systemDevelopDirectionId);

    @Query("select a from SystemDevelopJob a where a.keyId = ?1 and a.isDeleted = 0")
    SystemDevelopJob findByJobId(Integer id);

    @Query("select  a from SystemDevelopJob a where a.isDeleted = 0")
    Page<SystemDevelopJob> queryAllList(Pageable pageable);

    @Query(value = "select * from system_develop_job a " +
            "where a.is_deleted = 0",
            countQuery = "select  count(1) from system_develop_job a " +
                    "where a.is_deleted = 0",
            nativeQuery = true
    )
    Page<SystemDevelopJob> queryByPage(Pageable pageable);
}
