package com.example.timo;

public class DatabaseController {/*
    public void saveToDatabase() {
        // Connect to the SQL database
        String url = "jdbc:mysql://localhost:3306/chess_game";
        String user = "root";
        String password = "password";
        try (Connection conn = DriverManager.getConnection(url, user, password)) {
            // Create a prepared statement to insert the game position into the database
            String query = "INSERT INTO game_positions (game_id, position) VALUES (?, ?)";
            PreparedStatement pstmt = conn.prepareStatement(query);
            // Set the values for the prepared statement
            pstmt.setInt(1, gameId); // Replace "gameId" with the actual game ID
            pstmt.setString(2, serializeBoard()); // Serialize the board to a string
            // Execute the prepared statement
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void loadFromDatabase(int gameId) {
        // Connect to the SQL database
        String url = "jdbc:mysql://localhost:3306/chess_game";
        String user = "root";
        String password = "password";
        try (Connection conn = DriverManager.getConnection(url, user, password)) {
            // Create a prepared statement to select the game position from the database
            String query = "SELECT position FROM game_positions WHERE game_id = ?";
            PreparedStatement pstmt = conn.prepareStatement(query);
            // Set the value for the prepared statement
            pstmt.setInt(1, gameId);
            // Execute the prepared statement and get the result set
            ResultSet rs = pstmt.executeQuery();
            // If the result set has a row, load the game position
            if (rs.next()) {
                String position = rs.getString("position");
                deserializeBoard(position); // Deserialize the board from the string
                // Update the UI to display the loaded game position
                // ...
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void deserializeBoard(String position) {
        // Deserialize the board from a string using the same format as serializeBoard()
        for (int i = 0; i < position.length(); i++) {
            int x = i % 8;
            int y = i / 8;
            char c = position.charAt(i);
            if (c == '-') {
                board[x][y] = null;
            } else {
                Piece piece = createPiece(c, x, y);
                board[x][y] = piece;
            }
        }
    }

    private Piece createPiece(char c, int x, int y) {
        // Create a piece based on the specified character
        switch (c) {
            case 'P':
                return new Pawn(/* image *./, x, y);
            case 'R':
                return new Rook(/* image *./, x, y);
            case 'N':
                return new Knight(/* image *./, x, y);
            case 'B':
                return new Bishop(/* image *./, x, y);
            case 'Q':
                return new Queen(/* image *./, x, y);
            case 'K':
                return new King(/* image *./, x, y);
            default:
                throw new IllegalArgumentException("Invalid character: " + c);
        }
    }

    private String serializeBoard() {
        // Serialize the board to a string using a simple format
        StringBuilder sb = new StringBuilder();
        for (int y = 0; y < 8; y++) {
            for (int x = 0; x < 8; x++) {
                Piece piece = board[x][y];
                if (piece == null) {
                    sb.append("-");
                } else {
                    sb.append(piece.getClass().getSimpleName().charAt(0));
                }
            }
        }
        return sb.toString();
    }
*/
}
