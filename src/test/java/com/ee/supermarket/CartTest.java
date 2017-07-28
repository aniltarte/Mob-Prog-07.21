package com.ee.supermarket;

import org.junit.Before;
import org.junit.Test;
import shoppingcart.Cart;

import static org.junit.Assert.*;

public class CartTest {
    Cart cart;

    @Before
    public void setUp() throws Exception {
        cart = new Cart();
    }

    @Test
    public void shouldBeEmpty_whenCreated(){

        assertTrue(cart.isEmpty());
    }

    @Test
    public void shouldNotBeEmpty_whenAProductIsAdded() {
        cart.addProduct("Dove", 0);

        assertFalse(cart.isEmpty());
    }

    @Test
    public void shouldReturnZeroQuantity_whenProductIsNotAdded() {

        assertEquals(0, cart.getProductQuantity("Dove"));
    }

    @Test
    public void shouldAddThreeDoveSoaps(){
        cart.addProduct("Dove", 30);
        cart.addProduct("Dove", 30);
        cart.addProduct("Dove", 30);

        assertEquals(3, cart.getProductQuantity("Dove"));
    }

    @Test
    public void shouldReturnTotalPriceOfCart(){
        cart.addProduct("Dove", 30);
        cart.addProduct("Dove", 30);
        cart.addProduct("Dove", 30);
        cart.addProduct("Dove", 30);
        cart.addProduct("Dove", 30);

        assertEquals(150, cart.computeTotalPrice());
    }

    @Test
    public void shouldAddTwoDifferentProducts() {
        cart.addProduct("Dove", 30);
        cart.addProduct("Dove", 30);
        cart.addProduct("Axe Deo", 100);

        assertEquals(2, cart.getProductQuantity("Dove"));
        assertEquals(1, cart.getProductQuantity("Axe Deo"));
    }

    @Test
    public void shouldComputeTheTotalPriceForDifferentProducts() {
        cart.addProduct("Dove", 30);
        cart.addProduct("Dove", 30);
        cart.addProduct("Dove", 30);
        cart.addProduct("Axe Deo", 100);
        cart.addProduct("Axe Deo", 100);

        assertEquals(290, cart.computeTotalPrice());
    }

    @Test
    public void shouldApplyBuyTwoGetOneFreeOfferOnProduct() {
        cart.addProduct("Dove", 30);
        cart.addProduct("Dove", 30);
        cart.addProduct("Dove", 30);

        cart.addBuyTwoGetOneFreeOffer("Dove");

        assertEquals(60, cart.computeTotalPrice());
    }
}
