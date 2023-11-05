package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.net.Socket;
import java.nio.file.Files;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ServerTest {
    private Server server;

    @BeforeEach
    public void setup() {
        server = new Server();
    }

    @Test
    public void testBroadcastMessage() {
        try {
            Server.ClientConnection clientConnection1 = server.new ClientConnection(mock(Socket.class));
            Server.ClientConnection clientConnection2 = server.new ClientConnection(mock(Socket.class));

            server.clients.add(clientConnection1);
            server.clients.add(clientConnection2);

            ByteArrayOutputStream outputStream1 = new ByteArrayOutputStream();
            ByteArrayOutputStream outputStream2 = new ByteArrayOutputStream();

            when(clientConnection1.socket.getOutputStream()).thenReturn(outputStream1);
            when(clientConnection2.socket.getOutputStream()).thenReturn(outputStream2);

            server.broadcastMessage("Test Message");

            assertEquals("Test Message\n", outputStream1.toString());
            assertEquals("Test Message\n", outputStream2.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testHandleFileTransfer() {
        try {
            Socket mockSocket = Mockito.mock(Socket.class);
            when(mockSocket.getOutputStream()).thenReturn(new ByteArrayOutputStream());

            Server.ClientConnection clientConnection = server.new ClientConnection(mockSocket);
            server.clients.add(clientConnection);

            ByteArrayInputStream inputStream = new ByteArrayInputStream("-file sample1.txt\n-fileContent\n-endfile\n-exit".getBytes());
            when(mockSocket.getInputStream()).thenReturn(inputStream);

            clientConnection.handleFileTransfer("sample1.txt");

            File savedFile = new File(Server.FILE_DIRECTORY + File.separator + "sample1.txt");
            assertTrue(savedFile.exists());
            assertEquals("fileContent", Files.readString(savedFile.toPath()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testClientConnection() {
        try {
            Socket mockSocket = Mockito.mock(Socket.class);
            when(mockSocket.getOutputStream()).thenReturn(new ByteArrayOutputStream());

            Server.ClientConnection clientConnection = server.new ClientConnection(mockSocket);
            ByteArrayInputStream inputStream = new ByteArrayInputStream("Test Message\n-exit".getBytes());
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            when(mockSocket.getInputStream()).thenReturn(inputStream);
            when(mockSocket.getOutputStream()).thenReturn(outputStream);

            clientConnection.run();

            assertTrue(outputStream.toString().contains("[SERVER] Welcome, Client-1!"));
            assertTrue(outputStream.toString().contains("[SERVER] Client-1 successfully connected."));
            assertTrue(outputStream.toString().contains("[SERVER] Test Message"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
