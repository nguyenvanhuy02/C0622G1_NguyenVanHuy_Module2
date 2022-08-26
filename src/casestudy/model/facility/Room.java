package casestudy.model.facility;

public class Room extends FacilityFurama {
    private String freeService; // dịch vụ miễn phí đi kèm

    public Room() {
    }

    public Room(String freeService) {
        this.freeService = freeService;
    }

    public Room(String codeFacility, String serviceName, String usableArea, String rentalCosts, int maxNumberPeople, String lease, String freeService) {
        super(codeFacility, serviceName, usableArea, rentalCosts, maxNumberPeople, lease);
        this.freeService = freeService;
    }

    public String getFreeService() {
        return freeService;
    }

    public void setFreeService(String freeService) {
        this.freeService = freeService;
    }

    @Override
    public String toString() {
        return "Room{" +
                "freeService='" + freeService + '\'' +
                '}';
    }
}
