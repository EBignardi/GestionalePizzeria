package manager;

import controller.HomeController;
import controller.ClienteController;
import javafx.stage.Stage;
import controller.PizzaController;
import controller.TitolareController;

public class WindowsManager {
	private static Stage root = new Stage();
	private static HomeController home = new HomeController();
	private static ClienteController cliente = new ClienteController();
	private static TitolareController titolare = new TitolareController();
	private static PizzaController pizza = new PizzaController();
	
	public static void start() throws Exception {
		root.setScene(home.start());
		root.show();
	}
	
	public static void setTitolare() throws Exception {
		root.setScene(titolare.start());
		root.show();
	}
	
	public static void setCliente() throws Exception {
		root.setScene(cliente.start());
		root.show();
	}

	public static void setPizza() throws Exception {
		root.setScene(pizza.start());
		root.show();
	}
}
