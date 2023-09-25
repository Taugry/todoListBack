package fr.exo.todolistback.services;

import fr.exo.todolistback.entities.Todo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class todoServiceImpl implements todoService{

    public List<Todo> todoList = new ArrayList<>();

    public void initData(){
        todoList.add(new Todo("Conduire", "etre au volant d'un vehicule et le faire deplacer", false));
        todoList.add(new Todo("Manger", "action qui permet d'ingerer des aliments", false));
        todoList.add(new Todo("dormir", "action permettant d'entrer en etat de veille profond", false));
        todoList.add(new Todo("Eveil", "etre dans l'etat inverse de dormir, etre donc pret et attentif", true));
        System.out.println("Init Done");
    }

    @Override
    public List<Todo> getAll() {
        return this.todoList;
    }

    @Override
    public Todo getByTitle(String title) {
        for (Todo element : todoList){
            if (element.getTitle().equals(title)){
                return element;
            }
        }
        System.out.println("get name");
        return null;
    }

    @Override
    public void addTodo(Todo todo) {
        todoList.add(todo);
        System.out.println("add Done");
    }


    @Override
    public void delete(String title) {
        todoList.removeIf(element -> element.getTitle().equals(title));
        System.out.println("delete Done");
    }
}
