package com.galactic_Ninja.spring.basics.springbootwebapplication.service;

import com.galactic_Ninja.spring.basics.springbootwebapplication.models.Todo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

@Service
public class TodoService {
    private static List<Todo> todoList = new ArrayList<Todo>();
    private static int todoCount = 3;

    static {
        todoList.add(new Todo(1,"David Lutta","Learn Spring Mvc", new Date(),false));
        todoList.add(new Todo(2, "David Lutta", "Learn Spring Boot MVC", new Date(), false));
        todoList.add(new Todo(3, "Lutta David", "Learn Java", new Date(), false));
    }

    public List<Todo> retrieveTodos(String user) {
        List<Todo> filteredTodos = new ArrayList<Todo>();
        for (Todo todo : todoList) {
            if (todo.getUsername().equals(user)) {
                filteredTodos.add(todo);
            }
        }
        return filteredTodos;
    }


    public void addTodo(String username, String desc, Date targetDate,
                        boolean isDone) {
        todoList.add(new Todo(++todoCount, username, desc, targetDate, isDone));
    }

    public void deleteTodo(int id) {
        Iterator<Todo> iterator = todoList.iterator();
        while (iterator.hasNext()) {
            Todo todo = iterator.next();
            if (todo.getId() == id) {
                iterator.remove();
            }
        }
    }
}
