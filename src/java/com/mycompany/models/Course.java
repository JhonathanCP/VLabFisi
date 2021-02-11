/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.models;

/**
 *
 * @author centt
 */
public class Course {
    private Integer idCourse;
    private String name;
    
    public Course(){}
    public Course(Integer idCourse, String name){
        this.idCourse = idCourse;
        this.name = name;
    }
    public Integer getIdCourse() {
        return idCourse;
    }

    public void setIdCourse(Integer idCourse) {
        this.idCourse = idCourse;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
