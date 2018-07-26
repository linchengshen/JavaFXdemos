package gradient;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
/**
 * 
 * @author yangzaozao
 * 
 * 渐变还不能理解
 *
 */
public class LinearGradientDemo extends Application {

	@Override
	public void start(Stage stage) throws Exception {
		// TODO Auto-generated method stub

		stage.setTitle("线性颜色渐变示例");
		
		
		Rectangle rc = new Rectangle();
		rc.setX(50);
		rc.setY(50);
		rc.setWidth(200);
		rc.setHeight(100);
		
		Stop[] stops = new Stop[] {
			new Stop(0,Color.RED),new Stop(1,Color.BLACK)	
		};
		LinearGradient lg1 = new LinearGradient(0, 0, 1, 0, true, CycleMethod.REPEAT, stops);
		
		//设置渐变
		rc.setFill(lg1);
		
		Group root = new Group();
		root.getChildren().add(rc);
		
		Scene scene = new Scene(root,800,450);
		
		stage.setScene(scene);
		stage.show();
		
		
		

	}

	public static void main(String[] args) {
		launch(args);
	}
}
