package control;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.DateCell;
import javafx.scene.control.DatePicker;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Callback;
import javafx.util.StringConverter;

/**
 * 
 * @author Administrator
 * 
 * 
 *         ���������������� public DatePicker()
 *         ��ָ�����ڵĹ�����,LocalDate��java1.8������API��LocalDate��û�й����Ĺ����� �����ṩ��public
 *         static LocalDate of(int year, Month month, int dayOfMonth)
 * 
 *         month ��1-12 public static LocalDate of(int year, int month, int
 *         dayOfMonth) public DatePicker(LocalDate localDate)
 *
 */
public class DatePickerDemo extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		primaryStage.setTitle("DatePicker demo");

		VBox vbox = new VBox(10);
		DatePicker datePicker = new DatePicker(LocalDate.of(2018, 1, 25));
		// �Ƿ���ʾ������Ĭ��Ϊfalse
		datePicker.setShowWeekNumbers(false);
		// setConverter()�Զ�����ʾ��ʽ
		StringConverter<LocalDate> converter = new StringConverter<LocalDate>() {
			// java1.8 ����LocalDate��DateTimeFormater��API
			private String pattern = "yyyy-MM-dd";
			private DateTimeFormatter dtf = DateTimeFormatter.ofPattern(pattern);

			// LocalDate ����ת�ַ���
			@Override
			public String toString(LocalDate localDate) {
				// TODO Auto-generated method stub
				return localDate != null ? dtf.format(localDate) : "";
			}

			// ����ת�ַ��� תΪLocalDate����
			@Override
			public LocalDate fromString(String string) {
				// TODO Auto-generated method stub
				boolean flag = string == null || "".equals(string);
				if (!flag) {
					return LocalDate.parse(string, dtf);
				} else {
					return null;
				}
			}
		};

		// ��δ��뿴����
		final Callback<DatePicker, DateCell> dayCellFactory = new Callback<DatePicker, DateCell>() {
			@Override
			public DateCell call(final DatePicker datePicker) {
				return new DateCell() {
					@Override
					public void updateItem(LocalDate item, boolean empty) {
						super.updateItem(item, empty);
						System.out.println(datePicker.getValue().toString());
					}
				};
			}
		};

		datePicker.setDayCellFactory(dayCellFactory);
		datePicker.setConverter(converter);
		vbox.getChildren().add(datePicker);
		Scene scene = new Scene(vbox, 400, 350);
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}

}
