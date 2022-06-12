package ru.netology.javacore;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class TodosTest {

    @ParameterizedTest
    @CsvSource({"'3, 5'",
            "'Aa'",
            "'aA'",
            "'null'",
            "null"})
    void addTask(String task) {
        Todos todos = new Todos();
        todos.addTask(task);
        assertEquals(task, todos.getAllTasks());
    }


    @ParameterizedTest
    @CsvSource({"'3, 5'",
            "'Aa'",
            "'aA'",
            "'null'",
            "null"})
    void removeTask(String task) {
        Todos todos = new Todos();
        todos.addTask(task);
        todos.addTask(task);
        todos.removeTask(task);
        assertEquals(task, todos.getAllTasks());
    }

    @ParameterizedTest
    @CsvSource({"'3, 5'",
            "'Aa'",
            "'aA'",
            "'null'",
            "null"})
    void getAllTasks(String task) {
        Todos todos = new Todos();
        todos.addTask(task);
        todos.addTask(task);
        todos.removeTask(task);
        assertEquals(task, todos.getAllTasks());
    }
}