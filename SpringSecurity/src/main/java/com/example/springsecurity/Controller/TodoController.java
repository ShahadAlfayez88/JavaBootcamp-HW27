package com.example.springsecurity.Controller;

import com.example.springsecurity.DTO.Response;
import com.example.springsecurity.Exception.ApiException;
import com.example.springsecurity.Model.MyUser;
import com.example.springsecurity.Model.Todo;
import com.example.springsecurity.Service.TodoService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/todo")
public class TodoController {

    private TodoService todoService;

    @GetMapping("/display")
    public ResponseEntity <List<Todo>> getTodos(@AuthenticationPrincipal MyUser myUser){
        return ResponseEntity.status(200).body(todoService.getTodos(myUser.getId()));
    }

    @PostMapping("/add")
    public ResponseEntity <Response> addTodos(@AuthenticationPrincipal MyUser myUser, @RequestBody Todo todo){
        todoService.addTodo(myUser.getId(),todo);
        return ResponseEntity.status(201).body(new Response("New Todo added !",201));
    }

    @DeleteMapping("/{todoId}")
    public ResponseEntity <Response> deleteTodos(@AuthenticationPrincipal MyUser myUser, @PathVariable Integer todoId){
        todoService.removeTodo(myUser.getId(),todoId);
        return ResponseEntity.status(200).body(new Response("Todo deleted !",200));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateTodo(@RequestBody Todo todo, @PathVariable Integer id, @AuthenticationPrincipal MyUser myUser){
        todoService.updateTodo(id,todo,myUser.getId());
        return ResponseEntity.status(200).body("todo updated");
    }}

