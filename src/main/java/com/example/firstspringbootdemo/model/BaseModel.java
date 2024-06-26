package com.example.firstspringbootdemo.model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@MappedSuperclass

public class BaseModel {
    //Base Model
    @Id // this will create PK for the table
    //now we have to create a PK which shou;d be Unique so hibernate also take care of it
    @GeneratedValue(strategy = GenerationType.AUTO)//this will automatically create PK and make sure each PK is unique
    private long id;
    private Date createdAt;
    private Date updatedAt;
    private boolean isDeleted;

}
