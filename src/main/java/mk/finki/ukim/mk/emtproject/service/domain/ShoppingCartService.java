package mk.finki.ukim.mk.emtproject.service.domain;

import mk.finki.ukim.mk.emtproject.model.domain.Product;
import mk.finki.ukim.mk.emtproject.model.domain.ShoppingCart;

import java.util.List;
import java.util.Optional;

public interface ShoppingCartService {

    List<Product> listAllProductsInShoppingCart(Long cartId);

    Optional<ShoppingCart> getActiveShoppingCart(String username);

    Optional<ShoppingCart> addProductToShoppingCart(String username, Long productId);
}

