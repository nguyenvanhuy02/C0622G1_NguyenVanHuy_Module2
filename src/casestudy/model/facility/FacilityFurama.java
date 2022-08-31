package casestudy.model.facility;

public class FacilityFurama {
    private String codeFacility; // mã dịch vụ
    private String serviceName; // Tên dịch vụ
    private Double usableArea;  // Diện tích sử dụng.
    private Double rentalCosts; // Chi phí thuê.
    private int maxNumberPeople; // Số lượng người tối đa
    private String lease;        // Kiểu thuê

    public FacilityFurama() {
    }

    public FacilityFurama(String codeFacility, String serviceName, Double usableArea, Double rentalCosts, int maxNumberPeople, String lease) {
        this.codeFacility = codeFacility;
        this.serviceName = serviceName;
        this.usableArea = usableArea;
        this.rentalCosts = rentalCosts;
        this.maxNumberPeople = maxNumberPeople;
        this.lease = lease;
    }

    public String getCodeFacility() {
        return codeFacility;
    }

    public void setCodeFacility(String codeFacility) {
        this.codeFacility = codeFacility;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public Double getUsableArea() {
        return usableArea;
    }

    public void setUsableArea(Double usableArea) {
        this.usableArea = usableArea;
    }

    public Double getRentalCosts() {
        return rentalCosts;
    }

    public void setRentalCosts(Double rentalCosts) {
        this.rentalCosts = rentalCosts;
    }

    public int getMaxNumberPeople() {
        return maxNumberPeople;
    }

    public void setMaxNumberPeople(int maxNumberPeople) {
        this.maxNumberPeople = maxNumberPeople;
    }

    public String getLease() {
        return lease;
    }

    public void setLease(String lease) {
        this.lease = lease;
    }

    @Override
    public String toString() {
        return String.format("%s,%s,%s,%s,%s,%s",
                codeFacility, serviceName, usableArea, rentalCosts, maxNumberPeople, lease);
    }
}
