package com.example.demo;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

class SignUp extends Application {
    private StackPane root = new StackPane();
    private Stage stage;
    private Button Blogin,Bsignup;

    @Override
    public void init() {
         Bsignup = new Button("SİGN UP"); Blogin = new Button("LOGİN");
        VBox vBox = new VBox();
        PasswordField passwordField1=new PasswordField();
        PasswordField passwordField=new PasswordField();

        vBox.setSpacing(8);
        vBox.setPadding(new Insets(10,10,10,10));
        vBox.getChildren().addAll(
                new Label("Welcome to HUCS Cinema Reservation\nPlease enter your credential below and click LOGIN" +
                        "\nYou can create an account by clicking SİGN UP\nUsername:"),
                new TextField(),
                new Label(" Password"),
                passwordField, new Label(" Password"),passwordField1,
                Bsignup,
                Blogin);
        root.getChildren().addAll(vBox);
        Blogin.setOnAction(actionEvent -> {
            if(stage!=null){




            }
        });

        Bsignup.setOnAction(actionEvent-> {
            if(stage!=null){

                stage.requestFocus();
                return;
            }
            stage = new Stage();
            StackPane stackPane = new StackPane();
            stage.setScene(new Scene(stackPane, 200,200));
            stage.show();
        });
    }


    @Override
    public void start(Stage primaryStage) throws Exception  {
        init();
        Scene scene = new Scene(root,400,600);
        primaryStage.setScene(scene);
        primaryStage.show();
        primaryStage.setTitle("Sign up");
        primaryStage.setAlwaysOnTop(true);

        Blogin.setOnAction(actionEvent -> {
            if(stage!=null){
                try {
                    stage.close();
                    new Login();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        Bsignup.setOnAction(actionEvent-> {
            if(stage!=null){

                stage.requestFocus();
                return;
            }
            stage = new Stage();
            StackPane stackPane = new StackPane();
            stage.setScene(new Scene(stackPane, 200,200));
            stage.show();
        });
    }

  public SignUp( ) throws Exception {
    start(new Stage());
  }
}