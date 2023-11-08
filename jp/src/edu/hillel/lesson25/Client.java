package edu.hillel.lesson25;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    private static final String FILE_DIRECTORY = System.getProperty("user.dir");

    public void start(String serverAddress, int serverPort) {
        try (Socket socket = new Socket(serverAddress, serverPort);
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             Scanner scanner = new Scanner(System.in)) {
            System.out.println("Connected to the server.");

            Thread receiveThread = new Thread(() -> {
                String message;
                try {
                    while ((message = in.readLine()) != null)
                        System.out.println("Received: " + message);
                } catch (IOException e) {
                    System.out.println("Error: " + e.getMessage());
                    System.exit(1);
                }
            });
            receiveThread.start();

            String userInput;
            while (true) {
                userInput = scanner.nextLine();
                out.println(userInput);

                if (userInput.equals("-exit"))
                    break;
                else if (userInput.startsWith("-file"))
                    sendFile(userInput.substring(6), out);
            }
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
            System.exit(1);
        }
    }

    public void sendFile(String filePath, PrintWriter out) {
        try (BufferedReader fileReader = new BufferedReader(new FileReader(FILE_DIRECTORY + File.separator + filePath))) {
            String line;
            while ((line = fileReader.readLine()) != null)
                out.println(line);
            out.println("-endfile");
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
            System.exit(1);
        }
    }
}


