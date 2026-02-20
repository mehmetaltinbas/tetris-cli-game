package com.mehmetaltinbas.core;

import com.mehmetaltinbas.models.TetrisAction;
import java.util.*;

public class TetrisGameManager {
    private TetrisGame game;
    private List<TetrisAction> actions;

    private TetrisGameManager() {
    }

    public void simulate() {
        if (game == null) {
            throw new IllegalStateException("Game must be initialized before simulation.");
        }

        game.startGame();

        for (TetrisAction action : actions) {
            if (!game.resolveAction(action)) {
                break;
            }
        }
    }

    public static class Builder {
        private final TetrisGameManager manager;

        private Builder() {
            manager = new TetrisGameManager();
        }

        public static Builder newBuilder() {
            return new Builder();
        }

        public Builder setGame(TetrisGame game) {
            manager.game = game;
            return this;
        }

        public Builder setActionList(List<TetrisAction> actions) {
            manager.actions = actions;
            return this;
        }

        public TetrisGameManager build() {
            if (manager.game == null || manager.actions == null) {
                throw new IllegalStateException("Manager requires both a Game and an Action List.");
            }
            return manager;
        }
    }
}
