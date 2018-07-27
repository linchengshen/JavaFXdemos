package control;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

/**
 * 
 * @author Administrator
 *
 *
 *         类似于web中的select
 * 
 *         JavaFX选择框允许用户在几个选项之间快速选择。
 * 
 *         创建一个选择框
 * 
 *         我们可以使用ChoiceBox中的构造函数来创建ChoiceBox对象。
 * 
 *         以下代码显示了如何使用其构造函数创建和填充选择框。 列表项是从可观察的列表来创建的。
 * 
 *         ChoiceBox cb = new ChoiceBox(FXCollections.observableArrayList("A",
 *         "B", "C")); Java 我们还可以使用一个空的选择框使用它的默认构造函数，并使用setItems方法设置列表项。
 * 
 *         ChoiceBox cb = new ChoiceBox();
 *         cb.setItems(FXCollections.observableArrayList( "A", "B", new
 *         Separator(), "C", "D") );
 * 
 * 
 *         有两个构造器,是一个泛型类 public ChoiceBox()<T> {} public
 *         ChoiceBox<T>(ObservableList<T> items) {}
 */
public class ChoiceBoxDemo extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub

		primaryStage.setTitle("choicebox demo");
		ChoiceBox<String> choiseBox = new ChoiceBox<>();
		choiseBox.setItems(FXCollections.observableArrayList("A", "B", "C", "D"));

		choiseBox.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {

			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				// TODO Auto-generated method stub
				System.out.println(newValue);
			}

		});
		HBox hbox = new HBox(5);
		hbox.setPadding(new Insets(8));
		hbox.getChildren().add(choiseBox);
		Scene scene = new Scene(hbox, 600, 450);
		primaryStage.setScene(scene);

		primaryStage.show();

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}

}
