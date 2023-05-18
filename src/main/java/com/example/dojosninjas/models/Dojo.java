package com.example.dojosninjas.models;

import java.util.Date;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

//...
@Entity
@Table(name="dojos")
public class Dojo {
 
 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 private Long id;
 private String name;
 @Column(updatable=false)
 private Date createdAt;
 private Date updatedAt;
 @OneToMany(mappedBy="dojo", fetch = FetchType.LAZY)
 private List<Ninja> ninjas;
 
 public Dojo() {
     
 }
 // ...
 // getters y setters removidos para resumir.
 // ...
}

