package property;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class UserBean {

	SimpleStringProperty firstName = new SimpleStringProperty();
	SimpleStringProperty lastName = new SimpleStringProperty();

	public UserBean(String firstName, String lastName) {
		this.firstName.set(firstName);
		this.lastName.set(lastName);
	}

	public String getFirstName() {
		return firstName.get();
	}

	public StringProperty firstNameProperty() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName.set(firstName);
	}

	public String getLastName() {
		return lastName.get();
	}

	public StringProperty lastNameProperty() {
		return lastName;
	}

	public void setlastName(String lastName) {
		this.lastName.set(lastName);
	}

}
