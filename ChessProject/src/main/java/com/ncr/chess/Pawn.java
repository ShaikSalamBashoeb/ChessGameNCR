package com.ncr.chess;

public class Pawn {

    private ChessBoard chessBoard;
    private int xCoordinate;
    private int yCoordinate;
    private PieceColor pieceColor;

    public Pawn(PieceColor pieceColor) {
        this.pieceColor = pieceColor;
    }

    public ChessBoard getChessBoard() {
        return chessBoard;
    }

    public void setChessBoard(ChessBoard chessBoard) {
        this.chessBoard = chessBoard;
    }

    public int getXCoordinate() {
        return xCoordinate;
    }

    public void setXCoordinate(int value) {
        this.xCoordinate = value;
    }

    public int getYCoordinate() {
        return yCoordinate;
    }

    public void setYCoordinate(int value) {
        this.yCoordinate = value;
    }

    public PieceColor getPieceColor() {
        return this.pieceColor;
    }

    private void setPieceColor(PieceColor value) {
        pieceColor = value;
    }

    public void move(MovementType movementType, int newX, int newY) {
    	
    	//check if move is valid on the board or not.
    	if(movementType.MOVE == MovementType.MOVE && chessBoard.isLegalBoardPosition(newX, newY) 
    			&& isLegalMove(newX, newY)) {
    		this.setXCoordinate(newX);
    		this.setYCoordinate(newY);
//    		move(MovementType.CAPTURE, newX, newY); //we can have recursive call to capture the move
    	} else if(movementType.CAPTURE == MovementType.CAPTURE) {
    		//implement the logic to capture the move.
    	}
    }


    /**
     * verify if move is legal or not.
     * 
     * @param newX
     * @param newY
     * @return
     */
	private boolean isLegalMove(int newX, int newY) {
		
		Boolean isLegal = false;
		
		int yCoordinate = this.getYCoordinate()+2;
		int xCoordinate = this.getXCoordinate()-1;
		
//		Pawn can move either 1 or 2 step in straight direction
		if(newY > this.getYCoordinate() && yCoordinate <= newY
				&& newX == this.getXCoordinate()) {
			
			isLegal = true;
		} else if(newY == (this.getYCoordinate()+1) 
				&& (newX == (this.getXCoordinate()+1) || newX == (this.getXCoordinate()-1))) {
//			Pawn can move 1 step in diagonal direction
			isLegal = true;
		}
		return isLegal;
	}

	@Override
    public String toString() {
        return getCurrentPositionAsString();
    }

    protected String getCurrentPositionAsString() {
        String eol = System.lineSeparator();
        return String.format("Current X: {1}{0}Current Y: {2}{0}Piece Color: {3}", eol, xCoordinate, yCoordinate, pieceColor);
    }
}
