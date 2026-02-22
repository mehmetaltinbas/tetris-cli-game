package com.mehmetaltinbas.factory;

import com.mehmetaltinbas.models.Tetromino;
import com.mehmetaltinbas.models.TetrominoType;

import java.util.*;

public class TetrominoFactory {
    private final HashMap<TetrominoType, Tetromino> tetrominoesMap;
    private final List<TetrominoType> nextTetrominoes;
    private int currentTetrominoesIndex = -1;

    public TetrominoFactory(List<TetrominoType> nextTetrominoes) {
        this.nextTetrominoes = nextTetrominoes;
        tetrominoesMap = createMap();
    }

    private HashMap<TetrominoType, Tetromino> createMap() {
        final HashMap<TetrominoType, Tetromino> tetrominoesMap;
        tetrominoesMap = new HashMap<>();
        tetrominoesMap.put(TetrominoType.S, new Tetromino(new String[]{
            ".##",
            "##.",
            "...",
        }));
        tetrominoesMap.put(TetrominoType.Z, new Tetromino(new String[]{
            "##.",
            ".##",
            "...",
        }));
        tetrominoesMap.put(TetrominoType.O, new Tetromino(new String[]{
            "##",
            "##"
        }));
        tetrominoesMap.put(TetrominoType.T, new Tetromino(new String[]{
            ".#.",
            "###",
            "..."
        }));
        tetrominoesMap.put(TetrominoType.L, new Tetromino(new String[]{
            ".#.",
            ".#.",
            ".##",
        }));
        tetrominoesMap.put(TetrominoType.J, new Tetromino(new String[]{
            ".#.",
            ".#.",
            "##.",
        }));
        tetrominoesMap.put(TetrominoType.I, new Tetromino(new String[]{
            ".#..",
            ".#..",
            ".#..",
            ".#.."
        }));
        return tetrominoesMap;
    }

    public Tetromino createTetromino(TetrominoType tetrominoType) {
        return new Tetromino(tetrominoesMap.get(tetrominoType));
    }

    public Tetromino getNext() {
        return createTetromino(nextTetrominoes.get(++currentTetrominoesIndex));
    }
}
