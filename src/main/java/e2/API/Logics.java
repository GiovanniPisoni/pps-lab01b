package e2.API;

import e2.Pair;

public interface Logics{
    
    /**
     * attempt to move Knight on position row,col, if possible
     * 
     * @param row to move the knight to
     * @param col to move the knight to
     * @return whether the pawn has been hit 
     */
    boolean hit(int row, int col);
    
    /**
     * @param row to check
     * @param col to check
     * @return whether position row,col has the knight
     */
    boolean hasKnight(int row, int col);
    
    /**
     * @param row to check
     * @param col to check
     * @return whether position row,col has the pawn
     */
    boolean hasPawn(int row, int col);

    /**
     * @return the size of the grid
     */
    int getSize();

    /**
     * @return the position of the pawn
     */
    Pair<Integer, Integer> getPawn();

    /**
     * @return the position of the knight
     */
    Pair<Integer, Integer> getKnight();
}
