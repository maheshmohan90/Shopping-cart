package com.internetshop.shoppingcart.controllers;


import com.internetshop.shoppingcart.constants.ShoppingCartConstant;
import com.internetshop.shoppingcart.model.PaymentCardResponse;
import com.internetshop.shoppingcart.model.Response;
import com.internetshop.shoppingcart.model.ShoppingCartRequest;
import com.internetshop.shoppingcart.model.UserPaymentServiceRequest;
import com.internetshop.shoppingcart.services.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/payment")
@Slf4j
public class UserPaymentController {

    @Autowired
    PaymentService paymentService;

    @PostMapping(value = "/v1/validateCard")
    public ResponseEntity<PaymentCardResponse> validateCard(@RequestBody UserPaymentServiceRequest userPaymentServiceRequest) {
        log.info("logType: {}, Event: {}, OrderID:{}, Entering UserPaymentController.validateCard >>>>",
                ShoppingCartConstant.AUDIT_LEVEL , ShoppingCartConstant.VALIDATE_ORDER_PAYMENT , userPaymentServiceRequest.getOrderId());
        ResponseEntity<PaymentCardResponse> body = null;
        try {
            PaymentCardResponse response = paymentService.validateUserCard(userPaymentServiceRequest);
            if (null != response) {
                body = ResponseEntity.status(HttpStatus.OK).body(response);
            }
        } catch (Exception ex) { //catch specific exception which can be thrown in the implementation layer
        }
        log.info("logType: {}, Event: {}, ProductID:{}, Exiting UserPaymentController.validateCard >>>>",
                ShoppingCartConstant.AUDIT_LEVEL , ShoppingCartConstant.VALIDATE_ORDER_PAYMENT , userPaymentServiceRequest.getOrderId());
        return body;
    }

    @PostMapping(value = "/v1/calculateOrderTotal")
    public ResponseEntity<PaymentCardResponse> calculateOrderTotal(@RequestBody UserPaymentServiceRequest userPaymentServiceRequest) {
        log.info("logType: {}, Event: {}, OrderID:{}, Entering UserPaymentController.calculateOrderTotal >>>>",
                ShoppingCartConstant.AUDIT_LEVEL , ShoppingCartConstant.CALCULATE_ORDER_TOTAL , userPaymentServiceRequest.getOrderId());
        ResponseEntity<PaymentCardResponse> body = null;
        try {
            PaymentCardResponse response = paymentService.calculateOrderTotal(userPaymentServiceRequest);
            if (null != response) {
                body = ResponseEntity.status(HttpStatus.OK).body(response);
            }
        } catch (Exception ex) { //catch specific exception which can be thrown in the implementation layer
        }
        log.info("logType: {}, Event: {}, ProductID:{}, Exiting UserPaymentController.calculateOrderTotal >>>>",
                ShoppingCartConstant.AUDIT_LEVEL , ShoppingCartConstant.CALCULATE_ORDER_TOTAL , userPaymentServiceRequest.getOrderId());
        return body;
    }

}
