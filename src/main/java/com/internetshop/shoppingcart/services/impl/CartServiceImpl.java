package com.internetshop.shoppingcart.services.impl;

import com.internetshop.shoppingcart.constants.ShoppingCartConstant;
import com.internetshop.shoppingcart.model.ProductDetails;
import com.internetshop.shoppingcart.model.Response;
import com.internetshop.shoppingcart.model.ShoppingCartRequest;
import com.internetshop.shoppingcart.model.UserCartOrderResponse;
import com.internetshop.shoppingcart.services.CartService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class CartServiceImpl implements CartService {

    /**
     * This method add product to user shopping cart
     * @param shoppingCartRequest
     * @return Response
     */
    @Override
    public Response addProductToCart(ShoppingCartRequest shoppingCartRequest) {
        log.info("logType: {}, Event: {}, ProductId:{}, Entering CartServiceImpl.addProductToCart >>>>",
                ShoppingCartConstant.AUDIT_LEVEL , ShoppingCartConstant.ADD_PRODUCT_CART_ACTIONS , shoppingCartRequest.getReferenceNumber());
        Response productResponse = new Response();
        if (evaluateCart(shoppingCartRequest)) {
            //TODO Business logic to add new product to cart
        }
        log.info("logType: {}, Event: {}, ProductId:{}, Exiting CartServiceImpl.addProductToCart >>>>",
                ShoppingCartConstant.AUDIT_LEVEL , ShoppingCartConstant.ADD_PRODUCT_CART_ACTIONS , shoppingCartRequest.getReferenceNumber());
        return productResponse;
    }

    /**
     * This method remove product from user shopping cart
     * @param shoppingCartRequest
     * @return Response
     */
    @Override
    public Response removeProductFromCart(ShoppingCartRequest shoppingCartRequest) {
        log.info("logType: {}, Event: {}, ProductId:{}, Entering CartServiceImpl.removeProductFromCart >>>>",
                ShoppingCartConstant.AUDIT_LEVEL , ShoppingCartConstant.REMOVE_PRODUCT_CART_ACTIONS , shoppingCartRequest.getReferenceNumber());
        Response productResponse = new Response();
        if (evaluateCart(shoppingCartRequest)) {
            //TODO Business logic to remove product to cart
        }
        log.info("logType: {}, Event: {}, ProductId:{}, Exiting CartServiceImpl.removeProductFromCart >>>>",
                ShoppingCartConstant.AUDIT_LEVEL , ShoppingCartConstant.REMOVE_PRODUCT_CART_ACTIONS , shoppingCartRequest.getReferenceNumber());
        return productResponse;
    }

    /**
     * This method returns the cart details of the user
     * @param userId
     * @return List<ProductDetails>
     */
    @Override
    public List<ProductDetails> fetchCartDetails(String userId) {
        log.info("logType: {}, Event: {}, UserId:{}, Entering CartServiceImpl.getCartDetails >>>>",
                ShoppingCartConstant.AUDIT_LEVEL , ShoppingCartConstant.FETCH_PRODUCT_CART_ACTIONS , userId);
        List<ProductDetails> productDetailsList = new ArrayList<>();

        //TODO Business logic to fetch the cart details of the user from DB

        log.info("logType: {}, Event: {}, UserId:{}, Exiting CartServiceImpl.getCartDetails >>>>",
                ShoppingCartConstant.AUDIT_LEVEL , ShoppingCartConstant.FETCH_PRODUCT_CART_ACTIONS , userId);
        return productDetailsList;
    }

    /**
     * @param shoppingCartRequest
     * @return
     */
    @Override
    public UserCartOrderResponse getUserOrderTotal(ShoppingCartRequest shoppingCartRequest) {
        log.info("logType: {}, Event: {}, ProductId:{}, Entering CartServiceImpl.getUserOrderTotal >>>>",
                ShoppingCartConstant.AUDIT_LEVEL , ShoppingCartConstant.ORDER_PRODUCT_CART_DETAILS , shoppingCartRequest.getReferenceNumber());
        UserCartOrderResponse userCartOrderResponse = new UserCartOrderResponse();

        //TODO calculate the order total of the user cart

        log.info("logType: {}, Event: {}, ProductId:{}, Exiting CartServiceImpl.getUserOrderTotal >>>>",
                ShoppingCartConstant.AUDIT_LEVEL , ShoppingCartConstant.ORDER_PRODUCT_CART_DETAILS , shoppingCartRequest.getReferenceNumber());
        return userCartOrderResponse;
    }


    /**
     * This method will evaluate if the new product can be added or removed from user cart
     * @param shoppingCartRequest
     * @return Boolean
     */
    public Boolean evaluateCart(ShoppingCartRequest shoppingCartRequest) {
        log.info("logType: {}, Event: {}, ProductId:{}, Entering CartServiceImpl.evaluateCart >>>>",
                ShoppingCartConstant.AUDIT_LEVEL , ShoppingCartConstant.EVALUATE_CART_ACTIONS , shoppingCartRequest.getReferenceNumber());
        Boolean cartEvaluate = Boolean.FALSE;

        //TODO business logic to check if the product can be added or removed for the user

        log.info("logType: {}, Event: {}, ProductId:{}, Entering CartServiceImpl.evaluateCart >>>>",
                ShoppingCartConstant.AUDIT_LEVEL , ShoppingCartConstant.EVALUATE_CART_ACTIONS , shoppingCartRequest.getReferenceNumber());
        return cartEvaluate;
    }
}
