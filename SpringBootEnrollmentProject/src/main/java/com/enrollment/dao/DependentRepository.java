package com.enrollment.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.enrollment.model.Dependent;

@Repository
public interface DependentRepository extends JpaRepository<Dependent, Long> {

	@Query("FROM Dependent d where d.enrollee.id = :enrolleeId")
	public List<Dependent> findByEnrolleeId(@Param("enrolleeId") Long enrolleeId);
}
