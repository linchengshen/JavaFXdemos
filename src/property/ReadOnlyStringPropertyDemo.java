package property;

import javafx.beans.property.ReadOnlyStringProperty;
import javafx.beans.property.ReadOnlyStringWrapper;

/**
 * 
 * @author yangzaozao
 *
 *ֻ������
Ҫ����ֻ�����ԣ���ʹ����ReadOnly��Ϊǰ׺�İ�װ�ࡣ����ֻ��������Ҫ�������衣
ʵ����ֻ����װ��
���÷���getReadOnlyProperty()����һ��������ֻ�����Զ���
 */
public class ReadOnlyStringPropertyDemo {

	public static void main(String[] args) {
		ReadOnlyStringWrapper userName = new ReadOnlyStringWrapper("linchengshen");
		ReadOnlyStringProperty readOnlyUserName = userName.getReadOnlyProperty();
		System.out.println(readOnlyUserName.get());
	}
}
