package control;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * 
 * @author Administrator
 * 
 *         �˵�������Ӧ�ó���ѡ��ѡ��ı�׼������ �˵��Ͳ˵��������ѡ��ѡ���ݼ���ϣ���Ϊ���̿�ݼ���
 * 
 *         �����˵��Ͳ˵���
 * 
 *         ���봴��һ���˵���javafx.scene.control.MenuBar����������javafx.scene.control.Menu����
 * 
 *         �˵�������԰���Menu��javafx.scene.control.MenuItem���󡣲˵����԰��������˵���Ϊ�Ӳ˵���
 *         MenuItems��Menu�����ڵ���ѡ�
 * 
 *         ���´�����ʾ��δ����˵�������Ӳ˵��Ͳ˵��
 * 
 *         Menu����MenuItem�����࣬����һ��getItems().add()���������ܹ������������Menu��MenuItemʵ������Ԫ�ء�
 * 
 * 
 * 
 *         �˵��¼��������
 * 
 *         Ҫ��˵�������¼�������򣬿���ʹ��setOnAction()������������һ������ΪEventHandler
 *         <ActionEvent>�Ĺ��ܽӿڣ�������ѡ��˵���ʱ���õĴ��������롣
 * 
 * 
 * 
 *         �ؼ����Ƿ�
 * 
 *         ��׼�˵�ͨ�����м������Ƿ�(�����ڿ�ݼ�)�����ڲ�ʹ�����������ѡ��˵��
 *         �û����԰�Alt���ʹ��»���_����ĸ������˵���Ȼ��ʹ�ü�ͷ��������Ҫ��˵���Ӽ����Ƿ���
 *         ʹ��Stringֵ���ù��캯�������ڲ˵���˵�����ı�������ѡ��ĸǰ�����һ���»����ַ���
 * 
 *         Ȼ��true���ݸ�setMnemonicParsing(true)������
 * 
 *         ���´��봴��һ��ʹ����ĸ��F����Ϊ���Ƿ����ļ��˵���
 * 
 *         Menu fileMenu = new Menu("_File"); fileMenu.setMnemonicParsing(true);
 * 
 * 
 *         �����
 * 
 *         �����������ѡ��˵�ѡ��ļ�������ϡ�����ϳ�Ϊ���̿�ݼ���
 * 
 *         ���磬��Windowsƽ̨�ϣ�Ctrl + S����ϼ����Ա����ļ��� ��Mac OSƽ̨�ϣ���ϼ�ΪCommand + S.
 * 
 *         Ctrl��Command��Alt��Shift��Meta�ȼ���Ϊ���μ���
 * 
 *         ͨ�������η��뵥����ĸ���ʹ�á�Ҫ����һ����ϼ���ʹ��KeyCodeCombination���󣬲�������������η���
 * 
 *         ���´��봴��(Ctrl��Meta)+ S�ļ�������ϡ�
 * 
 *         MenuItem saveItem = new MenuItem("_Save");
 *         saveItem.setMnemonicParsing(true); saveItem.setAccelerator(new
 *         KeyCodeCombination(KeyCode.S, KeyCombination.SHORTCUT_DOWN));
 * 
 *         ����ʹ��KeyCombination.SHORTCUT_DOWNֵ��Ϊ�����η���������CONTROL_DOWN��META_DOWN��
 *         SHORTCUT_DOWNֵ��ʹӦ�ó����ܹ���ƽ̨ʹ�á�
 * 
 *         CONTROL_DOWN��META_DOWNֵ�ֱ�������Windows��MacOSƽ̨������SHORTCUT_DOWN������ƽ̨�϶���Ч��
 * 
 * 
 *         ����������¼���ӦsetOnMenuValidation(EventHandler<Event> value) ����
 *         setOnAction(EventHandler<ActionEvent> value)
 * 
 *         KeyCombination �ǳ����� KeyCodeCombination extends KeyCombination
 *         KeyCode��һ��ö����
 * 
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
		MenuItem newMenuItem = new MenuItem("_new file");
		newMenuItem.setAccelerator(new KeyCodeCombination(KeyCode.N, KeyCombination.SHORTCUT_DOWN));
		newMenuItem.setOnMenuValidation(new EventHandler<Event>() {

			@Override
			public void handle(Event event) {
				// TODO Auto-generated method stub
				System.out.println("Ctrl + N �������ļ�");
			}

		});

		MenuItem saveMenuItem = new MenuItem("_save");
		saveMenuItem.setMnemonicParsing(true);
		saveMenuItem.setAccelerator(new KeyCodeCombination(KeyCode.S, KeyCombination.SHORTCUT_DOWN));
		// ��ʽ1���԰��¿�ݼ�ctrl + s���¼���Ӧ
		saveMenuItem.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				System.out.println("ctrl + s" + ":" + event.getClass());

			}
		});

		// ��ʽ�����԰��¿�ݼ�ctrl + s���¼���Ӧ
		saveMenuItem.setOnMenuValidation(new EventHandler<Event>() {

			@Override
			public void handle(Event event) {
				// TODO Auto-generated method stub
				System.out.println("ctrl + S" + event.getClass());
			}

		});

		MenuItem exitMenuItem = new MenuItem("exit");
		exitMenuItem.setAccelerator(new KeyCodeCombination(KeyCode.E, KeyCombination.SHORTCUT_DOWN));
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

		// �����Ĳ˵�
		// ����û�е����˵�
		ContextMenu contextMenu = new ContextMenu(exitMenuItem);
		primaryStage.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				// TODO Auto-generated method stub
				if (event.getButton() == MouseButton.SECONDARY || event.isControlDown()) {
					contextMenu.show(root,event.getX(),event.getY());
					System.out.println("�Ҽ�");
				} else {
					contextMenu.hide();
					System.out.println("���");
				}
			}

		});

		menuBar.getMenus().addAll(fileMenu, web);
		Scene scene = new Scene(root, 600, 450);
		primaryStage.setScene(scene);
		primaryStage.show();
	}

}
