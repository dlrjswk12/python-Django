package work.reserve;

import java.io.Serializable;

public class ReserveBean implements Serializable{
	private String reserveNo;
	private String rentNo;
	private String userCode;
	private String bookCode;
	private String reserveYn;

	public ReserveBean() {
		super();
	}

	public ReserveBean(String reserveNo, String rentNo, String userCode,
			String bookCode, String reserveYn) {
		super();
		this.reserveNo = reserveNo;
		this.rentNo = rentNo;
		this.userCode = userCode;
		this.bookCode = bookCode;
		this.reserveYn = reserveYn;
	}

	public String getReserveNo() {
		return reserveNo;
	}

	public void setReserveNo(String reserveNo) {
		this.reserveNo = reserveNo;
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

	public String getReserveYn() {
		return reserveYn;
	}

	public void setReserveYn(String reserveYn) {
		this.reserveYn = reserveYn;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ReserveBean [reserveNo=");
		builder.append(reserveNo);
		builder.append(", rentNo=");
		builder.append(rentNo);
		builder.append(", userCode=");
		builder.append(userCode);
		builder.append(", bookCode=");
		builder.append(bookCode);
		builder.append(", reserveYn=");
		builder.append(reserveYn);
		builder.append("]");
		return builder.toString();
	}

}
