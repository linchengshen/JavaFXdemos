package control;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Pagination;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Callback;

public class PaginationDemo extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		primaryStage.setTitle("分页示例");

		BorderPane root = new BorderPane();

		// 有三个构造器
		// 只有一个参数，则pageIndex为0
		// 没有参数，则pageCount为Integer.MAX_VALUE
		// public Pagination(int pageCount,int pageIndex);

		Pagination pagination = new Pagination(20);
		pagination.setPrefHeight(32);
		pagination.currentPageIndexProperty().addListener(new ChangeListener<Number>() {

			@Override
			public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
				// TODO Auto-generated method stub
				System.out.println("current page number is " + (newValue.intValue() + 1));
			}

		});

		// 默认为10
		pagination.setMaxPageIndicatorCount(20);

		// The pageFactoryProperty is a callback function that is called when a page has
		// been selected by the application or the user. The function is required for
		// the functionality of the pagination control. The callback function should
		// load and return the contents of the selected page. Null should be returned if
		// the selected page index does not exist.
		pagination.setPageFactory(new Callback<Integer, Node>() {

			@Override
			public Node call(Integer param) {
				// TODO Auto-generated method stub
				VBox vbox = new VBox(5);
				for (int i = 0; i < param + 10; i++) {
					Hyperlink hyperLink = new Hyperlink("http://personalcarehub/page/" + i);
					vbox.getChildren().add(hyperLink);
				}
				return vbox;
			}

		});

		// 监听键盘事件
		pagination.addEventHandler(KeyEvent.KEY_PRESSED, new EventHandler<KeyEvent>() {

			@Override
			public void handle(KeyEvent event) {
				// TODO Auto-generated method stub
				System.out.println("Key " + event.getCode().getName() + " was pressed!");
			}

		});
		root.setBottom(pagination);
		Scene scene = new Scene(root, 600, 450);
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}

}
