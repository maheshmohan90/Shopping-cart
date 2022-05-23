package com.internetshop.shoppingcart.controllers;


import com.internetshop.shoppingcart.constants.ShoppingCartConstant;
import com.internetshop.shoppingcart.model.ProductDetails;
import com.internetshop.shoppingcart.model.ShoppingCartRequest;
import com.internetshop.shoppingcart.model.Response;
import com.internetshop.shoppingcart.model.UserCartOrderResponse;
import com.internetshop.shoppingcart.services.CartService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/cart")
@Slf4j
public class CartController {

    @Autowired
    CartService cartService;

    @PostMapping(value = "/v1/addProduct")
    public ResponseEntity<Response> addProductToCart(@RequestBody ShoppingCartRequest shoppingCartRequest) {
        log.info("logType: {}, Event: {}, ProductID:{}, Entering CartController.addProductToCart >>>>",
                ShoppingCartConstant.AUDIT_LEVEL , ShoppingCartConstant.ADD_PRODUCT_CART_ACTIONS , shoppingCartRequest.getReferenceNumber());
        ResponseEntity<Response> body = null;
        try {
            Response response = cartService.addProductToCart(shoppingCartRequest);
            if (null != response) {
                body = ResponseEntity.status(HttpStatus.OK).body(response);
            }
        } catch (Exception ex) { //catch specific exception which can be thrown in the implementation layer
        }
        log.info("logType: {}, Event: {}, ProductID:{}, Exiting CartController.addProductToCart >>>>",
                ShoppingCartConstant.AUDIT_LEVEL , ShoppingCartConstant.ADD_PRODUCT_CART_ACTIONS , shoppingCartRequest.getReferenceNumber());
        return body;
    }

    @PostMapping(value = "/v1/removeProduct")
    public ResponseEntity<Response> removeProductFromCart(@RequestBody ShoppingCartRequest shoppingCartRequest) {
        log.info("logType: {}, Event: {}, ProductID:{}, Entering CartController.removeProductFromCart >>>>",
                ShoppingCartConstant.AUDIT_LEVEL , ShoppingCartConstant.REMOVE_PRODUCT_CART_ACTIONS , shoppingCartRequest.getReferenceNumber());
        ResponseEntity<Response> body = null;
        try {
            Response response = cartService.removeProductFromCart(shoppingCartRequest);
            if (null != response) {
                body = ResponseEntity.status(HttpStatus.OK).body(response);
            }
        } catch (Exception ex) { //catch specific exception which can be thrown in the implementation layer
        }
        log.info("logType: {}, Event: {}, ProProductIDductId:{}, Exiting CartController.removeProductFromCart >>>>",
                ShoppingCartConstant.AUDIT_LEVEL , ShoppingCartConstant.REMOVE_PRODUCT_CART_ACTIONS , shoppingCartRequest.getReferenceNumber());
        return body;
    }

    @PostMapping(value = "/v1/fetchCartDetails")
    public ResponseEntity<List<ProductDetails>> getUserCartDetails(@RequestBody ShoppingCartRequest shoppingCartRequest) {
        log.info("logType: {}, Event: {}, ProductID:{}, Entering CartController.removeProductFromCart >>>>",
                ShoppingCartConstant.AUDIT_LEVEL , ShoppingCartConstant.REMOVE_PRODUCT_CART_ACTIONS , shoppingCartRequest.getReferenceNumber());
        ResponseEntity<List<ProductDetails>> body = null;
        try {
            List<ProductDetails> productDetailsList = cartService.fetchCartDetails(shoppingCartRequest.getUserId());
            if (null != productDetailsList) {
                body = ResponseEntity.status(HttpStatus.OK).body(productDetailsList);
            }
        } catch (Exception ex) { //catch specific exception which can be thrown in the implementation layer
        }
        log.info("logType: {}, Event: {}, ProProductIDductId:{}, Exiting CartController.removeProductFromCart >>>>",
                ShoppingCartConstant.AUDIT_LEVEL , ShoppingCartConstant.REMOVE_PRODUCT_CART_ACTIONS , shoppingCartRequest.getReferenceNumber());
        return body;
    }

    @PostMapping(value = "/v1/userOrderDetails")
    public ResponseEntity<UserCartOrderResponse> getUserOrderTotal(@RequestBody ShoppingCartRequest shoppingCartRequest) {
        log.info("logType: {}, Event: {}, Entering CartController.getUserOrderTotal >>>>",
                ShoppingCartConstant.AUDIT_LEVEL , ShoppingCartConstant.ORDER_PRODUCT_CART_DETAILS);
        ResponseEntity<UserCartOrderResponse> body = null;
        try {
            UserCartOrderResponse orderCartDetails = cartService.getUserOrderTotal(shoppingCartRequest);
            if (null != orderCartDetails) {
                body = ResponseEntity.status(HttpStatus.OK).body(orderCartDetails);
            }
        } catch (Exception ex) { //catch specific exception which can be thrown in the implementation layer
        }
        log.info("logType: {}, Event: {}, ProductID:{}, Exiting CartController.getUserOrderTotal >>>>",
                ShoppingCartConstant.AUDIT_LEVEL , ShoppingCartConstant.ORDER_PRODUCT_CART_DETAILS , shoppingCartRequest.getReferenceNumber());
        return body;
    }

}
