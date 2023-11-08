package org.example;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Server {
    List<ClientConnection> clients = new ArrayList<>();
    public static final String FILE_DIRECTORY = System.getProperty("user.dir") + File.separator + "test-directory";
    private static int clientCount = 1;

    public void start(int port) {
        createFileDirectoryIfNeeded();

        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Server started on port " + port);
            while (true) {
                Socket clientSocket = serverSocket.accept();
                ClientConnection client = new ClientConnection(clientSocket);
                clients.add(client);
                Thread clientThread = new Thread(client);
                clientThread.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void createFileDirectoryIfNeeded() {
        File directory = new File(FILE_DIRECTORY);
        if (!directory.exists())
            directory.mkdir();
    }

    public void broadcastMessage(String message) {
        for (ClientConnection client : clients)
            client.sendMessage(message);
    }

    class ClientConnection implements Runnable {
        Socket socket;
        private PrintWriter out;
        private BufferedReader in;
        private String clientName;
        private Date connectionTime;

        public ClientConnection(Socket socket) {
            this.socket = socket;
            connectionTime = new Date();
            clientName = "Client-" + clientCount;
            clientCount++;
            try {
                out = new PrintWriter(socket.getOutputStream(), true);
                in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            } catch (IOException e) {
                System.out.println(clientName + " error: " + e.getMessage());
            }
        }

        public void run() {
            try {
                sendMessage("[SERVER] Welcome, " + clientName + "!");
                broadcastMessage("[SERVER] " + clientName + " successfully connected.");

                String message;
                while ((message = in.readLine()) != null) {
                    System.out.println("Received from " + clientName + ": " + message);
                    if (message.equals("-exit"))
                        break;
                    else if (message.startsWith("-file"))
                        handleFileTransfer(message.substring(6));
                    else if (message.equals("-hello"))
                        sendMessage("[SERVER] Hello, " + clientName + "!");
                    else
                        sendMessage("[SERVER] " + message);
                }
                socket.close();
                clients.remove(this);
                System.out.println(clientName + " " + socket.getInetAddress() + " disconnected.");
            } catch (IOException e) {
                System.out.println(clientName + " error: " + e.getMessage());
            }
        }

        public void sendMessage(String message) {
            out.println(message);
        }

        public void handleFileTransfer(String filePath) {
            try (BufferedWriter fileWriter = new BufferedWriter(new FileWriter(FILE_DIRECTORY + File.separator + filePath))) {
                String line;
                while ((line = in.readLine()) != null) {
                    if (line.equals("-endfile"))
                        break;
                    fileWriter.write(line);
                    fileWriter.newLine();
                }
                sendMessage("[SERVER] File transfer completed.");
            } catch (IOException e) {
                System.out.println(clientName + " error: " + e.getMessage());
            }
        }
    }
}
