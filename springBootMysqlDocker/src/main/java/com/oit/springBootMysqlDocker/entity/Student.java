package com.oit.springBootMysqlDocker.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity // Add the entity annotation
@Data // Add the data annotation for getters, setters, and more
@NoArgsConstructor // Add the no-args constructor annotation
@AllArgsConstructor // Add the all-args constructor annotation
@Table(name = "student")
public class Student {
  @Id
  @GeneratedValue(strategy =  GenerationType.IDENTITY)
  private int id;
  private String name;
  private int age;
}
