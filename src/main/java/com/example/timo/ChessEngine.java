package com.example.timo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class ChessEngine {
    private Socket socket;
    private BufferedReader input;
    private OutputStreamWriter output;
    private static final String NEWLINE = System.getProperty("line.separator");

    public ChessEngine(String enginePath) throws Exception {
        // Start the engine process and connect to it via standard input/output
        Process engineProcess = Runtime.getRuntime().exec(enginePath);
        socket = new Socket("localhost", 8080);
        input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        output = new OutputStreamWriter(socket.getOutputStream());
        // Initialize the engine
        sendCommand("uci");
        sendCommand("isready");
        waitForOutput("readyok");
    }

    public void setPosition(String fen) throws Exception {
        // Set the position on the board
        sendCommand("position fen " + fen);
    }

    public String getBestMove(int searchTime) throws Exception {
        // Tell the engine to start thinking
        sendCommand("go movetime " + searchTime);
        // Wait for the output that contains the best move
        String outputString = waitForOutput("bestmove");
        // Extract the best move from the output
        String[] tokens = outputString.split("\\s+");
        return tokens[1];
    }

    private void sendCommand(String command) throws Exception {
        // Send a command to the engine
        output.write(command + NEWLINE);
        output.flush();
    }

    private String waitForOutput(String expectedOutput) throws Exception {
        // Wait for the expected output from the engine
        String outputString = input.readLine();
        while (!outputString.startsWith(expectedOutput)) {
            outputString = input.readLine();
        }
        return outputString;
    }
}