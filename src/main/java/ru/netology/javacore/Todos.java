package ru.netology.javacore;

import java.util.*;
import java.util.stream.Collectors;

public class Todos {
    protected List<String> todos = new ArrayList<>();

    public void addTask(String task) {
        if (task != null) {
            todos.add(task);
        } else {
            System.out.println("Incorrect task!");
        }
    }

    public void removeTask(String task) {
        if (task != null) {
            todos.remove(task);
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
