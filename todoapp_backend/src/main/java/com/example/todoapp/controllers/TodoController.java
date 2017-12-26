package com.example.todoapp.controllers;

import javax.validation.Valid;
import com.example.todoapp.models.Todo;
import com.example.todoapp.repositories.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class TodoController {

    @Autowired
    TodoRepository todoRepository;

    @GetMapping("/todos")
    public Iterable<Todo> getAllTodos() {
        return todoRepository.findAll();
    }

    @PostMapping("/todos")
    public Todo createTodo(@Valid @RequestBody Todo todo) {
        todo.setCompleted(false);
        return todoRepository.save(todo);
    }

    @GetMapping(value="/todos/{id}")
    public ResponseEntity<Todo> getTodoById(@PathVariable("id") Integer id) {
        Todo todo = todoRepository.findOne(id);
        if(todo == null) {
            return new ResponseEntity<Todo>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<Todo>(todo, HttpStatus.OK);
        }
    }

    @PutMapping(value="/todos/{id}")
    public ResponseEntity<Todo> updateTodo(@PathVariable("id") Integer id,
                                           @Valid @RequestBody Todo todo) {
        Todo todoData = todoRepository.findOne(id);
        if(todoData == null) {
            return new ResponseEntity<Todo>(HttpStatus.NOT_FOUND);
        }
        todoData.setTitle(todo.getTitle());
        todoData.setCompleted(todo.getCompleted());
        Todo updatedTodo = todoRepository.save(todoData);
        return new ResponseEntity<Todo>(updatedTodo, HttpStatus.OK);
    }

    @DeleteMapping(value="/todos/{id}")
    public void deleteTodo(@PathVariable("id") Integer id) {
        todoRepository.delete(id);
    }
}