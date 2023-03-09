package com.example.demo.Repository;

import com.example.demo.Entity.CitizenEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CitizenRepository extends JpaRepository<CitizenEntity, Integer> {

    @Query(value = "SELECT c.name FROM citizens c WHERE c.adhar=:a", nativeQuery = true)
    String findNameByAdhar(@Param("a") String adharNo);
    @Query(value = "SELECT c.pan_no FROM citizens c WHERE c.adhar=:a", nativeQuery = true)
    String findPanByAdhar(@Param("a") String adharNo);
    @Query(value = "SELECT c.adhar FROM citizens c WHERE c.pan_no=:a", nativeQuery = true)
    String findAdharByPanNo(@Param("a") String panNo);
    @Query(value = "SELECT c.name FROM citizens c WHERE c.pan_no=:a", nativeQuery = true)
    String findNameByPanNo(@Param("a") String panNo);
}
