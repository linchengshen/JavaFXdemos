package property;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;


/**
 * 
 * @author yangzaozao
 *
 *
 *��ѡ��
JavaFX�ṩ������ѡ��Ա���������GUI�ؼ��е�����֮�����ͬ����

���ǿ�����JavaFX��Properties API��ʹ���������ְ󶨲��ԣ�

Java Bean�ϵ�˫���
��Fluent API�ĸ߼���
ʹ��javafx.beans.binding����󶨶�����еͼ��󶨡�
 */
public class BindingDemo1 {
	public static void main(String[] args) {
		UserBean contact = new UserBean("John", "White");

		StringProperty sp = new SimpleStringProperty();

		sp.set("wojia 666");
		System.out.println(sp.getValue());

		//˫���,��һ������ֵ�仯ʱ��ͬ������һ������ֵ
		//˫��󶨰���ͬ���͵����ԣ���ͬ�������ֵ����ʹ��bindBidirectional()����˫���ʱ
		//��Ҫ�������Զ������ǿɶ�/д�ġ�
		sp.bindBidirectional(contact.firstNameProperty());
		contact.setFirstName("hello world");
		System.out.println(sp.getValue());
		sp.set("my new name");
		System.out.println(contact.getFirstName());
	}
}
