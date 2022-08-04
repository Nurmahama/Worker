package com.Worker.Rich_Group;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity (name = "worker")
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
   private Long id;
    private    String name;
    private String surname;
   private String Day_of_birth;
    private String job_title;
    private int salary;
   private String start_date_work;
    private String information;


}
