package layout;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * 
 * @author Administrator
 *
 *
 *         BorderPane���ֶ������ײ������һ����������е��ӽڵ㡣ÿ������ֻ����һ���ڵ㡣
 *         BorderPane�Ķ����͵ײ���������ɵ�����С�Ľڵ�ռ�����п��ÿ�ȡ� ��߽�������ұ߽�����ռ�ݶ����͵ײ��߽�֮��Ŀ��ô�ֱ�ռ䡣
 * 
 *         Ĭ������£����б߽����������ӽڵ����ѡ��Ⱥ͸߶ȡ������ڶ������ײ�����࣬�Ҳ�����������еĽڵ��Ĭ�϶��뷽ʽ���£�
 * 
 *         ����: Pos.TOP_LEFT �ײ�: Pos.BOTTOM_LEFT ���: Pos.TOP_LEFT �Ҳ�:
 *         Pos.TOP_RIGHT ����: Pos.CENTER
 * 
 *         BorderPane������������
 * 
 *         public BorderPane()
 * 
 *         //���Ľڵ� public BorderPane(Node center)
 * 
 *         public BorderPane(Node center,Node top,Node right,Node bottom,Node left) 
 *         setAlignment(Pos value)������������ýڵ��ı��Ķ��뷽ʽ���������ǽڵ㱾��
 */
public class BorderPaneDemo extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		primaryStage.setTitle("BorderPane����demo");

		BorderPane bp = new BorderPane();
		bp.setPadding(new Insets(10));
		primaryStage.setScene(new Scene(bp, 300, 200));

		bp.setCenter(new Button("button center"));
		bp.setTop(new Button("button top"));
		bp.setRight(new Button("button right"));
		bp.setBottom(new Button("button bottom"));
		bp.setLeft(new Button("button left"));
		Button btn = (Button) bp.getChildren().get(1);
		btn.setAlignment(Pos.TOP_CENTER);

		// ���԰�
		btn.prefWidthProperty().bind(primaryStage.getScene().widthProperty());
		primaryStage.show();

	}

	public static void main(String[] args) {
		launch(args);
	}
}
