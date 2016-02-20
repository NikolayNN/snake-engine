package com.codenjoy.dojo.snake.client;


import com.codenjoy.dojo.client.Direction;
import com.codenjoy.dojo.client.Solver;
import com.codenjoy.dojo.client.WebSocketRunner;
import com.codenjoy.dojo.services.Dice;
import com.codenjoy.dojo.services.Point;
import com.codenjoy.dojo.services.RandomDice;

import java.util.List;

/**
 * User: your name
 */
public class YourSolver implements Solver<Board> {

    private static final String USER_NAME = "Nikolay.Horushko@gmail.com";

    private Dice dice;
    private Board board;

    public YourSolver(Dice dice) {
        this.dice = dice;
    }

    @Override
    public String get(Board board) {
        this.board = board;

        Direction currentSnakeDirection = board.getSnakeDirection();

        Point apple = board.getApples().get(0);
        int appleX = apple.getX();
        int appleY = apple.getY();

        Point snakeHead = board.getHead();
        int snakeHeadX = snakeHead.getX();
        int snakeHeadY = snakeHead.getY();



        if (appleY < snakeHeadY) {
            return safeTurn(snakeHeadX, snakeHeadY, Direction.UP);
        }
        if (appleY > snakeHeadY){
            return safeTurn(snakeHeadX, snakeHeadY, Direction.DOWN);
        }


        if(appleY == snakeHeadY){
            if(appleX < snakeHeadX){
                while(appleX!=snakeHeadX) {
                    return safeTurn(snakeHeadX, snakeHeadY, Direction.LEFT);
                }
            }else{
                while(appleX!=snakeHeadX) {
                    return safeTurn(snakeHeadX, snakeHeadY, Direction.RIGHT);
                }
            }

        }





        return Direction.DOWN.toString();
    }

private String safeTurn(int snakeHeadX, int snakeHeadY, Direction currentSnakeDirection){
    if (!isNextCellFree(snakeHeadX, snakeHeadY, currentSnakeDirection)) {
        if (isNextCellFree(snakeHeadX, snakeHeadY, Direction.LEFT)) {
            return Direction.LEFT.toString();
        }
        if (isNextCellFree(snakeHeadX, snakeHeadY, Direction.RIGHT)) {
            return Direction.RIGHT.toString();
        }
        if (isNextCellFree(snakeHeadX, snakeHeadY, Direction.UP)) {
            return Direction.UP.toString();
        }
        if (isNextCellFree(snakeHeadX, snakeHeadY, Direction.DOWN)) {
            return Direction.DOWN.toString();
        }
    }
    return currentSnakeDirection.toString();
}

    private Boolean isNextCellFree(int snakeHeadX, int snakeHeadY, Direction currentDirection){


        if (currentDirection == Direction.UP){
            snakeHeadY--;
        }
        if (currentDirection == Direction.DOWN){
            snakeHeadY++;
        }
        if (currentDirection == Direction.RIGHT){
            snakeHeadX++;
        }
        if (currentDirection == Direction.LEFT){
            snakeHeadX--;
        }

        List<Point> barriers = board.getBarriers();
        for (Point barrier : barriers) {
            if ((barrier.getX() == snakeHeadX) && (barrier.getY() == snakeHeadY)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        start(USER_NAME, WebSocketRunner.Host.REMOTE);
    }

    public static void start(String name, WebSocketRunner.Host server) {
        try {
            WebSocketRunner.run(server, name,
                    new YourSolver(new RandomDice()),
                    new Board());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
