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
 *         有两个公共构造器 public DatePicker()
 *         带指定日期的构造器,LocalDate是java1.8新增的API，LocalDate并没有公共的构造器 所以提供了public
 *         static LocalDate of(int year, Month month, int dayOfMonth)
 * 
 *         month 从1-12 public static LocalDate of(int year, int month, int
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
		// 是否显示周数，默认为false
		datePicker.setShowWeekNumbers(false);
		// setConverter()自定义显示格式
		StringConverter<LocalDate> converter = new StringConverter<LocalDate>() {
			// java1.8 新增LocalDate和DateTimeFormater的API
			private String pattern = "yyyy-MM-dd";
			private DateTimeFormatter dtf = DateTimeFormatter.ofPattern(pattern);

			// LocalDate 对象转字符串
			@Override
			public String toString(LocalDate localDate) {
				// TODO Auto-generated method stub
				return localDate != null ? dtf.format(localDate) : "";
			}

			// 对象转字符串 转为LocalDate对象
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

		// 这段代码看不懂
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
