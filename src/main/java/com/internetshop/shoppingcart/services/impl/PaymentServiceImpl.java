package com.internetshop.shoppingcart.services.impl;

import com.internetshop.shoppingcart.constants.ShoppingCartConstant;
import com.internetshop.shoppingcart.model.PaymentCardResponse;
import com.internetshop.shoppingcart.model.UserPaymentServiceRequest;
import com.internetshop.shoppingcart.services.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class PaymentServiceImpl implements PaymentService {


    /**
     * This method validate the user card information shard and returns the card type
     * @param userPaymentServiceRequest
     * @return PaymentCardResponse
     */
    @Override
    public PaymentCardResponse validateUserCard(UserPaymentServiceRequest userPaymentServiceRequest) {

        log.info("logType: {}, Event: {}, OrderId:{}, Entering PaymentServiceImpl.validateUserCard >>>>",
                ShoppingCartConstant.AUDIT_LEVEL , ShoppingCartConstant.VALIDATE_ORDER_PAYMENT , userPaymentServiceRequest.getOrderId());
        PaymentCardResponse paymentCardResponse = new PaymentCardResponse();

        //TODO business logic to check the card details shared by user is valid and to determines the card type(Silver, Gold or Normal)

        log.info("logType: {}, Event: {}, OrderId:{}, Exiting PaymentServiceImpl.validateUserCard >>>>",
                ShoppingCartConstant.AUDIT_LEVEL , ShoppingCartConstant.VALIDATE_ORDER_PAYMENT , userPaymentServiceRequest.getOrderId());
        return paymentCardResponse;
    }

    /**
     * This method is to calculate the final order total with discount based on card type
     * @param userPaymentServiceRequest
     * @return paymentCardResponse
     */
    @Override
    public PaymentCardResponse calculateOrderTotal(UserPaymentServiceRequest userPaymentServiceRequest) {
        log.info("logType: {}, Event: {}, OrderID:{}, Entering PaymentServiceImpl.calculateOrderTotal >>>>",
                ShoppingCartConstant.AUDIT_LEVEL , ShoppingCartConstant.CALCULATE_ORDER_TOTAL , userPaymentServiceRequest.getOrderId());
        PaymentCardResponse paymentCardResponse = new PaymentCardResponse();

        //TODO business logic to calculate the discount based on order total fetched from cart for the user and card type after validation

        log.info("logType: {}, Event: {}, OrderID:{}, Exiting PaymentServiceImpl.calculateOrderTotal >>>>",
                ShoppingCartConstant.AUDIT_LEVEL , ShoppingCartConstant.CALCULATE_ORDER_TOTAL , userPaymentServiceRequest.getOrderId());
        return paymentCardResponse;
    }

}
