

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.util.Duration;

/**
	File name: TrafficLight.java
	Short description: ??????
	IST 242 Assignment:  
	@author Joshua Michaels
	@version 1.01 2014-08-25
	date of last revision:
	details of the revision: none
*/




/**
 *
 * @author Joshua
 */
public class TrafficLight extends Pane {

    private final double radius = 20;
    private double x = 150; 
    private double y = 95; 
    private double x2 = 150; 
    private double y2 = 135; 
    private double x3 = 150; 
    private double y3 = 177; 
    private final Circle circle = new Circle(x,y, radius);
    private final Circle circle2 = new Circle(x2,y2, radius);
    private final Circle circle3 = new Circle(x3,y3, radius);
    private Slider s1;
    private Slider s2;
    private Slider s3;
    private Label l1;    
    private Label l2;
    private Label l3;    
    private Label l4;
    private Label l5;    
    private Label l6;
    private Button startButton;
    private Button stopButton;
    final Timeline timeline = new Timeline();
    final Timeline timeline2 = new Timeline();
    final Timeline timeline3 = new Timeline();
    
    public TrafficLight() {
        
    
    timeline.getKeyFrames().add(new KeyFrame(Duration.millis(5000)));
   
    timeline2.getKeyFrames().add(new KeyFrame(Duration.millis(5000)));
    
    timeline3.getKeyFrames().add(new KeyFrame(Duration.millis(5000)));
    
        circle.setFill(Paint.valueOf("RED"));
        circle.setVisible(false);
        circle2.setFill(Paint.valueOf("YELLOW"));
        circle2.setVisible(false);
        circle3.setFill(Paint.valueOf("GREEN"));
        circle3.setVisible(false);
        getChildren().add(this.circle);
        getChildren().add(this.circle2);
        getChildren().add(this.circle3);
        
        s1 = new Slider(0, 30, 0);       
        s1.setTranslateX(50);
        s1.setTranslateY(200);
        s1.valueProperty().addListener(new RedListener());
        getChildren().add(this.s1);
        
        s2 = new Slider(0, 30, 0);       
        s2.setTranslateX(60);
        s2.setTranslateY(220);
        s2.valueProperty().addListener(new YellowListener());
        getChildren().add(this.s2);
        
        s3 = new Slider(0, 30, 0);       
        s3.setTranslateX(60);
        s3.setTranslateY(240);
        s3.valueProperty().addListener(new GreenListener());
        getChildren().add(this.s3);
        
        l1 = new Label("Red");
        l1.setLayoutX(20);
        l1.setLayoutY(200);
        l2 = new Label(s1.getValue() + " seconds");
        l2.setLayoutX(200);
        l2.setLayoutY(200);
        getChildren().add(this.l1);
        getChildren().add(this.l2);
        
        l3 = new Label("Yellow");
        l3.setLayoutX(20);
        l3.setLayoutY(220);
        l4 = new Label(s2.getValue() + " seconds");
        l4.setLayoutX(200);
        l4.setLayoutY(220);
        getChildren().add(this.l3);
        getChildren().add(this.l4);
        
        l5 = new Label("Green");
        l5.setLayoutX(20);
        l5.setLayoutY(240);
        l6 = new Label(s3.getValue() + " seconds");
        l6.setLayoutX(200);
        l6.setLayoutY(240);
        getChildren().add(this.l5);
        getChildren().add(this.l6);
        
        startButton = new Button("Start");
        startButton.setLayoutX(50);
        startButton.setLayoutY(300);       
        startButton.setOnAction(new EventHandler()
        {            
            @Override
            public void handle(Event event) {
                if (startButton.isArmed())
                {
                    timeline.play();
                    timeline2.play();
                    timeline3.play();                 
                    stopButton.setDisable(true);
                    circle.setVisible(true);
                    circle2.setVisible(true);
                    circle3.setVisible(true);                                        
                    
                }
                
            }
        }
        );
        getChildren().add(this.startButton);
        stopButton = new Button("Stop");
        stopButton.setLayoutX(150);
        stopButton.setLayoutY(300);       
        stopButton.setOnAction(new EventHandler()
        {            
            @Override
            public void handle(Event event) {
                if (stopButton.isPressed())
                {
                    circle.setVisible(false);
                    circle2.setVisible(false);
                    circle3.setVisible(false);
                }
            }
        }
        );
        getChildren().add(this.stopButton);
        
       
        
    }
    
    
    
    
    class RedListener implements ChangeListener {

        @Override
        public void changed(ObservableValue observable, Object oldValue, Object newValue) {
            newValue = s1.getValue();
            timeline.setRate(((double) newValue));
            l2.setText(newValue + " seconds");
            
        }
        
    }

    class YellowListener implements ChangeListener {

        @Override
        public void changed(ObservableValue observable, Object oldValue, Object newValue) {
            newValue = s2.getValue();
            timeline2.setRate(((double) newValue));
            l4.setText(newValue + " seconds");
        }
        
    }
    
    class GreenListener implements ChangeListener {

        @Override
        public void changed(ObservableValue observable, Object oldValue, Object newValue) {
            newValue = s3.getValue();
            timeline3.setRate(((double) newValue));
            l6.setText(newValue + " seconds");
        }
        
    }
}

    
