package com.brc.knights_tour.resources;

public abstract class ChessPiece {
    private String pieceType;
    protected int currentRow;
    protected int currentCol;

	// ************************************************
	// 
	// Constructor
	// 
	// ************************************************

    public ChessPiece(String pieceType, int startRow, int startCol){
        this.pieceType = pieceType;
        this.currentRow = startRow;
        this.currentCol = startCol;
    }

	// ************************************************
	// 
	// Getters and Setters
	// 
	// ************************************************
    
    public void setPieceType(String pieceType) {
        this.pieceType = pieceType;
    }

    public String getPieceType() {
        return this.pieceType;
    }

    public int getCurrentRow() {
        return this.currentRow;
    }

    public int getCurrentCol() {
        return this.currentCol;
    }
}
