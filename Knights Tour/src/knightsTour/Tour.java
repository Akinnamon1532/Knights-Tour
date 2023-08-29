/*
 * COPYRIGHT
 */
package knightsTour;

import java.util.Random;

/**
 * @author Andrew Kinnamon
 * Date: 3/23/2021
 * Description: This class moves the knight around the board
 */
public class Tour
{
    //Create the board
    public static int[][] Board = new int[8][8];
    
    
    /**
     * <Summary>
     * Runs the program
     * <Summary>
     */
    public static void main(String[] args)
    {
        fullRandomKnightsTour();
        printOutBoard();
    }
    
    
    /**
     * <Summary>
     * This method runs tours until the knight makes a full tour around the board
     * <Summary>
     */
    public static void fullRandomKnightsTour()
    {
        //Loop until it gets a tour with 64 moves
        int numberOfAttempts = 1;
        while(singleRandomKnightsTour() < 64)
        {
            //clear the board before every new attempt
            Board = new int[8][8];
            //print out the number of attempts as it goes
            System.out.println(numberOfAttempts);
            numberOfAttempts ++;
        }
    }
    
    
    /**
     * <Summary>
     * This method runs a single tour with the knight starting at a 
     * random position on the board
     * <Summary>
     * <returns>the number of moves the knight was able to make</returns>
     */
    public static int singleRandomKnightsTour()
    {
        Random r = new Random();
        return KnightsTour(r.nextInt(7-0),r.nextInt(7-0));
    }
    
    
    /**
     * <Summary>
     * This method prints out the board, so the user can see the path
     * that the knight took
     * <Summary>
     */
    public static void printOutBoard()
    {
        //loop through each column and row and print out their values
        for(int i = 0; i < 8; i++)
        {
            for(int j = 0; j < 8; j++)
            {
                if (Board[j][i]<10)
                {
                    System.out.print(Board[j][i]+"   " );
                }
                else
                {
                    System.out.print(Board[j][i]+"  " );
                }
            }
            System.out.print("\n");
        }
    }    
    
    
    /**
     * <Summary>
     * This method receives the starting position of the knight, and 
     * moves the knight around the board by choosing a random valid move
     * <Summary>
     * <param name="startingColumn">The column that the knight will start on</param>
     * <param name="startingRow">The row that the knight will start on</param>
     * <returns>the number of moves the knight was able to make</returns>
     */
    public static int KnightsTour(int startingColumn, int startingRow)
    {
        //Create the knight
        Knight knight = new Knight(startingColumn, startingRow);
        int numberOfMoves = 1;
        
        //Assign the move number to the position of the Knight on the chess board
        Board[knight.getColumn()][knight.getRow()] = numberOfMoves;
        
        //Loop until there are no more valid moves
        while (numberOfMoves > 0)
        {
            //Find the valid moves the Knight can make from its position
            int[] movesArray = knight.validMoves();     
            //if there aren't any valid moves, break the loop
            if (knight.validMoves()[8] == 0)
            {
                break;
            }
            //Choose a valid move for the knight to make
            Random r = new Random();
            int[] selectedMove = knight.knightMoves(movesArray[r.nextInt(movesArray[8]-0)]);
            // Update the Knights position and the number of moves it has made
            knight.setRow(selectedMove[0]);
            knight.setColumn(selectedMove[1]);
            numberOfMoves ++;
            //Update the chess board
            Board[knight.getColumn()][knight.getRow()] = numberOfMoves;
        }
        //Return the number of moves the knight made
        return numberOfMoves;
    }
}
