/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package battleship;
import static battleship.Board.ship;
import battleship.Board.sound;
import java.awt.*;
/**
 *
 * @author tomta
 */
public class ScoutTwo {
    private static boolean scoutActive;
    private static int scoutCount;
    private static Piece hover[][][] = new Piece[Board.getNUM_ROWS()][Board.getNUM_COLUMNS()][4];
    private static Piece sub[][][] = new Piece[Board.getNUM_ROWS()][Board.getNUM_COLUMNS()][4];
    private static int direction;
    private static int scoutCol;
    private static int scoutRow;
    private static boolean scoutPlaced;
    private static int numberPlaced;
    private static sound MisExplo;

    public static void scoutAdd(int xpixel,int ypixel) {

        int ydelta = Window.getHeight2()/Board.getNUM_ROWS();
        int xdelta = Window.getWidth2()/Board.getNUM_COLUMNS();

        int zcol = (xpixel-Window.getX(0))/xdelta;
        int zrow = (ypixel-Window.getY(0))/ydelta;
        
        if (xpixel <  Window.getSideBorder() || ypixel < Window.getTopBorder())
            return; 
        
        if(zrow < Board.getNUM_ROWS() && zrow > -1 && zcol < Board.getNUM_COLUMNS() && zcol > -1) {
            if(Board.BoardSel() == 2 || Board.BoardSel() == 3)
                return;
            if (scoutPlaced)
                return;

            scoutCol = zcol;
            scoutRow = zrow;

            if (scoutActive){
                sub[zrow][zcol][Board.BoardSel()] = new Piece (Color.green);
                scoutPlaced = true;
            }
        }

    }
    public static void scoutHover(int xpixel,int ypixel){
        
        int ydelta = Window.getHeight2()/Board.getNUM_ROWS();
        int xdelta = Window.getWidth2()/Board.getNUM_COLUMNS();

        int zcol = (xpixel-Window.getX(0))/xdelta;
        int zrow = (ypixel-Window.getY(0))/ydelta;
        
        if (xpixel <  Window.getSideBorder() || ypixel < Window.getTopBorder())
            return;
        
        if(zrow < Board.getNUM_ROWS() && zrow > -1 && zcol < Board.getNUM_COLUMNS() && zcol > -1) {
            if(Board.BoardSel() == 2 || Board.BoardSel() == 3)
                return;
        
            if (scoutPlaced)
                return;

            hover[zrow][zcol][Board.BoardSel()] = new Piece(Color.green);
        }        
    }
    public static void Move(){
        if(Board.BoardSel() == 2 || Board.BoardSel() == 3)
            return;
        for (int zrow=0;zrow<Board.getNUM_ROWS();zrow++)
        {
            for (int zcol=0;zcol<Board.getNUM_COLUMNS();zcol++)        
            {
                hover[zrow][zcol][Board.BoardSel()] = null;
            }
        }
    }
    public static void setTrue(){
        scoutActive = true;
    }
    public static boolean getScoutActive(){
        return(scoutActive);
    }
    public static boolean getScoutPlaced(){
        return(scoutPlaced);
    }
    public static void scoutCount(){
        scoutCount++;
        if (scoutCount == 2)
        {
            scoutActive = true;
        }

    }
    public static void changeScoutDirection(int keyPressed){
        direction = keyPressed;
    }
    public static int scoutDirection(){
        return(direction);
    }
    public static void scoutClear(){
        for (int zrow=0;zrow<Board.getNUM_ROWS();zrow++)
        {
            for (int zcol=0;zcol<Board.getNUM_COLUMNS();zcol++)        
            {
                sub[zrow][zcol][Board.BoardSel()] = null;
            }
        }
    }
    public static void scoutMove(int keyPressed){
        if(Board.BoardSel() == 2 || Board.BoardSel() == 3)
            return;
        if (!scoutPlaced)
            return;
        
        boolean validMovement = true;
        
        if (keyPressed == 1){
            if (scoutRow-1 < 0)
                validMovement = false;
            if (validMovement)
                scoutRow--;
            sub[scoutRow][scoutCol][Board.BoardSel()] = new Piece (Color.green);
        }
        else if (keyPressed == 2){
            if (scoutCol-1 < 0)
                validMovement = false;
            if (validMovement)
                scoutCol--;
            sub[scoutRow][scoutCol][Board.BoardSel()] = new Piece (Color.green);
        }
        else if (keyPressed == 3){
            if (scoutRow+1 > Board.getNUM_ROWS()-1)
                validMovement = false;
            if (validMovement)
                scoutRow++;
            sub[scoutRow][scoutCol][Board.BoardSel()] = new Piece (Color.green);
        }
        else if (keyPressed == 4){
            if (scoutCol+1 > Board.getNUM_COLUMNS()-1)
            {
                validMovement = false;
                System.out.println("wow");
            }
            if (validMovement)
                scoutCol++;
            sub[scoutRow][scoutCol][Board.BoardSel()] = new Piece (Color.green);
        }

    }
    
    public static void scoutShoot(){
        if (scoutPlaced)
        {
            if(Board.MisCollision(scoutRow, scoutCol))
            {
                Board.ExplosionSound_HIT(scoutRow, scoutCol);
                Board.RemovePiecePixel_HIT(scoutRow, scoutCol);
            }
            else
            {
                Board.ExplosionSound_MISS(scoutRow, scoutCol);
                Board.RemovePiecePixel_MISS(scoutRow, scoutCol);
            }
            
            if (numberPlaced ==2)
            {
                scoutActive = false;
            }
        }
    }
    public static void Reset(){
        scoutActive = false;
        scoutPlaced = false;
        scoutCount = 0;
        for(int b=0;b<2;b++)
        for (int zrow=0;zrow<Board.getNUM_ROWS();zrow++)
            for (int zcol=0;zcol<Board.getNUM_COLUMNS();zcol++)
                sub[zrow][zcol][b] = null;
    }
    public static void Draw(Graphics2D g, Battleship thisObj) {
        if (!scoutActive)
            return;
        for (int zrow=0;zrow<Board.getNUM_ROWS();zrow++)
        {
            for (int zcol=0;zcol<Board.getNUM_COLUMNS();zcol++){
                if (sub[zrow][zcol][Board.BoardSel()] != null){
                    sub[zrow][zcol][Board.BoardSel()].draw(g, zrow, zcol, Board.xdelta(), Board.ydelta(), thisObj);
                }
            }
        }
        for (int zrow=0;zrow<Board.getNUM_ROWS();zrow++)
        {
            for (int zcol=0;zcol<Board.getNUM_COLUMNS();zcol++){
                if (hover[zrow][zcol][Board.BoardSel()] != null)    {
                    hover[zrow][zcol][Board.BoardSel()].draw(g, zrow, zcol, Board.xdelta(), Board.ydelta(), thisObj);
                }
            }
        }
    }
}
