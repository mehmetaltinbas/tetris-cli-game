package com.mehmetaltinbas.factory;

import com.mehmetaltinbas.models.Tetromino;
import com.mehmetaltinbas.models.Tetrominoes;

import java.util.HashMap;
import java.util.List;

public class TetrominoFactory {
    private final HashMap<Tetrominoes, Tetromino> tetrominoesMap;
    private final List<Tetrominoes> nextTetrominoes;
    private int currentTetrominoesIndex = -1;

    public TetrominoFactory(List<Tetrominoes> nextTetrominoes) {
        this.nextTetrominoes = nextTetrominoes;
        tetrominoesMap = createMap();
    }

    private HashMap<Tetrominoes, Tetromino> createMap() {
        final HashMap<Tetrominoes, Tetromino> tetrominoesMap;
        tetrominoesMap = new HashMap<>();
        tetrominoesMap.put(Tetrominoes.S, new Tetromino(new String[]{
                ".##",
                "##.",
                "...",
        }));
        tetrominoesMap.put(Tetrominoes.Z, new Tetromino(new String[]{
                "##.",
                ".##",
                "...",
        }));
        tetrominoesMap.put(Tetrominoes.O, new Tetromino(new String[]{
                "##",
                "##"
        }));
        tetrominoesMap.put(Tetrominoes.T, new Tetromino(new String[]{
                ".#.",
                "###",
                "..."
        }));
        tetrominoesMap.put(Tetrominoes.L, new Tetromino(new String[]{
                ".#.",
                ".#.",
                ".##",
        }));
        tetrominoesMap.put(Tetrominoes.J, new Tetromino(new String[]{
                ".#.",
                ".#.",
                "##.",
        }));
        tetrominoesMap.put(Tetrominoes.I, new Tetromino(new String[]{
                ".#..",
                ".#..",
                ".#..",
                ".#.."
        }));
        return tetrominoesMap;
    }

    public Tetromino createTetromino(Tetrominoes tetrominoType) {
        return new Tetromino(tetrominoesMap.get(tetrominoType));
    }

    public Tetromino getNext() {
        return createTetromino(nextTetrominoes.get(++currentTetrominoesIndex));
    }
}
