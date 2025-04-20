package com.student.catalog.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.student.catalog.model.Catalog;

@Repository
public interface CatalogRepository extends JpaRepository<Catalog, Long> {
	@Query("SELECT c FROM Catalog c WHERE c.courseCode = :courseCode")
	Optional<Catalog> findByCourseCode(@Param("courseCode") String courseCode);

	@Modifying
	@Query("DELETE FROM Catalog c WHERE c.courseCode = :courseCode")
	void deleteByCourseCode(@Param("courseCode") String courseCode);

}
