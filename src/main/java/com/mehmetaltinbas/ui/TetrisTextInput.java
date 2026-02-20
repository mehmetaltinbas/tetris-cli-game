package com.mehmetaltinbas.ui;

import com.mehmetaltinbas.models.TetrisAction;
import com.mehmetaltinbas.models.Tetrominoes;

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

    public static List<Tetrominoes> parseTetrominoes(String tetrominoesString) {
        ArrayList<Tetrominoes> tetrominoes = new ArrayList<>();

        for (String tetrominoString : tetrominoesString.split(" ")) {
            switch (tetrominoString) {
                case "T" -> tetrominoes.add(Tetrominoes.T);
                case "O" -> tetrominoes.add(Tetrominoes.O);
                case "S" -> tetrominoes.add(Tetrominoes.S);
                case "Z" -> tetrominoes.add(Tetrominoes.Z);
                case "I" -> tetrominoes.add(Tetrominoes.I);
                case "J" -> tetrominoes.add(Tetrominoes.J);
                case "L" -> tetrominoes.add(Tetrominoes.L);
            }
        }
        return tetrominoes;
    }
}
