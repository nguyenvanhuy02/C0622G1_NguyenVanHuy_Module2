package casestudy.model.facility;

public class House extends FacilityFurama {
    private String roomStandard; // tiêu chuẩn phòng
    private int numberFloors; // Số tầng

    public House() {
    }

    public House(String roomStandard, int numberFloors) {
        this.roomStandard = roomStandard;
        this.numberFloors = numberFloors;
    }

    public House(String codeFacility, String serviceName, Double usableArea, Double rentalCosts, int maxNumberPeople, String lease, String roomStandard, int numberFloors) {
        super(codeFacility, serviceName, usableArea, rentalCosts, maxNumberPeople, lease);
        this.roomStandard = roomStandard;
        this.numberFloors = numberFloors;
    }

    public String getRoomStandard() {
        return roomStandard;
    }

    public void setRoomStandard(String roomStandard) {
        this.roomStandard = roomStandard;
    }

    public int getNumberFloors() {
        return numberFloors;
    }

    public void setNumberFloors(int numberFloors) {
        this.numberFloors = numberFloors;
    }

    @Override
    public String toString() {
        return String.format("%s,%s,%s",super.toString(),roomStandard,numberFloors);
    }
}
