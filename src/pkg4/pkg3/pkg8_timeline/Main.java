/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg4.pkg3.pkg8_timeline;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Bounds;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 *
 * @author Luis
 */
public class Main extends Application {
    
    
    @Override
    public void start(Stage stage) {
    	
    	Pane canvas = new Pane();
    	Scene scene = new Scene(canvas, 300, 300, Color.ALICEBLUE);
    	Circle ball = new Circle(10, Color.CADETBLUE);
        ball.relocate(5, 5);
        
        canvas.getChildren().add(ball);
        
        stage.setTitle("Animated Ball");
        stage.setScene(scene);
        stage.show();
        
        Timeline timeline = new Timeline(2, new KeyFrame(Duration.millis(2), 
                new EventHandler<ActionEvent>() {
 
        	double dx = Math.random(); //Step on x or velocity
        	double dy = Math.random(); //Step on y
        	
            @Override
            public void handle(ActionEvent t) {
            	//move the ball
            	ball.setLayoutX(ball.getLayoutX() + dx);
            	ball.setLayoutY(ball.getLayoutY() + dy);
 
                Bounds bounds = canvas.getBoundsInLocal();
                
                //If the ball reaches the left or right border make the step negative
                if(ball.getLayoutX() <= (bounds.getMinX() + ball.getRadius()) || 
                        ball.getLayoutX() >= (bounds.getMaxX() - ball.getRadius()) ){
 
                	dx = -dx;
 
                }
 
                //If the ball reaches the bottom or top border make the step negative
                if((ball.getLayoutY() >= (bounds.getMaxY() - ball.getRadius())) || 
                        (ball.getLayoutY() <= (bounds.getMinY() + ball.getRadius()))){
 
                	dy = -dy;
 
                }
            }
        }));
        
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
    }
    
    public static void main(String[] args) {
        launch();
    }
}

    

        
