package com.amzi.obj;

import java.util.ArrayList;

public class Cart {
	private static String emailid;
	private static float totalPaymentl;
	private static int makepaymentflg;
	public static int getMakepaymentflg() {
		return makepaymentflg;
	}

	public static void setMakepaymentflg(int makepaymentflg) {
		Cart.makepaymentflg = makepaymentflg;
	}

	public static float getTotalPaymentl() {
		return totalPaymentl;
	}

	public static void setTotalPaymentl(float totalPaymentl) {
		Cart.totalPaymentl = totalPaymentl;
	}

	private String ISBN;
	private float price;
	private int quantity;
	public ArrayList<MBook> cart = new ArrayList<MBook>();
	
	public String getISBN() {
		return ISBN;
	}

	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public ArrayList<MBook> getCart() {
		return cart;
	}

	public void setCart(ArrayList<MBook> cart) {
		this.cart = cart;
	}

	
	
	public static String getEmailid() {
		return emailid;
	}

	public static void setEmailid(String emailid) {
		Cart.emailid = emailid;
	}

}
