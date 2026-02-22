package com.mehmetaltinbas.models;

public class Tetromino {
    private final int scale;
    private boolean[][] tetrominoMap;

    public Tetromino(Tetromino otherTetromino) {
        this.scale = otherTetromino.scale;
        this.tetrominoMap = new boolean[scale][scale];

        boolean[][] otherTetrominoMap = otherTetromino.getTetrominoMap();

        for (int i = 0; i < scale; i++) {
            for (int j=0; j < scale; j++) {
                tetrominoMap[i][j] = otherTetrominoMap[i][j];
            }
        }
    }

    public Tetromino(String[] tetrominoMapStr) {
        this.scale = tetrominoMapStr.length;
        this.tetrominoMap = new boolean[scale][scale];

        for (int i = 0; i < scale; i++) {
            for (int j = 0; j < tetrominoMapStr[i].length(); j++) {
                tetrominoMap[scale - i - 1][j] = tetrominoMapStr[i].charAt(j) == '#';
            }
        }
    }

    public boolean[][] getTetrominoMap() {
        return tetrominoMap;
    }

    public int getScale() {
        return scale;
    }
}
