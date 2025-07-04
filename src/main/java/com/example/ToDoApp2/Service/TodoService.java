package com.example.ToDoApp2.Service;

import com.example.ToDoApp2.Model.Todo;
import com.example.ToDoApp2.Model.User;
import com.example.ToDoApp2.Repository.ToDoRepository;
import com.example.ToDoApp2.Repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoService {

    @Autowired
    private ToDoRepository repo;

    @Autowired
    private UserRepo userRepo;

    public List<Todo> getAll() {
        return repo.findAll();
    }


    public List<Todo> findByUsername(String username) {
        User user = userRepo.findByUsername(username);

        return repo.findByUser(user);
    }
}
