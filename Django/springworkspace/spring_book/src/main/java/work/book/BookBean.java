package work.book;

import java.io.Serializable;

public class BookBean implements Serializable{
	private String bookCode;
	private String bookName;
	private String bookImage;
	private String bookPublishDate;
	private String bookPublisher;
	private String bookAuthor;
	private String bookGenreCd;
	private String bookRegDate;

	public BookBean() {
		super();
	}

	public BookBean(String bookCode, String bookName, String bookImage,
			String bookPublishDate, String bookPublisher, String bookAuthor,
			String bookGenreCd, String bookRegDate) {
		super();
		this.bookCode = bookCode;
		this.bookName = bookName;
		this.bookImage = bookImage;
		this.bookPublishDate = bookPublishDate;
		this.bookPublisher = bookPublisher;
		this.bookAuthor = bookAuthor;
		this.bookGenreCd = bookGenreCd;
		this.bookRegDate = bookRegDate;
	}

	public String getBookCode() {
		return bookCode;
	}

	public void setBookCode(String bookCode) {
		this.bookCode = bookCode;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getBookImage() {
		return bookImage;
	}

	public void setBookImage(String bookImage) {
		this.bookImage = bookImage;
	}

	public String getBookPublishDate() {
		return bookPublishDate;
	}

	public void setBookPublishDate(String bookPublishDate) {
		this.bookPublishDate = bookPublishDate;
	}

	public String getBookPublisher() {
		return bookPublisher;
	}

	public void setBookPublisher(String bookPublisher) {
		this.bookPublisher = bookPublisher;
	}

	public String getBookAuthor() {
		return bookAuthor;
	}

	public void setBookAuthor(String bookAuthor) {
		this.bookAuthor = bookAuthor;
	}

	public String getBookGenreCd() {
		return bookGenreCd;
	}

	public void setBookGenreCd(String bookGenreCd) {
		this.bookGenreCd = bookGenreCd;
	}

	public String getBookRegDate() {
		return bookRegDate;
	}

	public void setBookRegDate(String bookRegDate) {
		this.bookRegDate = bookRegDate;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("BookBean [bookCode=");
		builder.append(bookCode);
		builder.append(", bookName=");
		builder.append(bookName);
		builder.append(", bookImage=");
		builder.append(bookImage);
		builder.append(", bookPublishDate=");
		builder.append(bookPublishDate);
		builder.append(", bookPublisher=");
		builder.append(bookPublisher);
		builder.append(", bookAuthor=");
		builder.append(bookAuthor);
		builder.append(", bookGenreCd=");
		builder.append(bookGenreCd);
		builder.append(", bookRegDate=");
		builder.append(bookRegDate);
		builder.append("]");
		return builder.toString();
	}
}
