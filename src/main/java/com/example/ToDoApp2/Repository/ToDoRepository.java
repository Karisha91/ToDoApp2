package com.example.ToDoApp2.Repository;

import com.example.ToDoApp2.Model.Todo;
import com.example.ToDoApp2.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ToDoRepository extends JpaRepository<Todo, Integer> {

    List<Todo> findByUser(User user);
}
