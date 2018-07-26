package shape;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

public class LineDemo extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		primaryStage.setTitle("line demo with javafx");

		HBox hbox = new HBox();
		Scene scene = new Scene(hbox, 300, 300);
		
		Line line = new Line();//new Line(0,0,300,300);
		line.setStartX(0);
		line.setStartY(0);
		line.setEndX(300);
		line.setEndY(300);
		
		line.setStroke(Color.RED);
		line.setStrokeDashOffset(25);
		line.setStrokeWidth(3);
		
		hbox.getChildren().add(line);
		
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String[] args) {
		LineDemo.launch(args);
	}

}
