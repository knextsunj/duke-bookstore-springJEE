package jakarta.tutorial.dukesbookstore.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import jakarta.tutorial.dukesbookstore.entity.Book;

public class ShoppingCartDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1102393146193128781L;

	private HashMap<String, ShoppingCartItemDTO> items = null;
	int numberOfItems = 0;

	public ShoppingCartDTO() {
		items = new HashMap<>();
	}

	public synchronized void add(String bookId, BookDTO book) {
		if (items.containsKey(bookId)) {
			ShoppingCartItemDTO scitem = (ShoppingCartItemDTO) items.get(bookId);
			scitem.incrementQuantity();
		} else {
			ShoppingCartItemDTO newItem = new ShoppingCartItemDTO(book);
			items.put(bookId, newItem);
		}
	}

	public synchronized void remove(String bookId) {
		if (items.containsKey(bookId)) {
			ShoppingCartItemDTO scitem = (ShoppingCartItemDTO) items.get(bookId);
			scitem.decrementQuantity();

			if (scitem.getQuantity() <= 0) {
				items.remove(bookId);
			}

			numberOfItems--;
		}
	}

	public synchronized List<ShoppingCartItemDTO> getItems() {
		List<ShoppingCartItemDTO> results = new ArrayList<>();
		results.addAll(this.items.values());

		return results;
	}

	public synchronized int getNumberOfItems() {
		numberOfItems = 0;
		for (ShoppingCartItemDTO item : getItems()) {
			numberOfItems += item.getQuantity();
		}

		return numberOfItems;
	}

	public synchronized double getTotal() {
		double amount = 0.0;
		for (ShoppingCartItemDTO item : getItems()) {
			Book bookDetails = (Book) item.getItem();

			amount += (item.getQuantity() * bookDetails.getPrice());
		}

		return roundOff(amount);
	}

	private double roundOff(double x) {
		long val = Math.round(x * 100); // cents

		return val / 100.0;
	}

	/**
	 * <p>
	 * Buy the items currently in the shopping cart.
	 * </p>
	 * 
	 * @return the navigation page
	 */
	public String buy() {
		// "Cannot happen" sanity check
		if (getNumberOfItems() < 1) {

			return (null);
		} else {
			return ("bookcashier");
		}
	}

	public synchronized void clear() {
		items.clear();
		numberOfItems = 0;
	}

	public void setItemMap(HashMap<String, ShoppingCartItemDTO> items) {
		this.items = items;
	}

	public void setNumberOfItems(int numberOfItems) {
		this.numberOfItems = numberOfItems;
	}

}
