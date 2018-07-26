package property;

import javafx.beans.property.ReadOnlyStringProperty;
import javafx.beans.property.ReadOnlyStringWrapper;

/**
 * 
 * @author yangzaozao
 *
 *只读属性
要创建只读属性，请使用以ReadOnly作为前缀的包装类。创建只读属性需要两个步骤。
实例化只读包装类
调用方法getReadOnlyProperty()返回一个真正的只读属性对象
 */
public class ReadOnlyStringPropertyDemo {

	public static void main(String[] args) {
		ReadOnlyStringWrapper userName = new ReadOnlyStringWrapper("linchengshen");
		ReadOnlyStringProperty readOnlyUserName = userName.getReadOnlyProperty();
		System.out.println(readOnlyUserName.get());
	}
}
