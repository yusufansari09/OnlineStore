package com.TestVagrant.onlineStore;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import java.util.ArrayList;
import java.util.List;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class StoreTests {

	private int customerCounter;
	private Customer customer;

	@BeforeTest
	public void initialiseCustomerCounter() {
		customerCounter = 0;
	}

	@Test
	public void testScenario1() {
		Item item1 = new Item(ItemName.Mobile, 2, 5);
		Item item2 = new Item(ItemName.Shoe, 1, 3);
		Item item3 = new Item(ItemName.Watch, 5, 10);

		List<Item> items = new ArrayList<Item>();
		items.add(item1);
		items.add(item2);
		items.add(item3);

		Cart cart = new Cart(items);

		customer = new Customer("Yusuf", cart);
		if (customer.getCart().isPromoApplied())
			customerCounter++;
		Assert.assertEquals(customer.getCart().getFinalCartValue(), 63.0,"Cart value not equal");
		Assert.assertEquals(customer.getCart().getItems().get(0).getQuantity(), 6,"Quantity not equal");
		Assert.assertEquals(customer.getCart().getItems().get(1).getQuantity(), 4,"Quantity not equal");
		Assert.assertEquals(customer.getCart().getItems().get(2).getQuantity(), 13,"Quantity not equal");
		Assert.assertTrue(customer.getCart().isPromoApplied());
	}

	@Test
	public void testScenario2() {
		
		Item item1 = new Item(ItemName.Shoe, 1, 3);
		Item item2 = new Item(ItemName.Laptop, 2, 2);
		Item item3 = new Item(ItemName.Mobile, 1, 5);

		List<Item> items = new ArrayList<Item>();
		items.add(item1);
		items.add(item2);
		items.add(item3);

		Cart cart = new Cart(items);

		Customer customer = new Customer("Ramesh", cart);
		if (customer.getCart().isPromoApplied())
			customerCounter++;

		Assert.assertEquals(customer.getCart().getFinalCartValue(), 12.0,"Cart value not equal");
		Assert.assertEquals(customer.getCart().getItems().get(0).getQuantity(), 4,"Quantity not equal");
		Assert.assertEquals(customer.getCart().getItems().get(1).getQuantity(), 2,"Quantity not equal");
		Assert.assertEquals(customer.getCart().getItems().get(2).getQuantity(), 6,"Quantity not equal");
		Assert.assertTrue(customer.getCart().isPromoApplied());
	}

	@Test
	public void testScenario3() {
		Item item1 = new Item(ItemName.Shoe, 2, 1);
		Item item2 = new Item(ItemName.Laptop, 2, 2);
		Item item3 = new Item(ItemName.Mobile, 5, 1);

		List<Item> items = new ArrayList<Item>();
		items.add(item1);
		items.add(item2);
		items.add(item3);

		Cart cart = new Cart(items);

		Customer customer = new Customer("Suresh", cart);
		if (customer.getCart().isPromoApplied())
			customerCounter++;
		Assert.assertEquals(customer.getCart().getFinalCartValue(), 11.0,"Cart value not equal");
		Assert.assertEquals(customer.getCart().getItems().get(0).getQuantity(), 1,"Quantity not equal");
		Assert.assertEquals(customer.getCart().getItems().get(1).getQuantity(), 2,"Quantity not equal");
		Assert.assertEquals(customer.getCart().getItems().get(2).getQuantity(), 1,"Quantity not equal");
		Assert.assertFalse(customer.getCart().isPromoApplied());
	}

	@AfterClass
	public void printConfirmation() {
		System.out.println(customer.getName() + ", have done the shopping with total cart value: " + customer.getCart().getCartValue());
	}

	@AfterTest
	public void printNoOfCustomersAvailedPromotion() {
		System.out.println("Total no of customers availed promotion: " + customerCounter);
		Assert.assertEquals(customerCounter, 2,"Customer Availed promotion not equal");
	}

}
