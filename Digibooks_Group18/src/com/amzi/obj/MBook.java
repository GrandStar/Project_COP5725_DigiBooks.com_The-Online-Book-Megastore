package com.amzi.obj;

public class MBook {
	private int bookid;
	private int IsInventory;
	private String bookname;
	private String author;
	private int publicationhouse;
	private String publicationName;
	private int genre;
	private int publicationyear;
	private float price;
	private int language;
	private String languageName;
	private int Quantity;
	private int inventory;
	private String ISBN;
	private String genredesc;
	
	public String getPublicationName() {
		return publicationName;
	}
	public void setPublicationName(String publicationName) {
		this.publicationName = publicationName;
	}
	public int getQuantity() {
		return Quantity;
	}
	public void setQuantity(int quantity) {
		Quantity = quantity;
	}
	public String getLanguageName() {
		return languageName;
	}
	public void setLanguageName(String languageName) {
		this.languageName = languageName;
	}
	
	
	public int getBookid(){
		return bookid;
	}
	public void setBookid(int bookid) {
		this.bookid = bookid;
	}
	public int getIsInventory() {
		return IsInventory;
	}
	public void setIsInventory(int isInventory) {
		IsInventory = isInventory;
	}
	public String getGenredesc() {
		return genredesc;
	}
	public void setGenredesc(String genredesc) {
		this.genredesc = genredesc;
	}
	public String getBookname() {
		return bookname;
	}
	public void setBookname(String bookname) {
		this.bookname = bookname;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public int getPublicationhouse() {
		return publicationhouse;
	}
	public void setPublicationhouse(int publicationhouse) {
		this.publicationhouse = publicationhouse;
	}
	public int getGenre() {
		return genre;
	}
	public void setGenre(int genre) {
		this.genre = genre;
	}
	public int getPublicationyear() {
		return publicationyear;
	}
	public void setPublicationyear(int publicationyear) {
		this.publicationyear = publicationyear;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public int getLanguage() {
		return language;
	}
	public void setLanguage(int language) {
		this.language = language;
	}
	public int getInventory() {
		return inventory;
	}
	public void setInventory(int inventory) {
		this.inventory = inventory;
	}
	public String getISBN() {
		return ISBN;
	}
	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}
}