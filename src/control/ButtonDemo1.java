package control;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * 
 * @author Administrator
 *
 *
 *
 *         �¼�����
 *         addEventHandler()����������������һ���������¼����͵Ķ��󣬱���MouseEvent.MOUSE_ENTERED,
 *         �ڶ�����EventHandler<MouseEvent>�ӿ�ʵ����Ķ��� ��Ȼ������ֱ��new�ӿڣ��ṩһ�������ڲ���Ķ���
 *
 *
 *         �ڶ��� ѧ�ᷴ���е�getClass(),�ܹ���ȡ��ǰ�ֽ�������ļ��� ͨ���ֽ����ļ���getResource(String
 *         name);����һ��URL�����ڵ���URL�����toExternalForm()���� ���ظ�URL���ַ�����ʾ��ʽ
 *
 *         getStyleClass()�������õ��ýڵ���css����б��ڵ���add()�����һ���ࣨcss�ļ��е�����)
 *
 *         setStyle(String style)����css��ʽ getStyle()��ȡ�Ѿ����õ�cuss��ʽ
 *
 */
public class ButtonDemo1 extends Application {

	// instance variables
	private DropShadow drop = new DropShadow();

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		primaryStage.setTitle("Button DEMO");

		// ����Button
		Button btn = new Button("accept");
		btn.setLayoutX(30);
		btn.setLayoutY(30);
		// ret����url·�����ַ�����ʽfile:/C:/Users/Administrator/eclipse-workspace/jafafxDemos/bin/control/btn.css
		// ���·��������Դ�ļ���Ҫ�������˭��ClassLoader()����ڱ���Ŀ¼����ʱ�������ΪbinĿ¼�²���
		// ͨ��Thread.currentThread().getContextClassLoader()����ȡClassLoader��ʵ��
		// ͨ��this.getClass().getClassLoader()��ȡClassLoaderʵ��
		// getResource()������ڵ�ǰ����ֽ������ڵ�Ŀ¼
		// getResourceAsStream()��getResource(),���ǻ�ȡ��Դ�ļ�
		// getResourceAsStream()��javaSE����һ�µģ���javaweb�в�һ��
		// ����ڵ�ǰ�ֽ�������·�������ļ�
		// String ret = this.getClass().getResource("btnStyle.css").toExternalForm();
		// ����ڸ�·�� binĿ¼�����ļ�
		String ret = Thread.currentThread().getContextClassLoader().getResource("btnStyle.css").toExternalForm();
		btn.getStylesheets().add(ret);

		// �����¼�,������룬���Ч��
		btn.addEventHandler(MouseEvent.MOUSE_ENTERED, new EventHandler<MouseEvent>() {
			public void handle(MouseEvent event) {
				System.out.println("������룬���Ч��");
				btn.setEffect(drop);
				// ���css class��ʽ
				btn.getStyleClass().add("demo");
				System.out.println(btn.getStylesheets());
			}
		});

		// ����Ƴ��¼�
		btn.addEventHandler(MouseEvent.MOUSE_EXITED, new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				System.out.println("����Ƴ����Ƴ�Ч��");
				// �Ƴ�css����ʽ
				btn.getStyleClass().remove("demo");
				btn.setEffect(null);
			}
		});

		Group root = new Group();
		root.getChildren().add(btn);
		Scene scene = new Scene(root, 300, 300);
		primaryStage.setScene(scene);
		primaryStage.show();

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}

}
