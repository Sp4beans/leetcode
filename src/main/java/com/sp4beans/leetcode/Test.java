package com.sp4beans.leetcode;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 * @author wangjixin <wangjixin@kuaishou.com>
 * Created on 2020-05-13
 */
public class Test extends Application implements EventHandler<MouseEvent> {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Button button = new Button("button");
        button.setOnMouseClicked(event -> System.out.println("clicked"));

        StackPane stackPane = new StackPane();
        stackPane.getChildren().add(button);

        Scene scene = new Scene(stackPane, 400, 400);
        primaryStage.setScene(scene);

        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void handle(MouseEvent event) {

    }
}
