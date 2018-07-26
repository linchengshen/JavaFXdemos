package property;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;


/**
 * 
 * @author yangzaozao
 *
 *
 *绑定选项
JavaFX提供了许多绑定选项，以便在域对象和GUI控件中的属性之间进行同步。

我们可以在JavaFX的Properties API中使用以下三种绑定策略：

Java Bean上的双向绑定
与Fluent API的高级绑定
使用javafx.beans.binding定义绑定对象进行低级绑定。
 */
public class BindingDemo1 {
	public static void main(String[] args) {
		UserBean contact = new UserBean("John", "White");

		StringProperty sp = new SimpleStringProperty();

		sp.set("wojia 666");
		System.out.println(sp.getValue());

		//双向绑定,当一个属性值变化时会同步至另一个属性值
		//双向绑定绑定相同类型的属性，并同步两侧的值。当使用bindBidirectional()方法双向绑定时
		//需要两个属性都必须是可读/写的。
		sp.bindBidirectional(contact.firstNameProperty());
		contact.setFirstName("hello world");
		System.out.println(sp.getValue());
		sp.set("my new name");
		System.out.println(contact.getFirstName());
	}
}
