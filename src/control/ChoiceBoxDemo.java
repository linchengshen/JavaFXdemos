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
 *         ������web�е�select
 * 
 *         JavaFXѡ��������û��ڼ���ѡ��֮�����ѡ��
 * 
 *         ����һ��ѡ���
 * 
 *         ���ǿ���ʹ��ChoiceBox�еĹ��캯��������ChoiceBox����
 * 
 *         ���´�����ʾ�����ʹ���乹�캯�����������ѡ��� �б����Ǵӿɹ۲���б��������ġ�
 * 
 *         ChoiceBox cb = new ChoiceBox(FXCollections.observableArrayList("A",
 *         "B", "C")); Java ���ǻ�����ʹ��һ���յ�ѡ���ʹ������Ĭ�Ϲ��캯������ʹ��setItems���������б��
 * 
 *         ChoiceBox cb = new ChoiceBox();
 *         cb.setItems(FXCollections.observableArrayList( "A", "B", new
 *         Separator(), "C", "D") );
 * 
 * 
 *         ������������,��һ�������� public ChoiceBox()<T> {} public
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
