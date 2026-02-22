package com.mehmetaltinbas.ui;

import com.mehmetaltinbas.models.TetrisAction;
import com.mehmetaltinbas.models.TetrominoType;

import java.util.*;

public class TetrisTextInput {
    public static List<TetrisAction> parseActions(String actionsString) {
        ArrayList<TetrisAction> actions = new ArrayList<>();

        for (String actionString : actionsString.split(" ")) {
            switch (actionString) {
                case "T" -> actions.add(TetrisAction.Tick);
                case "R" -> actions.add(TetrisAction.Right);
                case "L" -> actions.add(TetrisAction.Left);
                case "O" -> actions.add(TetrisAction.Rotate);
            }
        }

        return actions;
    }

    public static List<TetrominoType> parseTetrominoes(String tetrominoesString) {
        ArrayList<TetrominoType> tetrominoes = new ArrayList<>();

        for (String tetrominoString : tetrominoesString.split(" ")) {
            switch (tetrominoString) {
                case "T" -> tetrominoes.add(TetrominoType.T);
                case "O" -> tetrominoes.add(TetrominoType.O);
                case "S" -> tetrominoes.add(TetrominoType.S);
                case "Z" -> tetrominoes.add(TetrominoType.Z);
                case "I" -> tetrominoes.add(TetrominoType.I);
                case "J" -> tetrominoes.add(TetrominoType.J);
                case "L" -> tetrominoes.add(TetrominoType.L);
            }
        }
        return tetrominoes;
    }
}
