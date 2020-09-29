package by.company.library.bean;

public class Book {
	private String title;
	private int price;
	private Category category;

	public Book() {}
	
	public Book(String title, Category category) {
		this.title = title;
		this.category = category;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public Category getCategory() {
		return category;
	}


}
