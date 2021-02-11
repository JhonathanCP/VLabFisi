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
public class Simulator {
    private Integer idSimulator;
    private Boolean active;
    private String html;
    private Integer idCourse;
    private String courseName;

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }
    private String name;
    private String description;
    
    public Simulator() {
    }

    public Simulator(Integer idSimulator, Boolean active, String html, Integer idCourse, String name, String description) {
        this.idSimulator = idSimulator;
        this.active = active;
        this.html = html;
        this.idCourse = idCourse;
        this.name = name;
        this.description = description;
    }  

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getIdSimulator() {
        return idSimulator;
    }

    public void setIdSimulator(Integer idSimulator) {
        this.idSimulator = idSimulator;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }
    
    public String getHtml() {
        return html;
    }

    public void setHtml(String html) {
        this.html = html;
    }

    public Integer getIdCourse() {
        return idCourse;
    }

    public void setIdCourse(Integer idCourse) {
        this.idCourse = idCourse;
    }
}
