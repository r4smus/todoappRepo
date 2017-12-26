package com.example.todoapp.models;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.validation.constraints.Size;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;



@JsonIgnoreProperties(value = {"createdAt"}, allowGetters = true)
@Entity
public class Todo {
    
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    
    @NotNull
    @Size(max=100)
    private String title;
    
    private Boolean completed = false;
    
    private Date createdAt = new Date();
    
    public Todo() {
        super();
    }
    
    public Todo(String title) {
        this.title = title;
    }
    
    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public String getTitle() {
        return title;
    }
    
    public void setTitle(String title) {
        this.title = title;
    }
    
    public Boolean getCompleted() {
        return completed;
    }
    
    public void setCompleted(Boolean completed) {
        this.completed = completed;
    }
    
    public Date getCreatedAt() {
        return createdAt;
    }
    
    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
    
    @Override
    public String toString() {
        return String.format(
                "Todo[id=%s, title='%s', completed='%s']",
                id, title, completed);
    }
}
