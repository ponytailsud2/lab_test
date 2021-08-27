package main;

import gui.ControlPane;
import gui.FieldPane;
import gui.SimulationManager;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class Main extends Application {

	@Override
	public void start(Stage primaryStage) {

		// visual
		HBox root = new HBox();
		root.setPadding(new Insets(10));
		root.setSpacing(10);
		root.setPrefHeight(400);

		ControlPane controlPane = new ControlPane();
		FieldPane fieldPane = new FieldPane();
		root.getChildren().addAll(controlPane, fieldPane);

		Scene scene = new Scene(root);
		primaryStage.setTitle("Harvest Simulator");
		primaryStage.setScene(scene);
		primaryStage.sizeToScene();
		primaryStage.setResizable(false);
		primaryStage.show();

		// logical
		SimulationManager.setControlPane(controlPane);
		SimulationManager.setFieldPane(fieldPane);

	}

	public static void main(String[] args) {
		launch(args);
	}

}
