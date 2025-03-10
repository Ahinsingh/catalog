package com.student.catalog.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.student.catalog.model.Catalog;

@Repository
public interface CatalogRepository extends MongoRepository<Catalog, String> {

	Optional<Catalog> findByStudentClass(double studentClass);

}
