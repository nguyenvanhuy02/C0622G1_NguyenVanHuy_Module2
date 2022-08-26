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

    public Villa(String codeFacility, String serviceName, String usableArea, String rentalCosts, int maxNumberPeople, String lease, String roomStandard, String swimmingArea, int numberFloors) {
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

    public String getSwimmingArea() {
        return swimmingArea;
    }

    public void setSwimmingArea(String swimmingArea) {
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
        return "Villa{" +
                "roomStandard='" + roomStandard + '\'' +
                ", swimmingArea='" + swimmingArea + '\'' +
                ", numberFloors=" + numberFloors +
                '}';
    }
}
