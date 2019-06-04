package com.ethanaa.todo.service;

import com.ethanaa.todo.model.Todo;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@Service
public class TodoService {

    private Map<Long, Todo> todos = new HashMap<>();

    public TodoService() {
        //
    }

    public Todo create(Todo todo) {

        todo.setId((long) new Random().nextInt(100) + 1);
        todos.put(todo.getId(), todo);

        return todo;
    }

    public Todo get(Long id) {
        return todos.get(id);
    }
}
