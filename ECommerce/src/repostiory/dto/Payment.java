package repostiory.dto;

public class Payment {
	private int payementId;
	private String payemntType;
	private long paidTime;
	private double paidAmount;
	public int getPayementId() {
		return payementId;
	}
	public void setPayementId(int payementId) {
		this.payementId = payementId;
	}
	public String getPayemntType() {
		return payemntType;
	}
	public void setPayemntType(String payemntType) {
		this.payemntType = payemntType;
	}
	public long getPaidTime() {
		return paidTime;
	}
	public void setPaidTime(long paidTime) {
		this.paidTime = paidTime;
	}
	public double getPaidAmount() {
		return paidAmount;
	}
	public void setPaidAmount(double paidAmount) {
		this.paidAmount = paidAmount;
	}
	
	
}
