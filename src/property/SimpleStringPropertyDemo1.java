package property;

import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * 
 * @author yangzaozao
 *
 *
 */
public class SimpleStringPropertyDemo1 {

	public static void main(String[] args) {
		StringProperty password = new SimpleStringProperty("unmodified");
		password.addListener(new InvalidationListener() {
			@Override
			public void invalidated(Observable observable) {
				StringProperty obn = (SimpleStringProperty)observable;
				System.out.println(obn.getValue());

			}
		});
		
		password.set("new String");
	}
}
