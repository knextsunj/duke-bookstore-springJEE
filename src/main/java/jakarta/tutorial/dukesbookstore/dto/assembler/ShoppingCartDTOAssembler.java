package jakarta.tutorial.dukesbookstore.dto.assembler;

import java.util.HashMap;

import jakarta.tutorial.dukesbookstore.dto.ShoppingCartDTO;
import jakarta.tutorial.dukesbookstore.dto.ShoppingCartItemDTO;
import jakarta.tutorial.dukesbookstore.web.managedbeans.ShoppingCart;
import jakarta.tutorial.dukesbookstore.web.managedbeans.ShoppingCartItem;

public class ShoppingCartDTOAssembler {

	public ShoppingCartDTO buildShoppingCartDTO(ShoppingCart shoppingCart) {

		ShoppingCartDTO shoppingCartDTO = new ShoppingCartDTO();

		HashMap<String, ShoppingCartItemDTO> itemMap = new HashMap<>();

		shoppingCart.retrieveItemMap().keySet().forEach(key -> {
			ShoppingCartItem shoppingCartItem = shoppingCart.retrieveItemMap().get(key);
			ShoppingCartItemDTO shoppingCartItemDTO = new ShoppingCartItemDTO();
			shoppingCartItemDTO.setQuantity(shoppingCartItem.getQuantity());
			shoppingCartItemDTO.setItem(shoppingCartItem.getItem());

			itemMap.put(key, shoppingCartItemDTO);
		});

		shoppingCartDTO.setNumberOfItems(shoppingCart.getNumberOfItems());
		shoppingCartDTO.setItemMap(itemMap);

		return shoppingCartDTO;
	}

}
