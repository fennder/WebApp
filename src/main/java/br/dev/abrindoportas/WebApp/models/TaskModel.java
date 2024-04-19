package br.dev.abrindoportas.WebApp.models;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class TaskModel {
    
    private Long id;
    private String name;
    @DateTimeFormat(pattern = "dd/MM/yyyy HH:mm:ss")
    private Date date;

    public TaskModel(Long id, String name, Date date){
        this.id = id;
        this.name = name;
        this.date = date;
    }

    public TaskModel() {

    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Date getDate() {
        return date;
    }
    public void setDate(Date date) {
        this.date = date;
    }

}
