package com.brc.knights_tour.resources;


public class ChessBoard {
    
    private int boardSize;
    private String[][] board;
    private boolean[][] boardVisitedPlaces;
    private final String FILL_CHARACTER = "";

    public ChessBoard(int boardSize) {

        this.board = new String[boardSize][boardSize];
        this.boardVisitedPlaces = new boolean[boardSize][boardSize];

        for(int row = 0; row < boardSize; row++) {
            for (int col = 0; col < boardSize; col++) {
                board[row][col] = FILL_CHARACTER;
            }
        }

    }

    // ************************************************
	// 
	// Instance methods
	// 
	// ************************************************

    public void placePiece(ChessPiece piece, int row, int col){
        board[row][col] = piece.getPieceType();
        boardVisitedPlaces[row][col] = true;
    }

    public void removePiece(ChessPiece piece) {
        for (int row = 0; row < boardSize; row++) {
            for (int col = 0; col < boardSize; col++) {
                if (board[row][col] == piece.getPieceType()) {
                    board[row][col] = FILL_CHARACTER;
                }
            }
        }
    }

    public boolean wasVisited(int row, int col) {
        return boardVisitedPlaces[row][col];
    }

    public void place(String character ,int row, int col) {
        board[row][col] = character;
    }
    

    // ************************************************
	// 
	// Getters and Setters
	// 
	// ************************************************

    public String[][] getBoard() {
        return this.board;
    }

    // ************************************************
	// 
	// Output area
	// 
	// ************************************************

    public void display() {
        System.out.printf("%s%n", "---------------------------------------------------");
        for (String[] row : board) {
            System.out.printf("%s", "|");
            for (String col : row) {
                System.out.printf("%5s%s", col, "|");
            }
            System.out.printf("%n%s", "---------------------------------------------------");
            System.out.println();
        }
    }

}
