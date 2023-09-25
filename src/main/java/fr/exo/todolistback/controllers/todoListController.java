package fr.exo.todolistback.controllers;

import fr.exo.todolistback.entities.Todo;
import fr.exo.todolistback.services.todoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api")
public class todoListController {

    @Autowired
    private todoService todoServices;

    @GetMapping()
    public void initData(){
        todoServices.initData();
    }

    @GetMapping(value = "/get",produces = "application/json")
    public List<Todo> getAll(){
        return todoServices.getAll();
    }

    @GetMapping(value = "/get/{title}", produces = "application/json")
    public Todo getTodoByName(@PathVariable(value = "title", required = true) String title){
        return todoServices.getByTitle(title);
    }

    @PostMapping(value = "/add",consumes="application/json", produces = "application/json")
    public void addTodo(@RequestBody Todo todo){
        todoServices.addTodo(todo);
    }

    @DeleteMapping(value = "/delete/{title}")
    public void delete(@PathVariable(name = "title")String title){
        todoServices.delete(title);
    }

}
