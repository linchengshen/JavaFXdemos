package control;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.stage.Stage;

/**
 * 
 * @author yangzaozao
 *
 *
 *JavaFX API��javafx.scene.control���е�Label���������ʾһ���ı�Ԫ�ء�
     ���԰�װ�ı�Ԫ������Ӧ�ض��ռ䣬���ͼ��ͼ���ʹ��JavaFX Label�ؼ�Ӧ���Ӿ�Ч����
     
   ����Label����,javafxAPIt�ṩ3�й��캯������Label����
   public Label()
   public Label(String text)
   public Label(String text,Node graphic)
   
   
   //An empty label
	Label label1 = new Label();

	//A label with the text element
	Label label2 = new Label("Name");

	//A label with the text element and graphical icon
	Image image = new Image(getClass().getResourceAsStream("labels.jpg"));
	Label label3 = new Label("Name", new ImageView(image));
	
	setGraphic(Node graphic) - ����ͼ��ͼ��
	setGraphicTextGap(double value)���������ı���ͼ��֮��ļ�ࡣ
	setTextFill(Paint value)�������ñ�ǩ�ı�����ɫ
	setTextAlignment(TextAlignment value)�����������䲼�����������ñ�ǩ���ݵĶ��뷽ʽ��TextAlignment��ö��ֵ
	setContentDisplay(ContentDisplay value)��������ͼ��������ı���λ�á�ContentDisplay��ö��ֵ
	�÷�����������ContentDisplay�����е�һ����LFFT��RIGHT��CENTER��TOP��BOTTOM��
	
	
	��װ�ı�
	Ҫ��װ�ı��Խ��ı��ʺϲ���������ʹ��setWrapText()����������Ϊtrueֵ��
	
	Ӧ��Ч��
	���Զ�Label�ؼ�Ӧ���Ӿ�Ч����ת�������´��뽫��ǩ��ת270�ȣ�������λ�ô�ֱƽ�ơ�
	setRotate(double value)��ת
	setTranslateX(double value)ˮƽƽ��,����������,�ƶ���ǩ
	setTranslateY(double value)��ֱƽ��,����������
	ע��,�����������ʵ���ϲ������޸ı�ǩ��setLayoutX()��setLayoutY(),�൱�ڳ�����λ��ƫ�����ֻ�����һ��Ч��
	���Ҫ���ֶ��Ч��,����ͨ����̬����setLayoutX()�Լ�setLayoutY()��ʵ��,��һ��ʾ������
	
	����Ч��,Ĭ����1.0
	setScaleX(double value)
	setScaleY(double value)
   
 */
public class LabelDemo extends Application {

	@Override
	public void start(Stage stage) throws Exception {
		// TODO Auto-generated method stub
		stage.setTitle("Label demo");
		Group root = new Group();

		Label label = new Label("Welcome");
		label.setLayoutX(100);
		label.setLayoutY(100);

		//���ñ�ǩ������ɫ
		label.setTextFill(Color.web("#ea3153", .8));

		//���ñ�ǩ����
		label.setFont(Font.font("arial", FontPosture.ITALIC, 35));
		root.getChildren().add(label);

		//����������¼���Ӧ
		label.setOnMouseClicked(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent Event) {
				// TODO Auto-generated method stub

				//����������¼���ˮƽ,��ֱ����
				double hStep = 5;
				double vStep = 8;
				label.setLayoutX(label.getLayoutX() + hStep);
				label.setLayoutY(label.getLayoutX() + vStep);
				System.out.println(label.getLayoutX());
				System.out.println(label.getLayoutY());
			}

		});

		//��������¼�

		label.setOnMouseEntered(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				label.setScaleX(1.5);
				label.setScaleY(1.5);
				System.out.println("���������");
			}
		});
		
		//����Ƴ��¼�
		label.setOnMouseExited(new EventHandler<MouseEvent>() {
			public void handle(MouseEvent event) {
				label.setScaleX(1);
				label.setScaleY(1);
				System.out.println("����Ƴ���");
			}
		});

		Scene scene = new Scene(root, 600, 350);
		stage.setScene(scene);
		stage.show();

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}

}
