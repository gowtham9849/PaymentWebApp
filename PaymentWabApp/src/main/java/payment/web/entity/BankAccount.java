package payment.web.entity;

public class BankAccount {
	int UserId;
	String BankAcctNo;
	String BankAcctName;
	int BankAcctTypeId;
	String BankIFSCCode;
	int BankPin;
	double CurrBankBal;
	
	public int getUserId() {
		return UserId;
	}
	public void setUserId(int userId) {
		UserId = userId;
	}
	public String getBankAcctNo() {
		return BankAcctNo;
	}
	public void setBankAcctNo(String bankAcctNo) {
		BankAcctNo = bankAcctNo;
	}
	public String getBankAcctName() {
		return BankAcctName;
	}
	public void setBankAcctName(String bankAcctName) {
		BankAcctName = bankAcctName;
	}
	public int getBankAcctTypeId() {
		return BankAcctTypeId;
	}
	public void setBankAcctTypeId(int bankAcctTypeId) {
		BankAcctTypeId = bankAcctTypeId;
	}
	public String getBankIFSCCode() {
		return BankIFSCCode;
	}
	public void setBankIFSCCode(String bankIFSCCode) {
		BankIFSCCode = bankIFSCCode;
	}
	public int getBankPin() {
		return BankPin;
	}
	public void setBankPin(int bankPin) {
		BankPin = bankPin;
	}
	public double getCurrBankBal() {
		return CurrBankBal;
	}
	public void setCurrBankBal(double currBankBal) {
		CurrBankBal = currBankBal;
	}
	
}