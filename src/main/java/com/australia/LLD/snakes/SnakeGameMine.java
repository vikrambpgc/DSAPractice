package com.australia.LLD.snakes;

import java.util.*;

class Coordinate {
    int x;
    int y;

    Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }

}
class SnakeGameMine {
    Deque<Coordinate> snake;
    int[][] food;
    int foodTracker;
    int score;
    Set<Coordinate> snakeSet;
    int width;
    int height;

    public SnakeGameMine(int width, int height, int[][] food) {
        this.snake = new LinkedList<>();
        this.food = food;
        this.snake.add(new Coordinate(0, 0));
        snakeSet = new HashSet<>();
        snakeSet.add(new Coordinate(0, 0));
        this.width = width;
        this.height = height;
        this.foodTracker = 0;
    }

    public int move(String direction) {
        Coordinate head = this.snake.peekFirst();
        int newRow = head.x;
        int newColumn = head.y;


        switch (direction) {
            case "U":
                newRow--;
                break;
            case "D":
                newRow++;
                break;
            case "L":
                newColumn--;
                break;
            case "R":
                newColumn++;
                break;
            case "default":
                return -2;
        }


        if (newColumn == width || newColumn < 0 ||
                newRow == height || newRow < 0) {
            return -1;
        }

        Coordinate newHead = new Coordinate(newRow, newColumn);
        Coordinate tail = this.snake.peekLast();
        if (snakeSet.contains(newHead) &&
                newHead.x != tail.x && newHead.y != tail.y) {
            return -1;
        }

        if (foodTracker < food.length && food[foodTracker][0] == newHead.x && food[foodTracker][1] == newHead.y) {
            foodTracker++;
        } else {
            snakeSet.remove(snake.getLast());
            snake.removeLast();
        }
        snake.addFirst(newHead);
        snakeSet.add(newHead);

        return this.snake.size() - 1;
    }
}
