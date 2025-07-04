package com.example.ToDoApp2.Controller;

import com.example.ToDoApp2.Model.Todo;
import com.example.ToDoApp2.Service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/todos")
public class TodoController {

    @Autowired
    private TodoService service;

    @GetMapping
    public List<Todo> getAll() {

       return service.getAll();
    }


    @GetMapping
    public List<Todo> getUserTodos(Authentication authentication) {
        String username = authentication.getName();
        return service.findByUsername(username);
    }
}
