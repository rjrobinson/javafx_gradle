package com.scgrk;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class Main extends Application {

  public static void main(String[] args) {
    launch(args);
  }

  @Override
  public void start(Stage primaryStage) {
    Parent root = new HBox(new Label("Hello JavaFX"));
    primaryStage.setScene(new Scene(root));
    primaryStage.show();
  }
}
