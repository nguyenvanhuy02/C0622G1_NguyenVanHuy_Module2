package casestudy.model;

public class Contract {
    private String someContracts;
    private String codeBoking;
    private Double amountDepositFirst; // số tiền cọc trước
    private Double totalPaymentAmount; //Tổng tiền thanh toán
    private String codeCustomer;

    public Contract() {
    }

    public Contract(String someContracts, String codeBoking, Double amountDepositFirst, Double totalPaymentAmount, String codeCustomer) {
        this.someContracts = someContracts;
        this.codeBoking = codeBoking;
        this.amountDepositFirst = amountDepositFirst;
        this.totalPaymentAmount = totalPaymentAmount;
        this.codeCustomer = codeCustomer;
    }

    public String getSomeContracts() {
        return someContracts;
    }

    public void setSomeContracts(String someContracts) {
        this.someContracts = someContracts;
    }

    public String getCodeBoking() {
        return codeBoking;
    }

    public void setCodeBoking(String codeBoking) {
        this.codeBoking = codeBoking;
    }

    public Double getAmountDepositFirst() {
        return amountDepositFirst;
    }

    public void setAmountDepositFirst(Double amountDepositFirst) {
        this.amountDepositFirst = amountDepositFirst;
    }

    public Double getTotalPaymentAmount() {
        return totalPaymentAmount;
    }

    public void setTotalPaymentAmount(Double totalPaymentAmount) {
        this.totalPaymentAmount = totalPaymentAmount;
    }

    public String getCodeCustomer() {
        return codeCustomer;
    }

    public void setCodeCustomer(String codeCustomer) {
        this.codeCustomer = codeCustomer;
    }

    @Override
    public String toString() {
        return "Contract{" +
                "someContracts='" + someContracts + '\'' +
                ", codeBoking='" + codeBoking + '\'' +
                ", amountDepositFirst=" + amountDepositFirst +
                ", totalPaymentAmount=" + totalPaymentAmount +
                ", codeCustomer='" + codeCustomer + '\'' +
                '}';
    }
}
