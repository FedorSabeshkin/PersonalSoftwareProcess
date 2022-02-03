package com.sabeshkin.test;
import static org.junit.Assert.*;

import com.sabeshkin.Cell;
import com.sabeshkin.Reversi;
import org.junit.Test;
import org.junit.*;

public class DefineDirectionTest {
    @Test
    public void DefineDirection_RightBottom() {
        Cell cell = Cell.createEmpty(0,0);
        Cell neighbourEnemy = Cell.createBlack(1,1);
        String direction = Reversi.defineDirection(cell, neighbourEnemy);
        assertEquals(
                "RightBottom", direction);
    }

    @Test
    public void DefineDirection_Bottom() {
        Cell cell = Cell.createEmpty(0,0);
        Cell neighbourEnemy = Cell.createBlack(0,1);
        String direction = Reversi.defineDirection(cell, neighbourEnemy);
        assertEquals(
                "Bottom", direction);
    }

    @Test
    public void DefineDirection_Top() {
        Cell cell = Cell.createEmpty(0,1);
        Cell neighbourEnemy = Cell.createBlack(0,0);
        String direction = Reversi.defineDirection(cell, neighbourEnemy);
        assertEquals(
                "Top", direction);
    }

    @Test
    public void DefineDirection_LeftBottom() {
        Cell cell = Cell.createEmpty(1,0);
        Cell neighbourEnemy = Cell.createBlack(0,1);
        String direction = Reversi.defineDirection(cell, neighbourEnemy);
        assertEquals(
                "LeftBottom", direction);
    }
}
