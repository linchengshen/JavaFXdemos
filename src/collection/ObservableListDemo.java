package collection;

import java.util.ArrayList;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;

public class ObservableListDemo {
	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();

		ObservableList<String> observableList = FXCollections.observableArrayList(list);

		observableList.addListener(new ListChangeListener<String>() {

			@Override
			public void onChanged(Change<? extends String> arg0) {
				// TODO Auto-generated method stub
				System.out.println("ÓÐÐÞ¸Ä²Ù×÷");
			}

		});
		observableList.add("linchengshen");
		observableList.add("linchengshen");
		observableList.add("linchengshen");
	}
}
