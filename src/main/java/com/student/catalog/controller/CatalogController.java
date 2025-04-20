package com.student.catalog.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.student.catalog.model.Catalog;
import com.student.catalog.service.CatalogService;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@RestController
@RequestMapping("/catalog")
public class CatalogController {

    private final CatalogService catalogService;

    public CatalogController(CatalogService catalogService) {
        this.catalogService = catalogService;
    }

    @PostMapping
    @CircuitBreaker(name = "catalog-service", fallbackMethod = "fallbackAddCourse")
    public ResponseEntity<Catalog> addCourse(@RequestBody Catalog catalog) {
        return ResponseEntity.ok(catalogService.addCourse(catalog));
    }

    public ResponseEntity<Catalog> fallbackAddCourse(Catalog catalog, Throwable ex) {
        return ResponseEntity.status(503).body(null);
    }
    
    @GetMapping
    public ResponseEntity<List<Catalog>> getAllCourses() {
        return ResponseEntity.ok(catalogService.getAllCourses());
    }

    @GetMapping("course/{courseCode}")
    public ResponseEntity<Catalog> getCourseByCCode(@PathVariable String courseCode) {
        return ResponseEntity.ok(catalogService.getCourseByCode(courseCode));
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Catalog> getCourse(@PathVariable long id) {
        return ResponseEntity.ok(catalogService.getById(id));
    }


    @PutMapping("/{courseCode}")
    public ResponseEntity<Catalog> updateCourse(@PathVariable String courseCode, @RequestBody Catalog updatedCatalog) {
        return ResponseEntity.ok(catalogService.updateCourse(courseCode, updatedCatalog));
    }

    @DeleteMapping("/{courseCode}")
    public ResponseEntity<Void> deleteCourse(@PathVariable String courseCode) {
        catalogService.deleteCourse(courseCode);
        return ResponseEntity.noContent().build();
    }
}
