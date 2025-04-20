package com.student.catalog.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "course")
public class Course {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String subCourseCode;   // Unique Subject ID (e.g., MATH101)
    private String subCourseName;  
    private String subCourseDesc;
    private double subCourseFee;    // Associated Department (e.g., Mathematics)
    private int credits;          // Subject Credits
}
