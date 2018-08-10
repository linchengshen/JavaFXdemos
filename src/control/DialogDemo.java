package control;

import java.util.Optional;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.DialogEvent;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class DialogDemo extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		Dialog<ButtonType> dialog = new Dialog<>();
		dialog.setOnShowing(new EventHandler<DialogEvent>() {

			@Override
			public void handle(DialogEvent event) {
				// TODO Auto-generated method stub
				System.out.println("dialog is showing");
			}

		});

		dialog.setOnShown(new EventHandler<DialogEvent>() {

			@Override
			public void handle(DialogEvent event) {
				// TODO Auto-generated method stub
				System.out.println("dialog has been shown");
			}

		});

		ButtonType okButton = ButtonType.OK;
		ButtonType cancelButton = ButtonType.CANCEL;
		dialog.getDialogPane().getButtonTypes().addAll(okButton, cancelButton);
		dialog.setTitle("逆水寒 卸载");
		//dialog.setHeaderText("你是否确定退出？");
		dialog.setGraphic(
				new ImageView("http://www.icosky.com/icon/16/System/xAdium%20dock%20icons%20for%20Adium/alert.png"));
		dialog.setContentText("你确实要完全移除逆水寒，及其所有组件？");

		Optional<ButtonType> result = dialog.showAndWait();
		if (result.isPresent()) {
			if (ButtonType.OK == result.get()) {
				System.out.println("ok");
			} else if (ButtonType.CANCEL == result.get()) {
				System.out.println("cancel");
			}
			dialog.close();
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}

}
