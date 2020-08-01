package com.example.shoppingcart;

import com.example.shoppingcart.models.*;
import com.example.shoppingcart.modules.ApplicationContextHolder;
import com.example.shoppingcart.modules.CartManager;
import com.example.shoppingcart.services.cart.CartService;
import com.example.shoppingcart.services.cart.ICartService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;


@SpringBootApplication
public class ShoppingcartApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShoppingcartApplication.class, args);

		Category fruit = new Category("Fruit");
		Category cars = new Category("Cars");
		Category BMW = new Category("BMW", cars);

		Product apple = new Product("Apple", 10, fruit);
		Product orange = new Product("Orange", 20, fruit);
		Product e180 = new Product("E180", 2000, BMW);

		Entry entryApple = new Entry(10, apple);
		Entry entryOrange = new Entry(20, orange);
		Entry entryE180 = new Entry(1, e180);

		List<Entry> entryList = new ArrayList<>();
		entryList.add(entryApple);
		entryList.add(entryOrange);
		entryList.add(entryE180);

		Campaign campaignfruit1 = new Campaign(fruit, 10, 10, DiscountType.Rate);
		Campaign campaignfruit2 = new Campaign(fruit, 10, 29, DiscountType.Amount);
		Campaign campaignBMW = new Campaign(BMW, 2, 40, DiscountType.Rate);

		List<Campaign> campaignList = new ArrayList<>();
		campaignList.add(campaignfruit1);
		campaignList.add(campaignfruit2);
		campaignList.add(campaignBMW);

		Coupon coupon = new Coupon(150, 25, DiscountType.Amount);

		Cart cart = new Cart(entryList, campaignList, coupon);

		CartManager.getInstance().setCart(cart);

		ICartService cartService = ApplicationContextHolder.getContext().getBean(CartService.class);

		cartService.loadCart();

		System.out.println(cartService.printCart());
	}

}
