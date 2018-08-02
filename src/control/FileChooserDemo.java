package control;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/**
 * 
 * @author Administrator
 *
 *
 *         FileChooser允许用户导航文件系统并选择一个文件或文件夹。 FileChooser类位于javafx.stage包中。
 * 
 *         打开文件
 * 
 *         文件选择器可用作打开文件对话框，用于选择单个文件或多个文件，或作为文件保存对话框。
 *         以下代码创建一个FileChooser对象并设置其标题，然后显示给用户。 FileChooser fileChooser =
 *         newFileChooser(); fileChooser.setTitle("Open Resource File");
 *         fileChooser.showOpenDialog(stage);
 *         可以通过设置initialDirectory和title属性来配置文件选择器对话框窗口
 * 
 * 
 *         扩展过滤器
 * 
 *         可以设置扩展过滤器来确定在文件选择器中打开哪些文件。
 * 
 *         fileChooser.setTitle("View Pictures");
 *         fileChooser.setInitialDirectory(new
 *         File(System.getProperty("user.home")) );
 *         fileChooser.getExtensionFilters().addAll( new
 *         FileChooser.ExtensionFilter("All Images", "*.*"), new
 *         FileChooser.ExtensionFilter("JPG", "*.jpg"), new
 *         FileChooser.ExtensionFilter("GIF", "*.gif"), new
 *         FileChooser.ExtensionFilter("BMP", "*.bmp"), new
 *         FileChooser.ExtensionFilter("PNG", "*.png") );
 * 
 * 
 *         保存文件
 * 
 *         FileChooser API允许用户为由应用程序保存的文件指定文件名及其文件夹。 showSaveDialog方法打开保存对话框窗口。
 * 
 *         FileChooser fileChooser1 = new FileChooser();
 *         fileChooser1.setTitle("Save Image"); System.out.println(pic.getId());
 *         File file = fileChooser1.showSaveDialog(stage);
 *         System.out.println(file);
 */
public class FileChooserDemo extends Application {

	// instance variables
	private String filePath;

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		primaryStage.setTitle("FileChooser demo");

		VBox vbox = new VBox(8);

		TextArea txtFileContent = new TextArea();
		//txtFileContent.setPrefRowCount(20);
		txtFileContent.prefHeightProperty().bind(primaryStage.heightProperty());
		Button loadButton = new Button("Load text file");
		Button saveButton = new Button("save");
		Button saveAsButton = new Button("save as");
		loadButton.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				// 创建FileChooser对象,点击按钮会弹出一个对话框
				FileChooser fc = new FileChooser();
				// 设置对话框标题
				fc.setTitle("Oper txt file");
				// 过滤文件
				fc.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("all files", "*.*"),
						new FileChooser.ExtensionFilter("txt files", "*.txt"));
				// 然后showOpenDialog(Stage stage)返回一个File对象
				// 如果没有选择文件，而是点击取消则返回null
				File selectedFile = fc.showOpenDialog(primaryStage);
				if (selectedFile == null) {
					System.out.println("canceled");
				} else {
					filePath = selectedFile.toString();
					System.out.println(filePath);

					StringBuilder sb = new StringBuilder();
					try {
						InputStream in = new FileInputStream(selectedFile);
						int len = -1;
						byte[] buffer = new byte[1024];
						while ((len = in.read(buffer)) != -1) {
							sb.append(new String(buffer, 0, len, "utf-8"));
						}
						in.close();
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

					txtFileContent.setText(sb.toString());
					saveButton.setDisable(false);
					saveAsButton.setDisable(false);
				}
			}
		});

		saveButton.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				try {
					OutputStream out = new FileOutputStream(filePath);
					byte[] source = txtFileContent.getText().getBytes("utf-8");
					out.write(source, 0, source.length);
					System.out.println("修改成功");
					out.close();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		});
		saveButton.setDisable(true);

		saveAsButton.setDisable(true);
		saveAsButton.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				FileChooser fc = new FileChooser();
				fc.getExtensionFilters().add(new FileChooser.ExtensionFilter("file name", "*.txt"));
				fc.setTitle("save as");
				File file = fc.showSaveDialog(primaryStage);
				if (file != null) {
					System.out.println(file);

					try {
						OutputStream out = new FileOutputStream(file);
						byte[] source = txtFileContent.getText().getBytes("utf-8");
						out.write(source, 0, source.length);
						System.out.println("另存成功");
						out.close();
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}

			}

		});

		HBox hbox = new HBox(8);
		hbox.getChildren().addAll(loadButton, saveButton, saveAsButton);
		vbox.getChildren().addAll(hbox, txtFileContent);

		Scene scene = new Scene(vbox, 600, 450);
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}

}
