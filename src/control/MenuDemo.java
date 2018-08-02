package control;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * 
 * @author Administrator
 * 
 *         菜单是桌面应用程序选择选项的标准方法。 菜单和菜单项可以与选择选项快捷键组合，称为键盘快捷键。
 * 
 *         创建菜单和菜单项
 * 
 *         必须创建一个菜单栏javafx.scene.control.MenuBar对象来保存javafx.scene.control.Menu对象。
 * 
 *         菜单对象可以包含Menu和javafx.scene.control.MenuItem对象。菜单可以包含其他菜单作为子菜单。
 *         MenuItems是Menu对象内的子选项。
 * 
 *         以下代码显示如何创建菜单栏并添加菜单和菜单项。
 * 
 *         Menu类是MenuItem的子类，它有一个getItems().add()方法，它能够添加诸如其他Menu和MenuItem实例的子元素。
 * 
 * 
 * 
 *         菜单事件处理程序
 * 
 *         要向菜单项添加事件处理程序，可以使用setOnAction()方法，它接收一个类型为EventHandler
 *         <ActionEvent>的功能接口，它是在选择菜单项时调用的处理程序代码。
 * 
 * 
 * 
 *         关键助记符
 * 
 *         标准菜单通常具有键盘助记符(类似于快捷键)，以在不使用鼠标的情况下选择菜单项。
 *         用户可以按Alt键和带下划线_的字母来激活菜单，然后使用箭头键导航。要向菜单添加键助记符，
 *         使用String值调用构造函数，并在菜单或菜单项的文本中在所选字母前面放置一个下划线字符。
 * 
 *         然后将true传递给setMnemonicParsing(true)方法。
 * 
 *         以下代码创建一个使用字母“F”作为助记符的文件菜单。
 * 
 *         Menu fileMenu = new Menu("_File"); fileMenu.setMnemonicParsing(true);
 * 
 * 
 *         键组合
 * 
 *         键组合是用于选择菜单选项的键击的组合。键组合称为键盘快捷键。
 * 
 *         例如，在Windows平台上，Ctrl + S的组合键可以保存文件。 在Mac OS平台上，组合键为Command + S.
 * 
 *         Ctrl，Command，Alt，Shift和Meta等键称为修饰键。
 * 
 *         通常，修饰符与单个字母组合使用。要创建一个组合键，使用KeyCodeCombination对象，并传入击键和修饰符。
 * 
 *         以下代码创建(Ctrl或Meta)+ S的键代码组合。
 * 
 *         MenuItem saveItem = new MenuItem("_Save");
 *         saveItem.setMnemonicParsing(true); saveItem.setAccelerator(new
 *         KeyCodeCombination(KeyCode.S, KeyCombination.SHORTCUT_DOWN));
 * 
 *         代码使用KeyCombination.SHORTCUT_DOWN值作为键修饰符，而不是CONTROL_DOWN或META_DOWN。
 *         SHORTCUT_DOWN值将使应用程序能够跨平台使用。
 * 
 *         CONTROL_DOWN和META_DOWN值分别依赖于Windows和MacOS平台，但是SHORTCUT_DOWN在所有平台上都有效。
 *
 */
public class MenuDemo extends Application {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) {
		primaryStage.setTitle("Menu demo");

		BorderPane root = new BorderPane();

		// Menubar
		MenuBar menuBar = new MenuBar();
		menuBar.prefWidthProperty().bind(primaryStage.widthProperty());
		root.setTop(menuBar);

		// fileMenu new,save,exit
		Menu fileMenu = new Menu("_file");
		fileMenu.setMnemonicParsing(true);
		MenuItem newMenuItem = new MenuItem("new");
		
		MenuItem saveMenuItem = new MenuItem("_save");
		saveMenuItem.setMnemonicParsing(true);
		saveMenuItem.setAccelerator(new KeyCodeCombination(KeyCode.S, KeyCombination.SHORTCUT_DOWN));
		
		MenuItem exitMenuItem = new MenuItem("exit");
		exitMenuItem.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				Platform.exit();
			}

		});
		fileMenu.getItems().addAll(newMenuItem, saveMenuItem, exitMenuItem);

		// web
		Menu web = new Menu("_web");
		web.setMnemonicParsing(true);

		MenuItem htmlMenuItem = new MenuItem("html");
		MenuItem cssMenuItem = new MenuItem("css");
		MenuItem javascriptMenuItem = new MenuItem("javascript");
		web.getItems().addAll(htmlMenuItem, cssMenuItem, javascriptMenuItem);

		menuBar.getMenus().addAll(fileMenu, web);
		Scene scene = new Scene(root, 600, 450);
		primaryStage.setScene(scene);
		primaryStage.show();
	}

}
