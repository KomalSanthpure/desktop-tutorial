package com.example.snakeladdermarchdemo;

import javafx.util.Pair;

import java.util.ArrayList;

public class Board {
    private ArrayList<Pair<Integer,Integer>> positionCoordinates;
    private ArrayList<Integer>snakeLadder;
    public  Board()
    {
        populatePositionCoordinates();
        setSnakeLadder();

    }
    private void populatePositionCoordinates()
    {
        positionCoordinates=new ArrayList<>();
        positionCoordinates.add(new Pair<>(0,0)); //dummy value
        for(int i = 0; i< SnakeLadder.height; i++)
        {
            for(int j = 0; j< SnakeLadder.width; j++)
            {
                //x axis
                int xCord = 0;
                if(i%2 == 0)
                {
                    xCord = j*SnakeLadder.tileSize + SnakeLadder.tileSize/2;
                }
                else {
                    xCord = SnakeLadder.height * SnakeLadder.tileSize - j * SnakeLadder.tileSize - SnakeLadder.tileSize / 2;
                }


                //y axis
                int yCord = SnakeLadder.height * SnakeLadder.tileSize - i * SnakeLadder.tileSize - SnakeLadder.tileSize / 2;
                positionCoordinates.add(new Pair<>(xCord,yCord));
            }
        }
    }
    private void  setSnakeLadder()
    {
        snakeLadder=new ArrayList<>();
        for (int i = 0; i < 101; i++) {
            snakeLadder.add(i);
        }
        snakeLadder.set(4,14);
        snakeLadder.set(17,7);
        snakeLadder.set(9,31);
        snakeLadder.set(28,84);
        snakeLadder.set(21,42);
        snakeLadder.set(51,67);
        snakeLadder.set(54,34);
        snakeLadder.set(62,19);
        snakeLadder.set(64,60);
        snakeLadder.set(72,91);
        snakeLadder.set(80,99);
        snakeLadder.set(87,36);
        snakeLadder.set(93,73);
        snakeLadder.set(95,75);
        snakeLadder.set(98,79);



    }
    public int getXCoordinate(int position)
    {
        if(position > 0 && position <= 100)
        {
            return positionCoordinates.get(position).getKey();
        }
        return  -1;
    }
    public int getSnakeLadder(int position)
    {
        return  snakeLadder.get(position);
    }
    public int getYCoordinate(int position)
    {
        if(position > 0 && position <= 100)
        {
            return positionCoordinates.get(position).getValue();
        }
        return  -1;
    }

    public static void main(String[] args) {
        Board board=new Board();
        for (int i=0; i<board.positionCoordinates.size(); i++)
        {
            System.out.println(i+" $ X :" + board.positionCoordinates.get(i).getKey()
            + " Y : " +board.positionCoordinates.get(i).getValue());


        }
    }
}
