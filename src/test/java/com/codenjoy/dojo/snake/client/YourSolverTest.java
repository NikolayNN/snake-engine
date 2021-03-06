package com.codenjoy.dojo.snake.client;


import com.codenjoy.dojo.services.RandomDice;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Nikol on 2/20/2016.
 */
public class YourSolverTest {

    @Test
    public void testSameDirection() {
        assertB("☼☼☼☼☼☼" +
                "☼    ☼" +
                "☼ ▼  ☼" +
                "☼    ☼" +
                "☼ ☺  ☼" +
                "☼☼☼☼☼☼", "DOWN");

        assertB("☼☼☼☼☼☼" +
                "☼    ☼" +
                "☼    ☼" +
                "☼► ☺ ☼" +
                "☼    ☼" +
                "☼☼☼☼☼☼", "RIGHT");

        assertB("☼☼☼☼☼☼" +
                "☼    ☼" +
                "☼ ☺  ☼" +
                "☼    ☼" +
                "☼ ▲  ☼" +
                "☼☼☼☼☼☼", "UP");

        assertB("☼☼☼☼☼☼" +
                "☼    ☼" +
                "☼☺  ◄☼" +
                "☼    ☼" +
                "☼    ☼" +
                "☼☼☼☼☼☼", "LEFT");

    }

    @Test
    public void testEatMe() {
//        assertB("☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼" +
//                "☼             ☼" +
//                "☼             ☼" +
//                "☼             ☼" +
//                "☼╔═════════►  ☼" +
//                "☼╙            ☼" +
//                "☼             ☼" +
//                "☼             ☼" +
//                "☼             ☼" +
//                "☼             ☼" +
//                "☼             ☼" +
//                "☼        ☺    ☼" +
//                "☼          ☻  ☼" +
//                "☼             ☼" +
//                "☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼", "DOWN");
//        assertB("☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼" +
//                "☼        ☺    ☼" +
//                "☼             ☼" +
//                "☼     ☻       ☼" +
//                "☼     ▲       ☼" +
//                "☼             ☼" +
//                "☼             ☼" +
//                "☼             ☼" +
//                "☼             ☼" +
//                "☼             ☼" +
//                "☼             ☼" +
//                "☼             ☼" +
//                "☼             ☼" +
//                "☼             ☼" +
//                "☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼", "LEFT");
//        assertB("☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼" +
//                "☼             ☼" +
//                "☼     ▼       ☼" +
//                "☼     ☻       ☼" +
//                "☼     ☺       ☼" +
//                "☼             ☼" +
//                "☼             ☼" +
//                "☼             ☼" +
//                "☼             ☼" +
//                "☼             ☼" +
//                "☼             ☼" +
//                "☼             ☼" +
//                "☼             ☼" +
//                "☼             ☼" +
//                "☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼", "LEFT");
//        assertB("☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼" +
//                "☼             ☼" +
//                "☼             ☼" +
//                "☼             ☼" +
//                "☼         ═══►☼" +
//                "☼             ☼" +
//                "☼             ☼" +
//                "☼             ☼" +
//                "☼             ☼" +
//                "☼             ☼" +
//                "☼    ☺☻       ☼" +
//                "☼             ☼" +
//                "☼             ☼" +
//                "☼             ☼" +
//                "☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼", "UP");
        assertB("☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼" +
                "☼             ☼" +
                "☼             ☼" +
                "☼            ▲☼" +
                "☼          ═══☼" +
                "☼             ☼" +
                "☼             ☼" +
                "☼             ☼" +
                "☼             ☼" +
                "☼             ☼" +
                "☼    ☺☻       ☼" +
                "☼             ☼" +
                "☼             ☼" +
                "☼             ☼" +
                "☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼", "LEFT");
//        assertB("☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼" +
//                "☼             ☼" +
//                "☼             ☼" +
//                "☼    ☺☻       ☼" +
//                "☼    ═══      ☼" +
//                "☼             ☼" +
//                "☼             ☼" +
//                "☼             ☼" +
//                "☼             ☼" +
//                "☼             ☼" +
//                "☼             ☼" +
//                "☼             ☼" +
//                "☼             ☼" +
//                "☼             ☼" +
//                "☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼", "LEFT");
    }





    @Test
    public void testNotSameDirection() {
        assertB("☼☼☼☼☼☼" +
                "☼    ☼" +
                "☼ ►  ☼" +
                "☼    ☼" +
                "☼ ☺  ☼" +
                "☼☼☼☼☼☼", "DOWN");

        assertB("☼☼☼☼☼☼" +
                "☼    ☼" +
                "☼    ☼" +
                "☼◄ ☺ ☼" +
                "☼    ☼" +
                "☼☼☼☼☼☼", "RIGHT");

        assertB("☼☼☼☼☼☼" +
                "☼    ☼" +
                "☼ ☺  ☼" +
                "☼    ☼" +
                "☼ ►  ☼" +
                "☼☼☼☼☼☼", "UP");

        assertB("☼☼☼☼☼☼" +
                "☼    ☼" +
                "☼☺  ►☼" +
                "☼    ☼" +
                "☼    ☼" +
                "☼☼☼☼☼☼", "LEFT");

    }

    private void assertB(String boardString, String expected) {
        // given
        YourSolver solver = new YourSolver(new RandomDice());

        // when
        String direction = solver.get((Board)new Board().forString(
                boardString));

        // then
        assertEquals(expected, direction);
    }
}
