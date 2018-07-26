package property;

import javafx.beans.property.ReadOnlyStringProperty;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * UI�ؼ�����ģ��֮��İ�
��JavaFX�У�UI�ؼ�����ģ��֮������ݰ󶨺����ס�
���´�����ʾ��δ�����¼�Ի��򲢰��û������
���ȣ����Ƕ�����������������û����������JavaFX JavaBean��
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
