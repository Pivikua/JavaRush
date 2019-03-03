package com.javarush.task.task35.task3513;

import java.util.*;

public class Model {
    private static final int FIELD_WIDTH = 4;
    private Tile[][] gameTiles;
    int score;
    int maxTile;
    private Stack<Tile[][]> previousStates = new Stack<>();
    private Stack<Integer> previousScores = new Stack<>();
    private boolean isSaveNeeded = true;

    public Model() {
        resetGameTiles();
        this.score = 0;
        this.maxTile = 0;
    }

    void resetGameTiles() {
        this.gameTiles = new Tile[FIELD_WIDTH][FIELD_WIDTH];

        for (int i = 0; i < FIELD_WIDTH; i++) {
            for (int j = 0; j < FIELD_WIDTH; j++) {
                this.gameTiles[i][j] = new Tile();
            }
        }
        addTile();
        addTile();
    }

    private void addTile() {
        List<Tile> tiles = getEmptyTiles();
        if (tiles != null && !tiles.isEmpty()) {
            int randomTile = (int) (Math.random() * tiles.size());
            tiles.get(randomTile).value = Math.random() < 0.9 ? 2 : 4;
        }
    }

    private List<Tile> getEmptyTiles() {
        List<Tile> tiles = new ArrayList<>();
        for (int i = 0; i < FIELD_WIDTH; i++) {
            for (int j = 0; j < FIELD_WIDTH; j++) {
                if (gameTiles[i][j].value == 0) {
                    tiles.add(gameTiles[i][j]);
                }
            }
        }
        return tiles;
    }

    private boolean compressTiles(Tile[] tiles) { //Сжатие плиток в одну сторону
        boolean isChanged = false;
        Tile tmp;
        for (int j = 0; j < tiles.length - 1; j++) {
            for (int i = 0; i < tiles.length - 1; i++) {
                if (tiles[i].value == 0 && tiles[i + 1].value != 0) {
                    tmp = tiles[i];
                    tiles[i] = tiles[i + 1];
                    tiles[i + 1] = tmp;
                    isChanged = true;
                }
            }
        }
        return isChanged;
    }

    private boolean mergeTiles(Tile[] tiles) {
        boolean isChanged = false;
        for (int j = 0; j < 3; j++) {
            if (tiles[j].getValue() != 0 && tiles[j].getValue() == tiles[j + 1].getValue()) {
                tiles[j].setValue(tiles[j].getValue() * 2);
                tiles[j + 1].setValue(0);
                if (tiles[j].getValue() > maxTile) maxTile = tiles[j].getValue();
                score += tiles[j].getValue();
                isChanged = true;
            }
        }

        if (isChanged) {
            Tile temp;
            for (int j = 0; j < 3; j++) {
                if (tiles[j].getValue() == 0 && tiles[j + 1].getValue() != 0) {
                    temp = tiles[j];
                    tiles[j] = tiles[j + 1];
                    tiles[j + 1] = temp;
                }
            }
        }
        return isChanged;
    }

    private void oneRightRotate() {
        Tile tmp;
        int baseArrayLength = gameTiles.length;
        for (int i = 0; i < baseArrayLength / 2; i++) {
            for (int j = i; j < baseArrayLength - 1 - i; j++) {
                tmp = gameTiles[i][j];
                gameTiles[i][j] = gameTiles[baseArrayLength - j - 1][i];
                gameTiles[baseArrayLength - j - 1][i] = gameTiles[baseArrayLength - i - 1][baseArrayLength - j - 1];
                gameTiles[baseArrayLength - i - 1][baseArrayLength - j - 1] = gameTiles[j][baseArrayLength - i - 1];
                gameTiles[j][baseArrayLength - i - 1] = tmp;
            }
        }
    }

    public void left() {
        boolean isChanged = false;

        if (isSaveNeeded) {
            saveState(this.gameTiles);
        }
        for (Tile[] tileLine : gameTiles) {
            if (compressTiles(tileLine) | mergeTiles(tileLine)) {
                isChanged = true;
            }
        }
        if (!getEmptyTiles().isEmpty() && isChanged) {
            addTile();
            isSaveNeeded = true;
        }
    }

    public void up() {
        saveState(this.gameTiles);
        oneRightRotate();
        oneRightRotate();
        oneRightRotate();
        left();
        oneRightRotate();
    }

    public void right() {
        saveState(this.gameTiles);
        oneRightRotate();
        oneRightRotate();
        left();
        oneRightRotate();
        oneRightRotate();
    }

    public void down() {
        saveState(this.gameTiles);
        oneRightRotate();
        left();
        oneRightRotate();
        oneRightRotate();
        oneRightRotate();
    }

    public Tile[][] getGameTiles() {
        return gameTiles;
    }

    public boolean canMove() {
        boolean isChanged = false;
        for (int i = 0; i < 4; i++) {
            oneRightRotate();
            Tile[][] tmp = gameTiles;
            for (Tile[] tileLine : tmp) {
                if (compressTiles(tileLine) | mergeTiles(tileLine)) {
                    isChanged = true;
                }
            }
            if (!getEmptyTiles().isEmpty() && isChanged) {
                isChanged = true;
            }
        }
        return isChanged;
    }

    private void saveState(Tile[][] tiles) {
        Tile[][] fieldToSave = new Tile[tiles.length][tiles[0].length];
        for (int i = 0; i < tiles.length; i++) {
            for (int j = 0; j < tiles[0].length; j++) {
                fieldToSave[i][j] = new Tile(tiles[i][j].getValue());
            }
        }
        previousStates.push(fieldToSave);
        int scoreToSave = score;
        previousScores.push(scoreToSave);
        isSaveNeeded = false;
    }

    public void rollback() {
        if (!previousStates.empty() && !previousScores.empty()) {
            gameTiles = previousStates.pop();
            score = previousScores.pop();
        }
    }

    public void randomMove() {
        int n = ((int) (Math.random() * 100)) % 4;
        switch (n) {
            case 0:
                left();
                return;
            case 1:
                right();
                return;
            case 2:
                up();
                return;
            case 3:
                down();
                return;
        }
    }

    private int massiveSumm(Tile[][] tiles) {
        int summ = 0;
        for (Tile tile[] :tiles) {
            for (Tile tile1 :tile) {
                summ += tile1.getValue();
            }
        }
        return summ;
    }

    public boolean hasBoardChanged() {
        boolean boardChanged = false;
        if(massiveSumm(getGameTiles()) != massiveSumm(previousStates.peek())) {
            boardChanged = true;
        }
        return boardChanged;
    }

    public MoveEfficiency getMoveEfficiency(Move move) {
        MoveEfficiency moveEfficiency;
        move.move();

        if (hasBoardChanged()) {
            moveEfficiency = new MoveEfficiency(getEmptyTiles().size(), score, move);
        } else {
            moveEfficiency = new MoveEfficiency(-1, 0, move);
        }

        rollback();
        return moveEfficiency;
    }

    public void autoMove() {
        PriorityQueue<MoveEfficiency> priorityQueue = new PriorityQueue(4, Collections.reverseOrder());
        priorityQueue.offer(getMoveEfficiency(this::left));
        priorityQueue.offer(getMoveEfficiency(this::right));
        priorityQueue.offer(getMoveEfficiency(this::up));
        priorityQueue.offer(getMoveEfficiency(this::down));
        Move move = priorityQueue.peek().getMove();
        move.move();
    }
}
