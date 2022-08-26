package casestudy.model;

public class Booking {
    private String codeBongking;
    private String startDay;
    private String endDay;
    private String codeCustomer;
    private String serviceName;
    private String serviceType;

    public Booking() {
    }

    public Booking(String codeBongking, String startDay, String endDay, String codeCustomer, String serviceName, String serviceType) {
        this.codeBongking = codeBongking;
        this.startDay = startDay;
        this.endDay = endDay;
        this.codeCustomer = codeCustomer;
        this.serviceName = serviceName;
        this.serviceType = serviceType;
    }

    public String getCodeBongking() {
        return codeBongking;
    }

    public void setCodeBongking(String codeBongking) {
        this.codeBongking = codeBongking;
    }

    public String getStartDay() {
        return startDay;
    }

    public void setStartDay(String startDay) {
        this.startDay = startDay;
    }

    public String getEndDay() {
        return endDay;
    }

    public void setEndDay(String endDay) {
        this.endDay = endDay;
    }

    public String getCodeCustomer() {
        return codeCustomer;
    }

    public void setCodeCustomer(String codeCustomer) {
        this.codeCustomer = codeCustomer;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getServiceType() {
        return serviceType;
    }

    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
    }

    @Override
    public String toString() {
        return "Booking{" +
                "codeBongking='" + codeBongking + '\'' +
                ", startDay='" + startDay + '\'' +
                ", endDay='" + endDay + '\'' +
                ", codeCustomer='" + codeCustomer + '\'' +
                ", serviceName='" + serviceName + '\'' +
                ", serviceType='" + serviceType + '\'' +
                '}';
    }
}
