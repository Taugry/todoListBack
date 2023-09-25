package fr.exo.todolistback.services;

import fr.exo.todolistback.entities.Todo;

import java.util.List;

public interface todoService {

    void initData();

    List<Todo> getAll();

    Todo getByTitle(String title);

    void addTodo(Todo todo);

    void delete(String title);

}
