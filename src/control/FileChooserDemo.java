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
 *         FileChooser�����û������ļ�ϵͳ��ѡ��һ���ļ����ļ��С� FileChooser��λ��javafx.stage���С�
 * 
 *         ���ļ�
 * 
 *         �ļ�ѡ�������������ļ��Ի�������ѡ�񵥸��ļ������ļ�������Ϊ�ļ�����Ի���
 *         ���´��봴��һ��FileChooser������������⣬Ȼ����ʾ���û��� FileChooser fileChooser =
 *         newFileChooser(); fileChooser.setTitle("Open Resource File");
 *         fileChooser.showOpenDialog(stage);
 *         ����ͨ������initialDirectory��title�����������ļ�ѡ�����Ի��򴰿�
 * 
 * 
 *         ��չ������
 * 
 *         ����������չ��������ȷ�����ļ�ѡ�����д���Щ�ļ���
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
 *         �����ļ�
 * 
 *         FileChooser API�����û�Ϊ��Ӧ�ó��򱣴���ļ�ָ���ļ��������ļ��С� showSaveDialog�����򿪱���Ի��򴰿ڡ�
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
				// ����FileChooser����,�����ť�ᵯ��һ���Ի���
				FileChooser fc = new FileChooser();
				// ���öԻ������
				fc.setTitle("Oper txt file");
				// �����ļ�
				fc.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("all files", "*.*"),
						new FileChooser.ExtensionFilter("txt files", "*.txt"));
				// Ȼ��showOpenDialog(Stage stage)����һ��File����
				// ���û��ѡ���ļ������ǵ��ȡ���򷵻�null
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
					System.out.println("�޸ĳɹ�");
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
						System.out.println("���ɹ�");
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
