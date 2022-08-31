package casestudy.model.facility;

public class Villa extends FacilityFurama {
    private String roomStandard; // tiêu chuẩn phòng
    private Double swimmingArea; // Diện tích hồ bơi
    private int numberFloors; // Số tầng

    public Villa() {
    }

    public Villa(String roomStandard, Double swimmingArea, int numberFloors) {
        this.roomStandard = roomStandard;
        this.swimmingArea = swimmingArea;
        this.numberFloors = numberFloors;
    }

    public Villa(String codeFacility, String serviceName, Double usableArea, Double rentalCosts, int maxNumberPeople, String lease, String roomStandard, Double swimmingArea, int numberFloors) {
        super(codeFacility, serviceName, usableArea, rentalCosts, maxNumberPeople, lease);
        this.roomStandard = roomStandard;
        this.swimmingArea = swimmingArea;
        this.numberFloors = numberFloors;
    }

    public String getRoomStandard() {
        return roomStandard;
    }

    public void setRoomStandard(String roomStandard) {
        this.roomStandard = roomStandard;
    }

    public Double getSwimmingArea() {
        return swimmingArea;
    }

    public void setSwimmingArea(Double swimmingArea) {
        this.swimmingArea = swimmingArea;
    }

    public int getNumberFloors() {
        return numberFloors;
    }

    public void setNumberFloors(int numberFloors) {
        this.numberFloors = numberFloors;
    }

    @Override
    public String toString() {
        return String.format("%s,%s,%s,%s",super.toString(),roomStandard,swimmingArea,numberFloors);
    }
}
