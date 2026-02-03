package com.kun.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;


@Entity
public class Todo {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;
    
    @NotBlank(message="Task មិនអាចទទេ ឬមានតែ space បានទេ")
    @Size(min=3,max=200, message= "Task ត្រូវមានចន្លោះពី ៣​ ទៅ ២០០ តួអក្សរ")
    private String task;

    private boolean completed = false;
    // Constructors
    public Todo(){}
    public Todo (String task){
        this.task = task;
    }
    //Getter & Setters
    public long  getId(){return  id;}
    public void setId(long id){this.id = id;}

    public String getTask(){return task;}
    public void setTask(String task){this.task = task;}

    public boolean isCompleted(){return completed;}
    public void setCompleted(boolean completed){this.completed = completed;}


}
