package layout;


import java.io.FileInputStream;
import java.io.InputStream;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

/**
 * 
 * @author Administrator
 *
 *
 *         ���������ṩUIԪ�صĿɹ�����ͼ��
 *         ����ʹ�ÿɹ�����壬����Ҫ��ʾ���޵Ŀռ�����ݡ��ɹ��������ӿڣ��佫��ʾ���ݵ�һ���֣������ڱ�Ҫʱ�ṩ��������
 *         
 *         ScrollPane������������
 *         ȱʡ���޲���������
 *         public ScrollPane(Node content)
 *         
 *         ��Ҫ�ķ�����
 *         setContent(Node content)
 *         
 *         setPannable(true) �����Ƿ����������϶�
 *         setPrefSize(double width,double height)
 *         
 *         ��������
 *         ����������

			���ǿ��Կ��ƺ�ʱ��ʾ�������Ĳ��ԣ�
			ö��ֵ
			���� ScrollBarPolicy.ALWAYS
			����ScrollBarPolicy.NEVER
			��ҪʱScrollBarPolicy.AS_NEEDED
			setHbar���Ժ�setVbar���Է����ֱ�Ϊˮƽ�ʹ�ֱ������ָ�����������ԡ�
			sp.setHbarPolicy(ScrollBarPolicy.NEVER);
			sp.setVbarPolicy(ScrollBarPolicy.ALWAYS);
			
			�������������е������С

			��setFitToWidth��setFitToHeight��������Ϊtrue��ƥ���ض�ά�ȡ�

			Ĭ������£�FIT_TO_WIDTH��FIT_TO_HEIGHT���Զ�Ϊfalse���ɵ�����С�����ݱ�����ԭʼ��С��
			
 */
public class ScrollPaneDemo extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		primaryStage.setTitle("ScrollPane����demo");
		Group root = new Group();
		ScrollPane sc = new ScrollPane();
		root.getChildren().add(sc);
		
		InputStream in = new FileInputStream("C:/Users/Administrator/Desktop/images/13.jpg");
		Image img = new Image(in);
		sc.setPrefSize(120, 120);
		sc.setPannable(true);

		sc.setContent(new ImageView(img));

		
		Scene scene = new Scene(root, 400, 400);

		
		
		primaryStage.setScene(scene);
		primaryStage.show();

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}

}
