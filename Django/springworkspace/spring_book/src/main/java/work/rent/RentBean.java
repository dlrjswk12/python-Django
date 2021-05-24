package work.rent;

import java.io.Serializable;

public class RentBean implements Serializable{
	private String rentNo;
	private String userCode;
	private String bookCode;
	private String rentalStatus;
	private String rentStaDate;
	private String rentEndDate;
	private String extendYn;

	public RentBean() {
		super();
	}

	public RentBean(String rentNo, String userCode, String bookCode,
			String rentalStatus, String rentStaDate, String rentEndDate,
			String extendYn) {
		super();
		this.rentNo = rentNo;
		this.userCode = userCode;
		this.bookCode = bookCode;
		this.rentalStatus = rentalStatus;
		this.rentStaDate = rentStaDate;
		this.rentEndDate = rentEndDate;
		this.extendYn = extendYn;
	}

	public String getRentNo() {
		return rentNo;
	}

	public void setRentNo(String rentNo) {
		this.rentNo = rentNo;
	}

	public String getUserCode() {
		return userCode;
	}

	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}

	public String getBookCode() {
		return bookCode;
	}

	public void setBookCode(String bookCode) {
		this.bookCode = bookCode;
	}

	public String getRentalStatus() {
		return rentalStatus;
	}

	public void setRentalStatus(String rentalStatus) {
		this.rentalStatus = rentalStatus;
	}

	public String getRentStaDate() {
		return rentStaDate;
	}

	public void setRentStaDate(String rentStaDate) {
		this.rentStaDate = rentStaDate;
	}

	public String getRentEndDate() {
		return rentEndDate;
	}

	public void setRentEndDate(String rentEndDate) {
		this.rentEndDate = rentEndDate;
	}

	public String getExtendYn() {
		return extendYn;
	}

	public void setExtendYn(String extendYn) {
		this.extendYn = extendYn;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("RentBean [rentNo=");
		builder.append(rentNo);
		builder.append(", userCode=");
		builder.append(userCode);
		builder.append(", bookCode=");
		builder.append(bookCode);
		builder.append(", rentalStatus=");
		builder.append(rentalStatus);
		builder.append(", rentStaDate=");
		builder.append(rentStaDate);
		builder.append(", rentEndDate=");
		builder.append(rentEndDate);
		builder.append(", extendYn=");
		builder.append(extendYn);
		builder.append("]");
		return builder.toString();
	}
}
