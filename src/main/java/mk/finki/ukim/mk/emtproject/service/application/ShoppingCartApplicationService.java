package mk.finki.ukim.mk.emtproject.service.application;

import mk.finki.ukim.mk.emtproject.dto.DisplayProductDto;
import mk.finki.ukim.mk.emtproject.dto.ShoppingCartDto;

import java.util.List;
import java.util.Optional;

public interface ShoppingCartApplicationService {

    List<DisplayProductDto> listAllProductsInShoppingCart(Long cartId);

    Optional<ShoppingCartDto> getActiveShoppingCart(String username);

    Optional<ShoppingCartDto> addProductToShoppingCart(String username, Long productId);
}

