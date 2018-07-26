package property;

import javafx.beans.binding.NumberBinding;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

/**
 * 
 * @author yangzaozao
 *
 *
 *�߼�������԰�
 */
public class HighLevelBindingDemo {

	/**
	 * 
	 * �߼����
	����Ҳ����ʹ��JavaFX������API�������ԡ�APIʹ������Ӣ��ķ������ƶ�����ִ�в����� 
	���磬multiply()��divide()��subtract()��isEqualTo()��isNotEqualTo()��concat()��
	 ��ע�⣬����������û��get��set��������API��һ��ʱ����д���룬����������дӢ�ľ��ӣ�
	 ���磬width().multiply(height()).divide(2)��
	
	���´�����ʾ��δ�����ʾ�����������Ĺ�ʽ�����ԡ�
	
	��ͨ��ʹ��javafx.beans.binding.IntegerExpression�ӿ��е�fluent API��ִ�и߼��󶨡�
	
	�ô���ʹ��multiply()�������÷������ذ�������ֵ - NumberBinding��
	
	��������ӳ�������ֵ�ģ�����ζ�ų˷�����ִ�м��㣬����ͨ��get()��getValue()�����������Ե�ֵ��
	 */
	public static void main(String[] args) {

		//Area = width * height;
		IntegerProperty width = new SimpleIntegerProperty(10);
		IntegerProperty height = new SimpleIntegerProperty(20);
		NumberBinding area = width.multiply(height);
		System.out.println(area.getValue());
	}
}
