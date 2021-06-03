package jakarta.tutorial.dukesbookstore.dto;

import java.io.Serializable;

public class BookDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8830888015470671111L;

	private String bookId;
	private String firstname;
	private String title;
	private Double price;
	private Boolean onsale;
	private Integer calendarYear;
	private String description;
	private Integer inventory;
	private String surname;

	public String getBookId() {
		return bookId;
	}

	public void setBookId(String bookId) {
		this.bookId = bookId;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Boolean getOnsale() {
		return onsale;
	}

	public void setOnsale(Boolean onsale) {
		this.onsale = onsale;
	}

	public Integer getCalendarYear() {
		return calendarYear;
	}

	public void setCalendarYear(Integer calendarYear) {
		this.calendarYear = calendarYear;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getInventory() {
		return inventory;
	}

	public void setInventory(Integer inventory) {
		this.inventory = inventory;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	@Override
	public String toString() {
		return "BookDTO [bookId=" + bookId + ", firstname=" + firstname + ", title=" + title + ", price=" + price
				+ ", onsale=" + onsale + ", calendarYear=" + calendarYear + ", description=" + description
				+ ", inventory=" + inventory + ", surname=" + surname + "]";
	}

}
