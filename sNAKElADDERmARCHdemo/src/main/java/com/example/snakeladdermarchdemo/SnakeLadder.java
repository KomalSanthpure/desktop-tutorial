package com.example.snakeladdermarchdemo;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;

public class SnakeLadder extends Application {
    public static  final int tileSize=40 ,width=10, height=10,
    buttonLine=height*tileSize+50,infoLine=height*tileSize+20;
    Player playerFirst ,playerSecond;
    boolean firstPlayerTurn=true , gameStart=false;

    int diceValue;
    private Pane createContent()
    {
        Pane root = new Pane();
        root.setPrefSize(width*tileSize,height*tileSize+100);


       // putting 100 tiles on the ui
        for(int i = 0; i < height; i++)
        {
            for(int j = 0;j < width; j++)
            {
                tile tile =new tile(tileSize);
                tile.setTranslateX(i * tileSize);
                tile.setTranslateY(j * tileSize);
                root.getChildren().addAll(tile);

            }

        }
        //putting images
        Image img = new Image("C:\\Users\\Asus\\IdeaProjects\\sNAKElADDERmARCHdemo\\src\\img_1.png");
        ImageView boarImage= new ImageView();
        boarImage.setFitWidth(width*tileSize);
        boarImage.setFitHeight(height*tileSize);
        boarImage.setImage(img);


        root.getChildren().addAll(boarImage);


        // button and info
        Button startButton=new Button("Start");
        startButton.setTranslateX(180);
        startButton.setTranslateY(buttonLine);

        Button playerOneButton=new Button("Player One");
        playerOneButton.setTranslateX(10);
        playerOneButton.setTranslateY(buttonLine);

        Button playerTwoButton=new Button("Player two");
        playerTwoButton.setTranslateX(300);
        playerTwoButton.setTranslateY(buttonLine);

        Label diceLable=new Label("Start The Game");
        diceLable.setTranslateX(180);
        diceLable.setTranslateY(infoLine);


        //players
        playerFirst = new Player("Amit", Color.BLACK,tileSize/2);
        playerSecond = new Player("Sumit",Color.WHITE,tileSize/2-5);



        playerOneButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                if(gameStart)
                {
                    if(firstPlayerTurn)
                    {
                        diceValue=rollDice();
                        diceLable.setText("Dice : " + diceValue);
                        playerFirst.movePlayer(diceValue);
                        firstPlayerTurn = !firstPlayerTurn;
                        if(playerFirst.checkWinner())
                        {
                            diceLable.setText("Winner is " +playerFirst.getName());
                            startButton.setText("Restart");
                            startButton.setDisable(false);
                            firstPlayerTurn=true;
                            gameStart=false;
                        }
                    }
                }

            }
        });
        playerTwoButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                if(gameStart)
                {
                    if(!firstPlayerTurn)
                    {
                        diceValue=rollDice();
                        diceLable.setText("Dice : " + diceValue);
                        playerSecond.movePlayer(diceValue);
                        firstPlayerTurn = !firstPlayerTurn;
                        if(playerSecond.checkWinner())
                        {
                            diceLable.setText("Winner is " +playerSecond.getName());
                            startButton.setText("Restart");
                            startButton.setDisable(false);
                            firstPlayerTurn=true;
                            gameStart=false;
                        }
                    }
                }

            }
        });

        startButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                gameStart =true;
                startButton.setDisable(true);
                playerFirst.setStart();
                playerSecond.setStart();
            }
        });


        root.getChildren().addAll(startButton,playerOneButton,playerTwoButton,diceLable,playerFirst.getCoin(),
                playerSecond.getCoin());
        return  root;

    }
    private int rollDice()
    {
        return (int)(Math.random()*6+1);
    }
    @Override
    public void start(Stage stage) throws IOException {
        Scene scene = new Scene(createContent());
        stage.setTitle("Snake & Ladder");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}