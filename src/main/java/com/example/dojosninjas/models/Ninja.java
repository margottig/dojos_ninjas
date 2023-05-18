package com.example.dojosninjas.models;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

//..
@Entity
@Table(name="ninjas")
public class Ninja {
 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 private Long id;
 private String firstName;
 private String lastName;
 private int age;
 @Column(updatable=false)
 private Date createdAt;
 private Date updatedAt;
 @ManyToOne(fetch = FetchType.LAZY)
 @JoinColumn(name="dojo_id")
 private Dojo dojo;
 
 public Ninja() {
     
 }
 // ...
 // getters y setters removidos para resumir.
 // ...
}

