package main;

import javafx.application.Application;
import javafx.stage.Stage;
import manager.WindowsManager;

public class Main extends Application {
	@Override
	public void start(Stage stageHome) throws Exception {
		WindowsManager.start(); 
	}

	public static void main(String[] args) {
		launch(args);
	}
}