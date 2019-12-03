
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
	File name: TrafficLightRunner.java
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
public class TrafficLightRunner extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        GridPane root = new GridPane();
        TrafficLight tl1 = new TrafficLight();

        root.getChildren().add(tl1);
        Scene scene = new Scene(root, 600, 600);
        
        stage.setScene(scene);
        stage.setTitle("Traffic Lights");
        stage.show();
        
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
