package com.kun.demo.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kun.demo.entity.Todo;
import com.kun.demo.exception.TodoNotFoundException;
import com.kun.demo.service.TodoService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/todos")
public class TodoController {
    // @Autowired
    // private TodoRepository todoRepository;
    private final TodoService todoService;
    //Constructor injection
    public TodoController(TodoService todoService){
        this.todoService = todoService;
    }
    // GET all todos
    @GetMapping
    public List<Todo> getAllTodos(){
        return todoService.getAllTodos();
    }
  //Get one todo by id
    @GetMapping("/{id}")
    public Todo getTodoById(@PathVariable Long id){
        return todoService.getTodoById(id)
            .orElseThrow(() -> new TodoNotFoundException(id));
    }

    //POST new todo
    @PostMapping
    public Todo createTodo(@Valid @RequestBody Todo todo){
        return todoService.createTodo(todo);
    }
  

    //PUT update todo
    @PutMapping("/{id}")
    public Todo updateTodo(@Valid @PathVariable long id, @RequestBody Todo updateTodo){
        return todoService.updateTodo(id, updateTodo);
    }

    //DELECT todo
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTodo(@PathVariable Long id){
        todoService.deletTodo(id);
        return ResponseEntity.noContent().build();
    }
        
    @GetMapping("/completed")
    public List<Todo> getCompletedTodos(){
        return todoService.getCompletedTodos();
    }
}
