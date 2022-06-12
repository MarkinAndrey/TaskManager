package ru.netology.javacore;

import java.util.*;
import java.util.stream.Collectors;

public class Todos {
    ArrayList<String> todos = new ArrayList<>();
    Iterator<String> todosIterator;


    public void addTask(String task) {
        if (task != null) {
            todos.add(task);
        }
        else {
            System.out.println("Incorrect task!");
        }
    }

    public void removeTask(String task) {

        if (task != null){
            boolean removeComplete = false;
            todosIterator = todos.iterator();
            while (todosIterator.hasNext() && !removeComplete) {
                String nextTodo = todosIterator.next();
                if (nextTodo.equals(task)) {
                    todosIterator.remove();
                    removeComplete = true;
                    System.out.println("Remove task complete");
                }
            }
            if (!removeComplete) {
                System.out.println("Incorrect task!");
            }
        } else {
            System.out.println("Incorrect task!");
        }
    }

    public String getAllTasks() {
        String allTasks = todos.stream().sorted().collect(Collectors.toList()).toString();
        StringBuilder stringBuilder = new StringBuilder(allTasks);
        stringBuilder.deleteCharAt(stringBuilder.length() - 1).deleteCharAt(0);
        return stringBuilder.toString();
    }

}
