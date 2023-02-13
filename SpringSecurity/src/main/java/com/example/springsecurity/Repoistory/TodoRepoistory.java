package com.example.springsecurity.Repoistory;

import com.example.springsecurity.Model.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TodoRepoistory extends JpaRepository<Todo, Integer> {
    List<Todo> findAllByUserID(Integer userId);

    Todo findTodoById(Integer id);
}
