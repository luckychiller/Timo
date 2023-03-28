package com.example.timo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class ChessEngine {
    private BufferedReader input;
    private OutputStreamWriter output;
    private static final String NEWLINE = System.getProperty("line.separator");
    public ChessEngine(String enginePath) throws Exception {
        Process engineProcess = Runtime.getRuntime().exec(enginePath);
        input = new BufferedReader(new InputStreamReader(engineProcess.getInputStream()));
        output = new OutputStreamWriter(engineProcess.getOutputStream());
        sendCommand("uci");
        sendCommand("isready");
        waitForOutput("readyok");
    }

    public void setPosition(String fen) throws Exception {
        sendCommand("position fen " + fen);
    }

    public String getBestMove(int searchTime) throws Exception {
        sendCommand("go movetime " + searchTime);
        String outputString = waitForOutput("bestmove");
        String[] tokens = outputString.split("\\s+");
        return tokens[1];
    }

    private void sendCommand(String command) throws Exception {
        output.write(command + NEWLINE);
        output.flush();
    }

    private String waitForOutput(String expectedOutput) throws Exception {
        String outputString = "";
        while (outputString == null || !outputString.startsWith(expectedOutput)) {
            outputString = input.readLine();
        }
        return outputString;
    }
}