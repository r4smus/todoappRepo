package com.example.todoapp.repositories;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;

import com.example.todoapp.models.Todo;

@Transactional
public interface TodoRepository extends CrudRepository<Todo, Integer>  {

}
