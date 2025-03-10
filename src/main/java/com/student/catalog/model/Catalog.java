package com.student.catalog.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Document(collection = "catalog")
@Data
public class Catalog {
    @Id
    private String id;
    private long studentClass;
    private double fee;

    public Catalog(String id, long studentClass, double fee) {
        this.id = id;
        this.studentClass = studentClass;
        this.fee = fee;
    }
   
}