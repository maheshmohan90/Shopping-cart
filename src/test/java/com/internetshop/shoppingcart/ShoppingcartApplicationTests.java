package com.internetshop.shoppingcart;

import com.internetshop.shoppingcart.controllers.CartController;
import com.internetshop.shoppingcart.controllers.UserPaymentController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class ShoppingcartApplicationTests {

	@Autowired
	private CartController controller;

	@Autowired
	private UserPaymentController userPaymentController;

	@Test
	public void contextLoads() throws Exception {
		assertThat(controller).isNotNull();
		assertThat(userPaymentController).isNotNull();
	}

}
