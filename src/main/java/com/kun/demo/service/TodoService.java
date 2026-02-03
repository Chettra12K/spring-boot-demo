package com.kun.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.kun.demo.entity.Todo;
import com.kun.demo.repository.TodoRepository;

@Service
public class TodoService {
    private final TodoRepository todoRepository;
    // Constructor injection (វិធីល្អបំផុត និង recommended ក្នុង Spring Boot សម័យថ្មី)
    public TodoService(TodoRepository todoRepository){
        this.todoRepository = todoRepository;
    }
    // ទាញ todos ទាំងអស់
    public List<Todo> getAllTodos(){
        return todoRepository.findAll();
    }

    // ទាញ todo តាម id
    public Optional<Todo> getTodoById(Long id){
        return todoRepository.findById(id);
    }
    // បង្កើត todo ថ្មី
    public Todo createTodo(Todo todo){
        return todoRepository.save(todo);
    }
    // កែប្រែ todo
    public Todo updateTodo(Long id, Todo updateTodo){
        Todo existingTodo = todoRepository.findById(id).orElseThrow(()-> new RuntimeException("Todo not found with id:"+ id));
        existingTodo.setTask(updateTodo.getTask());
        existingTodo.setCompleted(updateTodo.isCompleted());
        return todoRepository.save(existingTodo);
    }
    // លុប todo
    public void deletTodo(Long id){
        todoRepository.deleteById(id);
    }
    // ទាញតែ completed = true
    public List<Todo> getCompletedTodos(){
        return todoRepository.findByCompleted(true);
    }
    // បន្ថែមបើចង់ (optional)
    public List<Todo>getIncompleteTodo(){
        return todoRepository.findByCompleted(false);
    }
}
