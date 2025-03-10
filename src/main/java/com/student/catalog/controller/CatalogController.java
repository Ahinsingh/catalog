package com.student.catalog.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.student.catalog.model.Catalog;
import com.student.catalog.repository.CatalogRepository;

@RestController
@RequestMapping("/catalog")
public class CatalogController {
	
    @Autowired
    private CatalogRepository catalogRepository;

    @PostMapping
    public ResponseEntity<?> createCatalog(@RequestBody Catalog catalog) {
        Catalog savedPayment = catalogRepository.save(catalog);
        return ResponseEntity.ok(savedPayment);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Catalog> getCatalogById(@PathVariable double id) {
        Optional<Catalog> student = catalogRepository.findByStudentClass(id);
        return student.map(ResponseEntity::ok)
                      .orElseGet(() -> ResponseEntity.notFound().build());
    }
    
    @GetMapping
    public ResponseEntity<List<Catalog>> getCatalogs() {
        List<Catalog> catalogs = catalogRepository.findAll();
        return catalogs.isEmpty() ? ResponseEntity.notFound().build() : ResponseEntity.ok(catalogs);
    }
    
}