package property;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;

/**
 * 
 * @author yangzaozao
 *
 *
 *JavaFX���Դ洢�ؼ����ڲ�״̬�����������Ǽ�������JavaFX UI�ؼ���״̬���ġ�JavaFX���Կ��Ա˴˰󶨡�
 *����Ϊ�������Ը���������һ�����Եĸ���ֵ��ͬ����ֵ��

JavaFX���Ե�����
���������͵�JavaFX���ԣ�

��д(Read/Writable)
ֻ��(Read-Only)

 ���ߣ��������� Java����QQȺ��227270512 / Linux QQȺ��479429477
JavaFX���Դ洢�ؼ����ڲ�״̬�����������Ǽ�������JavaFX UI�ؼ���״̬���ġ�JavaFX���Կ��Ա˴˰󶨡�����Ϊ�������Ը���������һ�����Եĸ���ֵ��ͬ����ֵ��

JavaFX���Ե�����
���������͵�JavaFX���ԣ�

��д(Read/Writable)
ֻ��(Read-Only)
JavaFX�����԰���ʵ��ֵ�����ṩ����֧�֣���Ч֧�ֺͰ󶨹��ܡ�����JavaFX�����඼λ��javafx.beans.property.*�������ռ��С�
������б��ǳ��õ������ࡣ

javafx.beans.property.SimpleBooleanProperty
javafx.beans.property.ReadOnlyBooleanWrapper
javafx.beans.property.SimpleintegerProperty
javafx.beans.property.ReadOnlyintegerWrapper
javafx.beans.property.SimpleDoubleProperty
javafx.beans.property.ReadOnlyDoubleWrapper
javafx.beans.property.SimpleStringProperty
javafx.beans.property.ReadOnlyStringWrapper
Simple�������Ƕ�/д�����ࡣӵ��ReadOnly��������ֻ�����ԡ�
 */
public class SimpleStringPropertyDemo  {

public static void main(String[] args) {
	StringProperty password = new SimpleStringProperty("unmodified");
	
	//����password���Ե��޸�ʱ��,һ�����޸�,һ�´���ᱻִ��
	/**
	 * ChangeListener��invalidationListener֮�������
		ʹ��ChangeListener���ɻ�ȡObservable(ObservableValue)�ľ�ֵ����ֵ��
		ʹ��invalidationListenerֻ��ȡObservable����(����)
	 */
	password.addListener(new ChangeListener<String>() {

		@Override
		public void changed(ObservableValue<? extends String> ov, String oldValue, String newValue) {
			// TODO Auto-generated method stub
			System.out.println(oldValue);
			System.out.println(newValue);
		}
	});
	System.out.println(password.get());//unmodified
	System.out.println("########");
	//����ı�������
	password.set("new String");
	System.out.println("111111111");

}
}
