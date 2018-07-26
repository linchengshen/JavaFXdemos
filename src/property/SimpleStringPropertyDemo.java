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
 *JavaFX属性存储控件的内部状态，并允许我们监听来自JavaFX UI控件的状态更改。JavaFX属性可以彼此绑定。
 *绑定行为允许属性根据来自另一个属性的更改值来同步其值。

JavaFX属性的类型
有两种类型的JavaFX属性：

读写(Read/Writable)
只读(Read-Only)

 作者：初生不惑 Java技术QQ群：227270512 / Linux QQ群：479429477
JavaFX属性存储控件的内部状态，并允许我们监听来自JavaFX UI控件的状态更改。JavaFX属性可以彼此绑定。绑定行为允许属性根据来自另一个属性的更改值来同步其值。

JavaFX属性的类型
有两种类型的JavaFX属性：

读写(Read/Writable)
只读(Read-Only)
JavaFX的属性包含实际值，并提供更改支持，无效支持和绑定功能。所有JavaFX属性类都位于javafx.beans.property.*包命名空间中。
下面的列表是常用的属性类。

javafx.beans.property.SimpleBooleanProperty
javafx.beans.property.ReadOnlyBooleanWrapper
javafx.beans.property.SimpleintegerProperty
javafx.beans.property.ReadOnlyintegerWrapper
javafx.beans.property.SimpleDoubleProperty
javafx.beans.property.ReadOnlyDoubleWrapper
javafx.beans.property.SimpleStringProperty
javafx.beans.property.ReadOnlyStringWrapper
Simple的属性是读/写属性类。拥有ReadOnly的属性是只读属性。
 */
public class SimpleStringPropertyDemo  {

public static void main(String[] args) {
	StringProperty password = new SimpleStringProperty("unmodified");
	
	//监听password属性的修改时间,一旦被修改,一下代码会被执行
	/**
	 * ChangeListener和invalidationListener之间的区别。
		使用ChangeListener将可获取Observable(ObservableValue)的旧值和新值。
		使用invalidationListener只获取Observable对象(属性)
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
	//这里改变了属性
	password.set("new String");
	System.out.println("111111111");

}
}
