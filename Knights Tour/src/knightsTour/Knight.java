/*
 * COPYRIGHT
 */
package knightsTour;

/**
 * @author Andrew Kinnamon
 * Date: 3/23/2021
 * Description: This class defines and describes how the knight piece moves
 */
public class Knight
{
    private int column;
    private int row;
    
    
    /**
     * <Summary>
     * This method constructs a knight object
     * <Summary>
     * <param name="startingColumn">The column that the knight will start on</param>
     * <param name="startingRow">The row that the knight will start on</param>
     */
    public Knight(int startingColumn, int startingRow)
    {
        column = startingColumn;
        row = startingRow;
    }
    
    
    /**
     * <Summary>
     * This method returns the column the knight is on
     * <Summary>
     * <returns>The column the knight is on</returns>
     */
    public int getColumn()
    {
        return this.column;
    }
    
    
    /**
     * <Summary>
     * This method returns the row the knight is on
     * <Summary>
     * <returns>The row the knight is on</returns>
     */
    public int getRow()
    {
        return this.row;
    }
    
    
    /**
     * <Summary>
     * This method receives an integer and updates the column the knight is on
     * <Summary>
     * <param name="column">The column that the knight will be moved to</param>
     */
    public void setColumn(int column)
    {
        this.column = column;
    }
    
    
    /**
     * <Summary>
     * This method receives an integer and updates the row the knight is on
     * <Summary>
     * <param name="row">The row that the knight will be moved to</param>
     */
    public void setRow(int row)
    {
        this.row = row;
    }
    
    
    /**
     * <Summary>
     * This method receives loops through all 8 ways the knight can move,
     * stores all the valid moves in an array, and returns that array.
     * <Summary>
     * <returns>an array of moves the knight can legally make</returns>
     */
    public int[] validMoves()
    {
        //create the array to hold all the valid moves
        int numberOfValidMoves = 0;
        int[] validMoves = new int[9];
        
        //loop though all 8 possible moves
        for(int i = 0; i < 8; i ++)
        {
            //check each move to see if it is valid
            if (ValidMoveCheck(i))
            {
                //If it is a valid move add it to the array
                validMoves[numberOfValidMoves] = i;
                numberOfValidMoves ++;
            }
        }
        //record the number of valid moves in the 9th spot in the array
        validMoves[8] = numberOfValidMoves;
        
        // Return the array
        return validMoves;
    }
    
    
    /**
     * <Summary>
     * This method receives a move that the knight could make and checks to see
     * if that move will move the knight off the board, or will move it to a 
     * spot that it has already been.
     * <Summary>
     * <param name="moveNumber">The move that will be checked</param>
     * <returns>a boolean describing if the move is valid or not</returns>
     */
    public boolean ValidMoveCheck(int moveNumber)
    {
        //Initialize the boolean variable to true by default
        boolean validMove = true;
        //find where the knight will land
        int[] a = knightMoves(moveNumber);
        int newRow = a[0];
        int newColumn = a[1];
        //Check if the knight will land off the chess board or on a spot it has already been
        if (newRow > 7 || newRow < 0 || newColumn > 7 || newColumn < 0 || Tour.Board[newColumn][newRow] != 0)
        {
            validMove = false;
        }
        // Return whether or not it is a valid move
        return validMove;
    }
    
    /**
     * <Summary>
     * This method receives a move that the knight could make and returns
     * the square that the knight would land on
     * <Summary>
     * <param name="moveNumber">The move that will be checked</param>
     * <returns>an array that contains the square the knight would land on</returns>
     */
    public int[] knightMoves(int moveNumber)
    {
        int potentialRow = -1;
        int potentialColumn = -1;
        //Use a switch statement to store all 8 possible moves
        switch (moveNumber)
        {
            //adjust the knights potential position based on the selected move
            case 0:
                potentialRow = row + -1;
                potentialColumn = column + 2;
                break;
            case 1:
                potentialRow = row + -2;
                potentialColumn = column + 1;
                break;
            case 2:
                potentialRow = row + -2;
                potentialColumn = column + -1;
                break;
            case 3:
                potentialRow = row + -1;
                potentialColumn = column + -2;
                break;
            case 4:
                potentialRow = row + 1;
                potentialColumn = column + -2;
                break;
            case 5:
                potentialRow = row + 2;
                potentialColumn = column + -1;
                break;
            case 6:
                potentialRow = row + 2;
                potentialColumn = column + 1;
                break;
            case 7:
                potentialRow = row + 1;
                potentialColumn = column + 2;
                break;
        }
        //Store the landing position in an array and return that array
        int[] newPosition = {potentialRow, potentialColumn};
        return newPosition;
    }
}
