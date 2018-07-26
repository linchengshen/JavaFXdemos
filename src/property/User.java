package property;

import javafx.beans.property.ReadOnlyStringProperty;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * UI控件和域模型之间的绑定
在JavaFX中，UI控件和域模型之间的数据绑定很容易。
以下代码显示如何创建登录对话框并绑定用户域对象。
首先，我们定义域对象，它是描述用户名和密码的JavaFX JavaBean。
 * @author yangzaozao
 *
 */
public class User {

	private final ReadOnlyStringWrapper userName;
	private StringProperty password;

	public User() {
		userName = new ReadOnlyStringWrapper(this, "userName", "ABC");
		password = new SimpleStringProperty(this, "password", "");
	}

	public final String getUserName() {
		return userName.get();
	}

	public ReadOnlyStringProperty userNameProperty() {
		return userName.getReadOnlyProperty();
	}

	public final String getPassword() {
		return password.get();
	}

	public StringProperty passwordProperty() {
		return password;
	}
}
