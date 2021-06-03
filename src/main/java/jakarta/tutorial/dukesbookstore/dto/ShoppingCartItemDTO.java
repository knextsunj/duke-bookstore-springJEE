package jakarta.tutorial.dukesbookstore.dto;

import java.io.Serializable;

public class ShoppingCartItemDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6313220272752606327L;

	private Object item;
	private int quantity;

	public ShoppingCartItemDTO() {

	}

	public ShoppingCartItemDTO(Object anItem) {
		item = anItem;
		quantity = 1;
	}

	public void incrementQuantity() {
		quantity++;
	}

	public void decrementQuantity() {
		quantity--;
	}

	public Object getItem() {
		return item;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public void setItem(Object item) {
		this.item = item;
	}

}
