package com.example.springsecurity.Service;

import com.example.springsecurity.Exception.ApiException;
import com.example.springsecurity.Model.MyUser;
import com.example.springsecurity.Model.Todo;
import com.example.springsecurity.Repoistory.MyUserRepository;
import com.example.springsecurity.Repoistory.TodoRepoistory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class TodoService {

    private final TodoRepoistory todoRepository;

    private final MyUserRepository myUserRepository;


    public List<Todo> getTodos(Integer id) {
        return todoRepository.findAllByUserID(id);
    }

    public void addTodo(Integer id,Todo todo) {
        todo.setUserID(id);
        todoRepository.save(todo);
    }

    public void removeTodo(Integer userId, Integer todoId) {
        Todo todo=todoRepository.findById(todoId).get();

        if(todo.getId()!=userId){
            return;
        }

        todoRepository.deleteById(todoId);
    }

    public void updateTodo(Integer id , Todo newTodo , Integer auth){

        Todo oldTodo=todoRepository.findTodoById(id);

        if (oldTodo==null){
            throw new ApiException("Todo not found");}
        oldTodo.setMessage(newTodo.getMessage());
        todoRepository.save(oldTodo);
    }}

//        updatedTodo.setMyUser(myUser);



