package com.student.catalog.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.student.catalog.model.Catalog;
import com.student.catalog.repository.CatalogRepository;

import jakarta.transaction.Transactional;

@Service
public class CatalogService {

    private final CatalogRepository catalogRepository;

    public CatalogService(CatalogRepository catalogRepository) {
        this.catalogRepository = catalogRepository;
    }

    public Catalog addCourse(Catalog catalog) {
        return catalogRepository.save(catalog);
    }

    public List<Catalog> getAllCourses() {
        return catalogRepository.findAll();
    }

    public Catalog getCourseByCode(String courseCode) {
        return catalogRepository.findByCourseCode(courseCode)
                .orElseThrow(() -> new RuntimeException("Course not found"));
    }
    
    public Catalog getCourseById(long courseId) {
        return catalogRepository.findById(courseId)
                .orElseThrow(() -> new RuntimeException("Course not found"));
    }

    @Transactional
    public Catalog updateCourse(String courseCode, Catalog updatedCatalog) {
        Optional<Catalog> existingCourse = catalogRepository.findByCourseCode(courseCode);
        if (existingCourse.isPresent()) {
            updatedCatalog.setId(existingCourse.get().getId());
            return catalogRepository.save(updatedCatalog);
        } else {
            throw new RuntimeException("Course not found");
        }
    }

    @Transactional
    public void deleteCourse(String courseCode) {
        catalogRepository.deleteByCourseCode(courseCode);
    }

	public Catalog getById(long id) {
		return catalogRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Course not found"));
	}
}
