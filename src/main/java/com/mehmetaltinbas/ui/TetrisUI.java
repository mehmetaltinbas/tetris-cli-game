package com.mehmetaltinbas.ui;

import com.mehmetaltinbas.core.TetrisMap;

public interface TetrisUI {
    void draw(TetrisMap tetrisMap, int score);
    void gameLost(int score);
}
