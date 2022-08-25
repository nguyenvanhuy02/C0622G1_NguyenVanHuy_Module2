package casestudy.model.facility;

public class Villa extends FacilityFurama {
    private String roomStandard; // tiêu chuẩn phòng
    private String swimmingArea; // Diện tích hồ bơi
    private int numberFloors; // Số tầng

    public Villa() {
    }

    public Villa(String roomStandard, String swimmingArea, int numberFloors) {
        this.roomStandard = roomStandard;
        this.swimmingArea = swimmingArea;
        this.numberFloors = numberFloors;
    }

    public Villa(String serviceName, String usableArea, String rentalCosts, int maxNumberPeople, String lease, String roomStandard, String swimmingArea, int numberFloors) {
        super(serviceName, usableArea, rentalCosts, maxNumberPeople, lease);
        this.roomStandard = roomStandard;
        this.swimmingArea = swimmingArea;
        this.numberFloors = numberFloors;
    }

}
