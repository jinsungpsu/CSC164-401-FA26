package com.example.week12;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 800, 600);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();

        Stage stage2 = new Stage();
        FXMLLoader fxmlLoader2 = new FXMLLoader(HelloApplication.class.getResource("second-scene.fxml"));
        Scene scene2 = new Scene(fxmlLoader2.load(), 800, 600);
        stage2.setTitle("Second stage!");
        stage2.setScene(scene2);
        // stage2.show();

    }
}
