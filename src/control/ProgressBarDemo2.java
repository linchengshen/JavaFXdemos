package control;

import java.util.Set;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class ProgressBarDemo2 extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub

		primaryStage.setTitle("�Զ����½�����demo");
		GridPane root = new GridPane();
		root.setVgap(10);
		root.setHgap(10);
		root.setPadding(new Insets(8));

		Label notification = new Label("File Transfer");
		root.add(notification, 0, 0);

		ProgressBar progressBar = new ProgressBar(0);
		root.add(progressBar, 1, 0);

		Button startButton = new Button("start");
		root.add(startButton, 0, 1);

		Button cancelButton = new Button("cancel");
		root.add(cancelButton, 1, 1);

		// ������Ӧ�¼�

		startButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				// Task ʵ����Runnable�ӿڣ����Դ���Thread(Runnable thread)�����̶߳���
				// Task�ǳ����࣬Ҫ����call()����
				Task<Object> copyWorker = new Task<Object>() {

					@Override
					protected Object call() throws Exception {
						// TODO Auto-generated method stub
						for (int i = 1; i <= 20; i++) {
							Thread.sleep(100);
							// thisָ���ǵ�ǰtask����
							// updateMessage(String message)
							this.updateMessage(100 * i + " ����");
							// updateProgress(long workDone,long max)
							// updateProgress(double workDone,double max)
							this.updateProgress(i, 20);
						}
						return null;
					}

				};

				startButton.setDisable(true);
				cancelButton.setDisable(false);
				// progressBar.setProgress(0);
				progressBar.progressProperty().unbind();
				progressBar.progressProperty().bind(copyWorker.progressProperty());
				copyWorker.messageProperty().addListener(new ChangeListener<String>() {

					@Override
					public void changed(ObservableValue<? extends String> observable, String oldValue,
							String newValue) {
						// TODO Auto-generated method stub
						System.out.println(newValue);
					}

				});
				new Thread(copyWorker, "worker").start();
				System.out.println("start new thread");
			}
		});

		// cancelButton

		cancelButton.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				startButton.setDisable(false);
				cancelButton.setDisable(true);
				progressBar.progressProperty().unbind();
				progressBar.setProgress(0);
				// ȡ����ť��ʱ��ͬʱ�ж��������е�worker�̣߳������һֱִ�е�����
				Set<Thread> threadSet = Thread.getAllStackTraces().keySet();
				Thread[] tarr = threadSet.toArray(new Thread[threadSet.size()]);
				for (Thread t : tarr) {
					if ("worker".equals(t.getName())) {
						t.interrupt();
					}
				}
				System.out.println("canceled!");
			}

		});

		Scene scene = new Scene(root, 450, 300);
		primaryStage.setScene(scene);
		primaryStage.show();

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}

}
