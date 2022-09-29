/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package battleship;

import static battleship.Board.board;
import java.awt.Color;
import java.awt.Graphics2D;

/**
 *
 * @author 145004436
 */
public class Hover {
        private static boolean init;
        public static Piece hover[][] = new Piece[Board.NUM_ROWS()][Board.NUM_COLUMNS()];
        private static boolean rotate;
        private static int shipSize = 3;

    public static void Highlight(int xpixel, int ypixel) {
        int xdelta = Window.getWidth2()/10;
        int ydelta = Window.getHeight2()/10;
        int zcol = (xpixel - Window.getX(0))/xdelta;
        int zrow = (ypixel - Window.getY(0))/ydelta;
        if (zcol == Board.NUM_COLUMNS() || zcol < 0 || xpixel < Window.getX(0) || ypixel < Window.getY(0)|| zrow < 0 || zrow == Board.NUM_ROWS())
            return;
        System.out.println(zcol+"             "+zrow);
        if (rotate)
        {
            if (zrow > 1)
            {
                hover[zrow][zcol] = new Piece(Player.GetCurrentPlayer().getColor());
                if (shipSize > 1)
                {
                    hover[zrow-1][zcol] = new Piece(Player.GetCurrentPlayer().getColor());
                    if (shipSize > 2)
                        hover[zrow-2][zcol] = new Piece(Player.GetCurrentPlayer().getColor());
                }

            }
            else if (zrow == 1) {
                hover[zrow][zcol] = new Piece(Player.GetCurrentPlayer().getColor());
                if (shipSize > 1)
                {
                    hover[zrow-1][zcol] = new Piece(Player.GetCurrentPlayer().getColor());
                    if (shipSize > 2)
                        hover[zrow+1][zcol] = new Piece(Player.GetCurrentPlayer().getColor());
                }
            }
            else if (zrow == 0) {
                hover[zrow][zcol] = new Piece(Player.GetCurrentPlayer().getColor());
                if (shipSize > 1)
                {
                    hover[zrow+1][zcol] = new Piece(Player.GetCurrentPlayer().getColor());
                    if (shipSize > 2)
                        hover[zrow+2][zcol] = new Piece(Player.GetCurrentPlayer().getColor());
                }
            }
        }
        else
        {
            if (zcol > 1)
            {
                hover[zrow][zcol] = new Piece(Player.GetCurrentPlayer().getColor());
                if (shipSize > 1)
                {
                    hover[zrow][zcol-1] = new Piece(Player.GetCurrentPlayer().getColor());
                    if (shipSize > 2)
                        hover[zrow][zcol-2] = new Piece(Player.GetCurrentPlayer().getColor());
                }

            }
            else if (zcol == 1) {
                hover[zrow][zcol] = new Piece(Player.GetCurrentPlayer().getColor());
                if (shipSize > 1)
                {
                    hover[zrow][zcol-1] = new Piece(Player.GetCurrentPlayer().getColor());
                    if (shipSize > 2)
                        hover[zrow][zcol+1] = new Piece(Player.GetCurrentPlayer().getColor());
                }
            }
            else if (zcol == 0) {
                hover[zrow][zcol] = new Piece(Player.GetCurrentPlayer().getColor());
                if (shipSize > 1)
                {
                    hover[zrow][zcol+1] = new Piece(Player.GetCurrentPlayer().getColor());
                    if (shipSize > 2)
                        hover[zrow][zcol+2] = new Piece(Player.GetCurrentPlayer().getColor());
                }
            }
        }
    }
    public static void placeShip(int xpixel, int ypixel){
        int xdelta = Window.getWidth2()/10;
        int ydelta = Window.getHeight2()/10;
        int zcol = (xpixel - Window.getX(0))/xdelta;
        int zrow = (ypixel - Window.getY(0))/ydelta;
        if (zcol == Board.NUM_COLUMNS() || zcol < 0 || xpixel < Window.getX(0) || ypixel < Window.getY(0)|| zrow < 0 || zrow == Board.NUM_ROWS())
            return;
        System.out.println(zcol+"             "+zrow);
        if (rotate)
        {
            if (zrow > 1)
            {
                board[zrow][zcol] = new Piece(Player.GetCurrentPlayer().getColor());
                if (shipSize > 1)
                {
                    board[zrow-1][zcol] = new Piece(Player.GetCurrentPlayer().getColor());
                    if (shipSize > 2)
                        board[zrow-2][zcol] = new Piece(Player.GetCurrentPlayer().getColor());
                }

            }
            else if (zrow == 1) {
                board[zrow][zcol] = new Piece(Player.GetCurrentPlayer().getColor());
                if (shipSize > 1)
                {
                    board[zrow-1][zcol] = new Piece(Player.GetCurrentPlayer().getColor());
                    if (shipSize > 2)
                        hover[zrow+1][zcol] = new Piece(Player.GetCurrentPlayer().getColor());
                }
            }
            else if (zrow == 0) {
                board[zrow][zcol] = new Piece(Player.GetCurrentPlayer().getColor());
                if (shipSize > 1)
                {
                    board[zrow+1][zcol] = new Piece(Player.GetCurrentPlayer().getColor());
                    if (shipSize > 2)
                        board[zrow+2][zcol] = new Piece(Player.GetCurrentPlayer().getColor());
                }
            }
        }
        else
        {
            if (zcol > 1)
            {
                board[zrow][zcol] = new Piece(Player.GetCurrentPlayer().getColor());
                if (shipSize > 1)
                {
                    board[zrow][zcol-1] = new Piece(Player.GetCurrentPlayer().getColor());
                    if (shipSize > 2)
                        board[zrow][zcol-2] = new Piece(Player.GetCurrentPlayer().getColor());
                }

            }
            else if (zcol == 1) {
                board[zrow][zcol] = new Piece(Player.GetCurrentPlayer().getColor());
                if (shipSize > 1)
                {
                    board[zrow][zcol-1] = new Piece(Player.GetCurrentPlayer().getColor());
                    if (shipSize > 2)
                        board[zrow][zcol+1] = new Piece(Player.GetCurrentPlayer().getColor());
                }
            }
            else if (zcol == 0) {
                board[zrow][zcol] = new Piece(Player.GetCurrentPlayer().getColor());
                if (shipSize > 1)
                {
                    board[zrow][zcol+1] = new Piece(Player.GetCurrentPlayer().getColor());
                    if (shipSize > 2)
                        board[zrow][zcol+2] = new Piece(Player.GetCurrentPlayer().getColor());
                }
            }
        }
       
    }
    public static void Move(){
        for (int zrow=0;zrow<Board.NUM_ROWS();zrow++)
        {
            for (int zcol=0;zcol<Board.NUM_COLUMNS();zcol++)        
            {
                hover[zrow][zcol] = null;
            }
        }
    }
    public static void reduceShip(){
        shipSize--;
        if (shipSize == 0)
        {
            Player.SwitchTurn();
            shipSize = 3;
        }
    }
    public static void Draw(Graphics2D g) {
        int ydelta = Window.getHeight2()/Board.NUM_COLUMNS();
        int xdelta = Window.getWidth2()/Board.NUM_ROWS();
        
        for (int zrow=0;zrow<Board.NUM_ROWS();zrow++) {
            for (int zcol=0;zcol<Board.NUM_COLUMNS();zcol++)   {
                if (hover[zrow][zcol] != null)
                    hover[zrow][zcol].draw(g, zrow, zcol, xdelta, ydelta);
            }
        }
        
    }
    public static boolean getRotate(){
        if (rotate == true)
            rotate = false;
        else if (rotate == false)
            rotate = true;
        return(rotate);
    }
    
}
