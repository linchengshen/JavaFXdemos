package property;

import javafx.beans.binding.DoubleBinding;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;

public class LowLevelBindingDemo {
	/**
	 * 
	 * �ͼ����
	����NumberBinding��������໯ʱ��ʹ�õͼ���󶨣�����Double���͵�DoubleBinding�ࡣ
	
	��DoubleBinding��������У����Ǹ�������computeValue()�������Ա����ʹ�������(����*�� - )���ƶ����ӵ���ѧ���̼��㡣
	�߼���ʹ����multiply()��subtract()�ȷ��������ͼ���ʹ������*�� - ���������
	
	���´�����ʾ���Ϊ��ʽ�����ͼ���󶨣���������ε������
	 */
	public static void main(String[] args) {
		DoubleProperty width = new SimpleDoubleProperty(2.0);
		DoubleProperty height = new SimpleDoubleProperty(4.0);
		DoubleBinding area = new DoubleBinding() {
			//ʹ�ó�ʼ�������,��ʼ�������ڲ���
			{
				//super.bind(width, height);// initial bind
				this.bind(width, height);
			}

			@Override
			protected double computeValue() {
				// TODO Auto-generated method stub
				return width.get() * height.get();
			}

		};

		System.out.println(area.get());
	}
}
