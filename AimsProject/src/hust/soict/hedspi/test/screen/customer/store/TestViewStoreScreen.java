package hust.soict.hedspi.test.screen.customer.store;

import hust.soict.hedspi.aims.cart.Cart;
import hust.soict.hedspi.aims.media.Book;
import hust.soict.hedspi.aims.media.CompactDisc;
import hust.soict.hedspi.aims.media.DigitalVideoDisc;
import hust.soict.hedspi.aims.screen.customer.controller.ViewStoreController;
import hust.soict.hedspi.aims.store.Store;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class TestViewStoreScreen extends Application {
	private static Store store;
	private static Cart cart;
	
	@Override
	public void start(Stage primaryStage) throws Exception{
		final String STORE_FXML_FILE_PATH = "/hust/soict/hedspi/aims/screen/customer/view/Store.fxml";
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(STORE_FXML_FILE_PATH));
		ViewStoreController viewStoreController = new ViewStoreController(cart, store);
		fxmlLoader.setController(viewStoreController);
		Parent root = fxmlLoader.load();
		
		primaryStage.setTitle("Store");
		primaryStage.setScene(new Scene(root));
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		store = new Store();
		cart = new Cart();
		
		store.addMedia(new CompactDisc("Suivre le soleil", "L'amour", 8.5f, 30, "James", "Maire"));
	    store.addMedia(new CompactDisc("Last Christmas", "Xmas", 10f, 100, "John", "Wham"));
	    store.addMedia(new CompactDisc("Under", "Love", 10f, 90, "Hayaa", "Mike"));
	    store.addMedia(new Book("Harry Potter and Philosopher's Stone (2001)", "JK. Rowling", 5f, 50));
	    store.addMedia(new Book("Harry Potter and Chamber of Secrets (2002)", "JK. Rowling", 5f, 60));
	    store.addMedia(new Book("Harry Potter and Prisoner of Azkaban (2004)", "JK. Rowling", 5f, 70));
	    store.addMedia(new Book("Harry Potter and the Goblet of Fire (2006)", "JK. Rowling", 5f, 80));
	    store.addMedia(new DigitalVideoDisc("How You Like That","Love", "BLACKPINK",40, 50f));
	    store.addMedia(new DigitalVideoDisc("Gone", "Love", "Teddy", 20, 30f));

		
		launch(args);
	}

}
