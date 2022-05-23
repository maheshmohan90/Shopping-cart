package com.internetshop.shoppingcart.services;

import com.internetshop.shoppingcart.model.ShoppingCartRequest;
import com.internetshop.shoppingcart.model.ProductDetails;
import com.internetshop.shoppingcart.model.Response;
import com.internetshop.shoppingcart.model.UserCartOrderResponse;

import java.util.List;

public interface CartService {

    Response addProductToCart(ShoppingCartRequest shoppingCartRequest);

    Response removeProductFromCart(ShoppingCartRequest shoppingCartRequest);

    List<ProductDetails> fetchCartDetails(String userId);

    UserCartOrderResponse getUserOrderTotal(ShoppingCartRequest shoppingCartRequest);

}
