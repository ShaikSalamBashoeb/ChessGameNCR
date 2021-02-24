package com.ncr.chess;

public class ChessBoard {

    public static int MAX_BOARD_WIDTH = 7;
    public static int MAX_BOARD_HEIGHT = 7;

    private Pawn[][] pieces;

    public ChessBoard() {
        pieces = new Pawn[MAX_BOARD_WIDTH][MAX_BOARD_HEIGHT];
    }

    public void addPiece(Pawn pawn, int xCoordinate, int yCoordinate, PieceColor pieceColor) {
    	
//    	verify if Pawn is being added in valid board position or not.
    	if(!isLegalBoardPosition(xCoordinate, yCoordinate) || isDuplicatePositioning(pawn, xCoordinate, yCoordinate, pieceColor)) {
    		
    		pawn.setXCoordinate(-1);
        	pawn.setYCoordinate(-1);
    	} else {
    		
    		pawn.setXCoordinate(xCoordinate);
        	pawn.setYCoordinate(yCoordinate);
        	pawn.setChessBoard(this);
        	
        	this.pieces[pawn.getXCoordinate()][pawn.getYCoordinate()] = pawn;
    	}
    }

    /**
     * verify if Pawn is being added twice on same position or not.
     * 
     * @param pawn
     * @param xCoordinate
     * @param yCoordinate
     * @param pieceColor
     * @return
     */
    private boolean isDuplicatePositioning(Pawn pawn, int xCoordinate, int yCoordinate, PieceColor pieceColor) {
    	
    	boolean isDupliate = false;
    	
    	if(null != this.pieces[xCoordinate][yCoordinate]) {
    		isDupliate = true;
    	} 
    	
		return isDupliate;
	}

    /**
     * verify if Pawn is being added in valid board position or not.
     * 
     * @param xCoordinate
     * @param yCoordinate
     * @return
     */
	public boolean isLegalBoardPosition(int xCoordinate, int yCoordinate) {
    	
    	if(xCoordinate >= MAX_BOARD_WIDTH || yCoordinate >= MAX_BOARD_HEIGHT
    			|| xCoordinate < 0 || yCoordinate < 0 ) {
    		return false;
    	}
    	return true;
    }
}
