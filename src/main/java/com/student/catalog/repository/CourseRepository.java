package com.student.catalog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.student.catalog.model.Course;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {
}