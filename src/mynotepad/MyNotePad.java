package mynotepad;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Font;
import javafx.stage.FileChooser;
import javafx.stage.Stage;




/**
 * 
 * @author Administrator
 *
 *
 *         �� windows notepad ����Ȼ˼·�Ƚ������������˵����������¼���Ӧ��IO�Ȼ��������� ���Ǵ���ܶ�����ظ� ����������
 */
public class MyNotePad extends Application {
	private File file;

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		primaryStage.setTitle("�ޱ���  - my notepad");

		// use BorderPane to layout
		BorderPane root = new BorderPane();

		TextArea textArea = new TextArea();
		textArea.setFont(Font.font(16));

		// menu bar
		MenuBar menuBar = new MenuBar();
		menuBar.prefWidthProperty().bind(primaryStage.widthProperty());

		// menus of mynotepad
		Menu fileMenu = new Menu("�ļ�(F)");
		MenuItem newMenuItem = new MenuItem("�½�(N)");
		newMenuItem.setAccelerator(new KeyCodeCombination(KeyCode.N, KeyCombination.SHORTCUT_DOWN));
		newMenuItem.setOnMenuValidation(new EventHandler<Event>() {
			@Override
			public void handle(Event event) {
				System.out.println("ctrl + n pressed");
			}
		});

		// open menuItem

		MenuItem openMenuItem = new MenuItem("��(O)");
		openMenuItem.setAccelerator(new KeyCodeCombination(KeyCode.O, KeyCombination.SHORTCUT_DOWN));
		openMenuItem.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				FileChooser fc = new FileChooser();
				fc.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("txt file", "*.txt"));
				File selectedFile = fc.showOpenDialog(primaryStage);
				if (selectedFile != null) {
					file = selectedFile;
					try (InputStream in = new FileInputStream(selectedFile)) {
						StringBuilder sb = new StringBuilder();
						byte[] buffer = new byte[1024];
						int len = -1;
						while ((len = in.read(buffer)) != -1) {
							sb.append(new String(buffer, 0, len, "utf-8"));
						}
						primaryStage.setTitle(selectedFile.getName() + " - my notepad");
						textArea.setText(sb.toString());
					} catch (FileNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}

		});

		// save menuItem
		MenuItem saveMenuItem = new MenuItem("����(S)");
		saveMenuItem.setAccelerator(new KeyCodeCombination(KeyCode.S, KeyCombination.SHORTCUT_DOWN));
		saveMenuItem.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				if (file != null) {
					try (OutputStream out = new FileOutputStream(file)) {
						out.write(textArea.getText().getBytes("utf-8"));
					} catch (FileNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				} else {
					FileChooser fc = new FileChooser();
					fc.getExtensionFilters().add(new FileChooser.ExtensionFilter("txt file", "*.txt"));
					File fileToSave = fc.showSaveDialog(primaryStage);
					if (fileToSave != null) {
						file = fileToSave;
						try (OutputStream out = new FileOutputStream(fileToSave)) {
							out.write(textArea.getText().getBytes("utf-8"));
							System.out.println(textArea);
						} catch (FileNotFoundException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
			}
		});

		// save as menuItem
		MenuItem saveAsMenuItem = new MenuItem("���Ϊ(A)");
		saveAsMenuItem.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				FileChooser fc = new FileChooser();
				fc.getExtensionFilters().add(new FileChooser.ExtensionFilter("txt file", "*.txt"));
				File fileToSave = fc.showSaveDialog(primaryStage);
				if (fileToSave != null) {
					file = fileToSave;
					try (OutputStream out = new FileOutputStream(fileToSave)) {
						out.write(textArea.getText().getBytes("utf-8"));
						System.out.println(textArea);
					} catch (FileNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		});

		// exit menuItem
		MenuItem exitMenuItem = new MenuItem("�˳�(X)");
		exitMenuItem.setAccelerator(new KeyCodeCombination(KeyCode.E, KeyCombination.SHORTCUT_DOWN));

		exitMenuItem.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				Platform.exit();
				System.out.println(111111);
			}
		});

		fileMenu.getItems().addAll(newMenuItem, openMenuItem, saveMenuItem, saveAsMenuItem, exitMenuItem);

		// edit menu
		Menu editMenu = new Menu("�༭(E)");
		// items of edit menu
		MenuItem selectAll = new MenuItem("ȫѡ(A)");
		selectAll.setAccelerator(new KeyCodeCombination(KeyCode.A, KeyCombination.SHORTCUT_DOWN));
		selectAll.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				textArea.selectAll();
			}
		});
		MenuItem unDo = new MenuItem("����(U)");
		unDo.setAccelerator(new KeyCodeCombination(KeyCode.Z, KeyCombination.SHORTCUT_DOWN));
		unDo.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				textArea.undo();
			}
		});

		MenuItem cutMenuItem = new MenuItem("����(T)");
		cutMenuItem.setAccelerator(new KeyCodeCombination(KeyCode.X, KeyCombination.SHORTCUT_DOWN));
		cutMenuItem.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				textArea.cut();
			}

		});

		MenuItem copyMenuItem = new MenuItem("����(C)");
		copyMenuItem.setAccelerator(new KeyCodeCombination(KeyCode.C, KeyCombination.SHORTCUT_DOWN));
		copyMenuItem.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				textArea.copy();
			}
		});

		MenuItem pasteMenuItem = new MenuItem("ճ��(V)");
		pasteMenuItem.setAccelerator(new KeyCodeCombination(KeyCode.V, KeyCombination.SHORTCUT_DOWN));
		pasteMenuItem.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				textArea.paste();
			}
		});

		MenuItem findMenuItem = new MenuItem("����(F)");
		findMenuItem.setAccelerator(new KeyCodeCombination(KeyCode.F, KeyCombination.SHORTCUT_DOWN));
		findMenuItem.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
			}
		});

		MenuItem findNextMenuItem = new MenuItem("������һ��(N)");
		findNextMenuItem.setAccelerator(new KeyCodeCombination(KeyCode.F3, KeyCombination.SHORTCUT_DOWN));
		findNextMenuItem.setOnMenuValidation(new EventHandler<Event>() {
			@Override
			public void handle(Event event) {
				System.out.println("F3 press");
			}
		});
		MenuItem replaceMenuItem = new MenuItem("�滻(R)");
		replaceMenuItem.setAccelerator(new KeyCodeCombination(KeyCode.H, KeyCombination.SHORTCUT_DOWN));

		editMenu.getItems().addAll(selectAll, unDo, cutMenuItem, copyMenuItem, pasteMenuItem, findMenuItem,
				findNextMenuItem, replaceMenuItem);

		menuBar.getMenus().addAll(fileMenu, editMenu);
		root.setTop(menuBar);
		root.setCenter(textArea);

		// set scene
		Scene scene = new Scene(root, 950, 600);
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}

}
