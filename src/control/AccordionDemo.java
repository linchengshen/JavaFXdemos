package control;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Accordion;
import javafx.scene.control.Button;
import javafx.scene.control.TitledPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 * 
 * @author Administrator
 *
 *
 *         Accordion 是手风琴的意思 public class Accordion extends Control An accordion
 *         is a group of TitlePanes. Only one TitledPane can be opened at a
 *         time.
 * 
 *         The TitledPane content in an accordion can be any Node such as UI
 *         controls or groups of nodes added to a layout container.
 * 
 *         It is not recommended to set the MinHeight, PrefHeight, or MaxHeight
 *         for this control. Unexpected behavior will occur because the
 *         Accordion's height changes when a TitledPane is opened or closed.
 * 
 *         Accordion sets focusTraversable to false. Accordion has two
 *         constructors public Accordion(); public Accordion(TitledPane...
 *         args);
 */
public class AccordionDemo extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		primaryStage.setTitle("Accordion demo");
		Group root = new Group();

		// instance of Accordion
		Accordion accordion = new Accordion();
		TitledPane t1 = new TitledPane("html", new Button("button1"));
		TitledPane t2 = new TitledPane("css", new Button("button2"));
		TitledPane t3 = new TitledPane("js", new Button("button3"));
		TitledPane t4 = new TitledPane("java", new Button("button4"));

		accordion.getPanes().addAll(t1, t2, t3, t4);
		/*
		 * 把某个TitledPane展开 accordion.setExpandedPane(t1);
		 */

		accordion.expandedPaneProperty().addListener(new ChangeListener<TitledPane>() {

			@Override
			public void changed(ObservableValue<? extends TitledPane> observable, TitledPane oldValue,
					TitledPane newValue) {
				// TODO Auto-generated method stub
				if (oldValue != null) {
					oldValue.setTextFill(Color.web("#000000"));
				}
				if (newValue != null) {
					newValue.setTextFill(Color.web("#ff0000"));
				}
			}

		});

		root.getChildren().add(accordion);

		Scene scene = new Scene(root, 600, 450);
		primaryStage.setScene(scene);
		primaryStage.show();

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}

}
