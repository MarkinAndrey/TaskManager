package ru.netology.javacore;

import com.google.gson.Gson;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class TodoServer {
    int port;
    Todos todos;

    public TodoServer(int port, Todos todos) {
        this.port = port;
        this.todos = todos;
    }

    public void start() throws IOException {
        try (ServerSocket serverSocket = new ServerSocket(port);) { // стартуем сервер один(!) раз
            while (true) { // в цикле(!) принимаем подключения
                try (
                        Socket socket = serverSocket.accept();
                        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                        PrintWriter out = new PrintWriter(socket.getOutputStream());
                ) {
                    String jsonString = in.readLine();
                    GsonString gsonClient = jsonParser(jsonString);

                    if (gsonClient.getType().equals("ADD")) {
                        todos.addTask(gsonClient.getTask());
                    }
                    if (gsonClient.getType().equals("REMOVE")) {
                        todos.removeTask(gsonClient.getTask());
                    }
                    out.println(todos.getAllTasks());
                }
            }
        } catch (IOException e) {
            System.out.println("Не могу стартовать сервер");
            e.printStackTrace();
        }
        System.out.println("Starting server at " + port + "...");

    }

    private GsonString jsonParser(String jsonString) {
        Gson g = new Gson();
        return g.fromJson(jsonString, GsonString.class);
    }

}
