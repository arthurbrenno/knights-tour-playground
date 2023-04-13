package com.brc.knights_tour.resources;

public class Knight extends ChessPiece{
    
    private static final int[] horizontalMovements = {2, 1, -1, -2, -2, -1, 1, 2};
    private static final int[] verticalMovements = {-1, -2, -2, -1, 1, 2, 2, 1};
    private int houseCount = 0;

    // ************************************************
	// 
	// Constructor
	// 
	// ************************************************

    public Knight(int startRow, int startCol){
        super("K", startRow, startCol);
    }

    // ************************************************
	// 
	// Instance methods
	// 
	// ************************************************

    public void move(int movementType, ChessBoard chessBoard){
        if (isPossibleMovement(movementType, chessBoard)) {
            updateKnightRowAndCol(movementType, chessBoard);
            chessBoard.placePiece(this, currentRow, currentCol);
        }
    }

    public void moveCheckingVisitedPlaces(int movementType, ChessBoard chessBoard){
        if (isPossibleMovement(movementType, chessBoard)) {
            if(!(chessBoard.wasVisited(currentRow + verticalMovements[movementType], currentCol + horizontalMovements[movementType]))) {
                updateKnightRowAndCol(movementType, chessBoard);
                chessBoard.placePiece(this, currentRow, currentCol);
            }
        }
    }

    private void updateKnightRowAndCol(int movementType, ChessBoard chessBoard) {
        chessBoard.place(Integer.toString(this.houseCount++), this.currentRow, this.currentCol);
        this.currentRow += verticalMovements[movementType];
        this.currentCol += horizontalMovements[movementType];
    }

    public boolean isPossibleMovement(int movementType, ChessBoard chessBoard) {
        String[][] board = chessBoard.getBoard();
        int newRow = currentRow + verticalMovements[movementType];
        int newCol = currentCol + horizontalMovements[movementType];
        return (newRow >= 0 && newCol >=0 && newRow < board.length && newCol <board[newRow].length);
    }

    // ************************************************
	// 
	// Getters and Setters
	// 
	// ************************************************

    public int getHouseCount() {
        return this.houseCount;
    }

    public static int[] getVerticalMovements() {
        return verticalMovements;
    }

    public static int[] getHorizontalMovements() {
        return horizontalMovements;
    }

}
