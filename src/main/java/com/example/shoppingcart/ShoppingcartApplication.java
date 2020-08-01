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

		Category shoes = new Category("shoes");
		Category food = new Category("food");
		Category drink = new Category("drink", food);

		Product nike = new Product("nike air max", 1000, shoes);
		Product adidas = new Product("adidas stan smith", 500, shoes);
		Product sprite = new Product("sprite", 10, drink);
		Product fanta = new Product("fanta", 15, drink);
		Product icecream = new Product("ice cream", 20, food);

		Entry entryNike = new Entry(2, nike);
		Entry entryAdidas = new Entry(1, adidas);
		Entry entrySprite = new Entry(10, sprite);
		Entry entryFanta = new Entry(5, fanta);
		Entry entryIcecream = new Entry(8, icecream);

		List<Entry> entryList = new ArrayList<>();
		entryList.add(entryNike);
		entryList.add(entryAdidas);
		entryList.add(entrySprite);
		entryList.add(entryFanta);
		entryList.add(entryIcecream);

		Campaign campaignDrinkRate = new Campaign(drink, 10, 10, DiscountType.Rate);
		Campaign campaignDrinkAmount = new Campaign(drink, 50, 12, DiscountType.Amount);
		Campaign campaignShoes = new Campaign(shoes, 5, 2, DiscountType.Rate);

		List<Campaign> campaignList = new ArrayList<>();
		campaignList.add(campaignDrinkRate);
		campaignList.add(campaignDrinkAmount);
		campaignList.add(campaignShoes);

		Coupon coupon = new Coupon(1000, 250, DiscountType.Amount);

		Cart cart = new Cart(entryList, campaignList, coupon);

		CartManager.getInstance().setCart(cart);

		ICartService cartService = ApplicationContextHolder.getContext().getBean(CartService.class);

		cartService.loadCart();

		System.out.println(cartService.printCart());
	}

}
