package edu.hillel.lesson25;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.net.Socket;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class ClientTest {
    private ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private ByteArrayInputStream inContent = new ByteArrayInputStream("Test Message\n-exit".getBytes());

    @BeforeEach
    public void setup() {
        System.setOut(new PrintStream(outContent));
        System.setIn(inContent);
    }

    @Test
    public void testSendMessageToServer() {
        Client client = new Client();
        try {
            Socket mockSocket = Mockito.mock(Socket.class);
            when(mockSocket.getOutputStream()).thenReturn(new ByteArrayOutputStream());
            when(mockSocket.getInputStream()).thenReturn(inContent);

            client.start("localhost", 8080);

            assertEquals("Connected to the server.\n", outContent.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testExitCommand() {
        Client client = new Client();
        try {
            Socket mockSocket = Mockito.mock(Socket.class);
            when(mockSocket.getOutputStream()).thenReturn(new ByteArrayOutputStream());
            when(mockSocket.getInputStream()).thenReturn(inContent);

            inContent.reset();
            inContent = new ByteArrayInputStream("-exit".getBytes());
            System.setIn(inContent);

            outContent.reset();
            client.start("localhost", 8080);

            assertEquals("Connected to the server.\n", outContent.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testFileTransferCommand() {
        Client client = new Client();
        try {
            Socket mockSocket = Mockito.mock(Socket.class);
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            when(mockSocket.getOutputStream()).thenReturn(outputStream);
            when(mockSocket.getInputStream()).thenReturn(inContent);

            inContent.reset();
            inContent = new ByteArrayInputStream("-file sample1.txt\n-fileContent\n-endfile\n-exit".getBytes());
            System.setIn(inContent);

            client.start("localhost", 8080);

            assertEquals("-file sample1.txt\n-fileContent\n-endfile\n", outputStream.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}