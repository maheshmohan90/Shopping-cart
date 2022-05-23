package com.internetshop.shoppingcart.services;

import com.internetshop.shoppingcart.model.PaymentCardResponse;
import com.internetshop.shoppingcart.model.UserPaymentServiceRequest;

public interface PaymentService {

    PaymentCardResponse validateUserCard(UserPaymentServiceRequest userPaymentServiceRequest);

    PaymentCardResponse calculateOrderTotal(UserPaymentServiceRequest userPaymentServiceRequest);

}
