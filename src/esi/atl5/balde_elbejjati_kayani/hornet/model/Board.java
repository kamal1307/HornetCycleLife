package esi.atl5.balde_elbejjati_kayani.hornet.model;

import java.util.ArrayList;
import java.util.Random;

/**
 * Represente the environnement of Board
 *
 * @author Alpha,Mohamed,Kamal
 */
public class Board {

    private final int row;
    private final int column;
    private Season season;//possède un setteur
    private  Hornet[][] board;
      private Ratio ratio;
    /**
     * Constructor of board.
     *
     * @param row row of board.
     * @param column column of board.
     * @param season
     */
    public Board(int row, int column, Season season, Ratio ratio) {
        if (row < 5 || row > 500) {
            throw new IllegalArgumentException("Row is tall or small");
        }
        if (column < 5 || column > 500) {
            throw new IllegalArgumentException("Column is tall or small");
        }
        this.ratio=ratio;

        this.row = row;
        this.column = column;
        this.season = season;
        
       initBoard(ratio);

    }

    /**
     * initializes the board
     *
     * @param val
     */
    public final void initBoard(Ratio val) {
        this.board = new Hornet[column][row];
        Random rand = new Random();
        int nb;
        for (int i = 0; i < column; i++) {
            for (int j = 0; j < row; j++) {
                nb = rand.nextInt(val.getValue());
                if (nb == 0) {
                    board[i][j] = new Hornet(this.getRandomSex(), this.season);
                }
            }
        }

    }

    /**
     * delegated method wich increments age of a hornet whose position is given
     *
     * @param pos the position in the board
     */
    void setAge(Position pos) {
        try {
            int col = this.validateColumn(pos.getAbs());
            int lg = this.validateRow(pos.getOrd());
            this.board[col][lg].setAge();
        } catch (Exception e) {

        }

    }

    /**
     * delegated method wich changes the state of hornet at one position.
     *
     * @param pos Position of frelon.
     * @param newStatus new state.
     */
    public void setAlive(Position pos, boolean newStatus) {
        try {
            int col = this.validateColumn(pos.getAbs());
            int lg = this.validateRow(pos.getOrd());
            this.board[col][lg].setAlive(newStatus);
        } catch (Exception e) {

        }

    }

    /**
     * Obtain a frelon at one position.
     *
     * @param pos position of frelon.
     * @return frelon
     */
    public Hornet getHornetAtPos(Position pos) {

        int col = this.validateColumn(pos.getAbs());
        int lg = this.validateRow(pos.getOrd());

        return board[col][lg];

    }

    /*
    
     */
    void putHornet(Hornet f, Position pos) {
        board[this.validateColumn(pos.getAbs())][this.validateRow(pos.getOrd())] = f;
    }

    /**
     * method who return the list of neighbors of a hornet whose position is
     * given
     *
     * @param p the position in the board
     * @return a hornet list
     */
    public ArrayList<Position> getNeighbour(Position p) {
        ArrayList<Position> voisins = new ArrayList<>();

        if (p.getAbs() - 1 >= 0) {
            voisins.add(new Position(p.getAbs() - 1, p.getOrd()));
        }
        if (p.getAbs() + 1 < this.column) {
            voisins.add(new Position(p.getAbs() + 1, p.getOrd()));
        }
        if (p.getOrd() - 1 >= 0) {
            voisins.add(new Position(p.getAbs(), p.getOrd() - 1));
        }
        if (p.getOrd() + 1 < this.row) {
            voisins.add(new Position(p.getAbs(), p.getOrd() + 1));
        }

        if (p.getAbs() - 1 >= 0 && p.getOrd() - 1 >= 0) {
            voisins.add(new Position(p.getAbs() - 1, p.getOrd() - 1));
        }
        if (p.getAbs() - 1 >= 0 && p.getOrd() + 1 < this.row) {
            voisins.add(new Position(p.getAbs() - 1, p.getOrd() + 1));
        }

        if (p.getAbs() + 1 < this.column && p.getOrd() - 1 >= 0) {
            voisins.add(new Position(p.getAbs() + 1, p.getOrd() - 1));
        }
        if (p.getAbs() + 1 < this.column && p.getOrd() + 1 < this.row) {
            voisins.add(new Position(p.getAbs() + 1, p.getOrd() + 1));
        }

        return voisins;

    }

    /**
     * Checking if row is valid.
     *
     * @param row row
     * @return row
     */
    private int validateRow(int row) {
        if (row < 0 || row >= this.row) {
            throw new IllegalArgumentException("Row is tall or small: " + row);
        }

        return row;
    }

    /**
     * Checking if column is valid.
     *
     * @param column column
     * @return column
     */
    private int validateColumn(int column) {
        if (column < 0 || column >= this.column) {
            throw new IllegalArgumentException("Column is tall or small");
        }

        return column;
    }

    /**
     * Obtain row of board.
     *
     * @return row
     */
    public int getRow() {
        return row;
    }

    /**
     * Obtain column of board.
     *
     * @return column
     */
    public int getColumn() {
        return column;
    }

    /**
     * Get board with all frelons.
     *
     * @return board of frelon.
     */
    public Hornet[][] getBoard_() {
        return board;
    }

    /**
     * getter of season
     *
     * @return a season
     */
    public Season getSeason() {
        return season;
    }

    /**
     * setter of season
     *
     * @param season the new season
     */
    public void setSeason(Season season) {
        this.season = season;

    }

    /**
     * return a sex de façon aleatoire
     *
     * @return a random sex
     */
    public Sexe getRandomSex() {
        int nb;
        Random r = new Random();
        nb = r.nextInt(2);

        if (nb == 1) {
            return Sexe.FEMALE;
        } else {
            return Sexe.MALE;
        }
    }

    /**
     *
     * @return the number of hornet live
     */
    public int getNbAlive() {
        int cpt = 0;

//        for(int i=0;i<board.length;i++){
//            for(int j=0;j<board[i].length;j++){
//                if(board[i][j]!=null && board[i][j].isALive()){
//                    cpt +=1;
//                }
//            }
//        }
        for (Hornet[] br1 : board) {
            for (Hornet hr : br1) {
                if (hr != null && hr.isALive()) {
                    cpt += 1;
                }
            }
        }

        return cpt;
    }

    /**
     * 
     * @param valueOf 
     */
    public void setRatio(Ratio valueOf) {
       this.ratio=valueOf;
    }
}
