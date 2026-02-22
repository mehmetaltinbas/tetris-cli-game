package com.mehmetaltinbas.core;

import com.mehmetaltinbas.factory.TetrominoFactory;
import com.mehmetaltinbas.models.Cell;
import com.mehmetaltinbas.models.TetrisAction;
import com.mehmetaltinbas.models.Tetromino;
import com.mehmetaltinbas.ui.TetrisUI;

public abstract class TetrisGame {
    protected TetrisMap map;
    protected TetrisUI ui;
    protected TetrominoFactory tetrominoFactory;

    protected TetrisGame() {
    }

    public void drawScreen() {
        ui.draw(map);
    }

    private void gameLost() {
        ui.gameLost();
    }

    protected Tetromino getNextTetromino() {
        return tetrominoFactory.getNext();
    }

    protected Cell getPlacementCell(Tetromino tetromino) {
        int halfTetrominoWidth = tetromino.getScale() / 2;
        int halfBoardWidth = map.getWidth() / 2;

        int startRow = map.getHeight() - tetromino.getScale();
        int startCol = halfBoardWidth - halfTetrominoWidth;

        return map.getCell(startRow, startCol);
    }

    protected boolean checkTetromino(Tetromino tetromino, int row, int column) {
        boolean[][] shape = tetromino.getTetrominoMap();
        for (int i = 0; i < shape.length; i++) {
            for (int j = 0; j < shape[i].length; j++) {
                if (shape[i][j]) {
                    int targetRow = row + i;
                    int targetCol = column + j;

                    Cell mapCell = map.getCell(targetRow, targetCol);
                    if (mapCell == null || mapCell.isOccupied()) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public void startGame() {
        Tetromino tetromino = getNextTetromino();
        Cell cell = getPlacementCell(tetromino);

        if (!placeTetromino(tetromino, cell.getRow(), cell.getColumn())) {
            gameLost();
        } else {
            drawScreen();
        }
    }

    public boolean resolveAction(TetrisAction action) {
        switch (action) {
            case Left -> left();
            case Right -> right();
            case Rotate -> rotate();
            case Tick -> {
                boolean success = tick();
                if (!success) {
                    gameLost();
                    return false;
                }
            }
        }

        drawScreen();

        return true;
    }

    protected abstract boolean placeTetromino(Tetromino tetromino, int row, int column);
    protected abstract boolean tick();
    protected abstract void rotate();
    protected abstract void right();
    protected abstract void left();

    public static class Builder {
        private final TetrisGame game;

        private Builder(TetrisGame tetrisGame) {
            this.game = tetrisGame;
        }

        public static Builder newBuilder(TetrisGame game) {
            return new Builder(game);
        }

        public Builder setMap(TetrisMap map) {
            game.map = map;
            return this;
        }

        public Builder setUI(TetrisUI ui) {
            game.ui = ui;
            return this;
        }

        public Builder setFactory(TetrominoFactory factory) {
            game.tetrominoFactory = factory;
            return this;
        }

        public TetrisGame build() {
            return game;
        }
    }
}
