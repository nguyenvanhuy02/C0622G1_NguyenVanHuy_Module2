package casestudy.service.impl;

import casestudy.model.facility.FacilityFurama;
import casestudy.model.facility.House;
import casestudy.model.facility.Room;
import casestudy.model.facility.Villa;
import casestudy.service.IFacilityService;
import casestudy.service.exception.CodeVillaException;
import casestudy.service.exception.NameException;
import casestudy.service.exception.facility.CheckAreaException;
import casestudy.service.exception.facility.CheckNumberFloorsException;
import casestudy.service.exception.facility.CheckNumberPeopleException;
import casestudy.service.exception.facility.CheckRentalCostsException;
import casestudy.service.read_write.ReadFile;
import casestudy.service.read_write.WirteFile;

import java.io.IOException;
import java.util.*;

public class FacilityService implements IFacilityService {
    private static Scanner scanner = new Scanner(System.in);
    private static Map<FacilityFurama, Integer> facilitys = new LinkedHashMap<>();
    private static Map<FacilityFurama, Integer> faccilityMaintenances = new LinkedHashMap<>();
    private static final String PATH_FILE = "src/casestudy/service/data/fileFacilityFurama.csv";

    //    static Map<Villa, Integer> villaIntegerMap = new LinkedHashMap<>();
//    static Map<House, Integer> houseIntegerMap = new LinkedHashMap<>();
//    static Map<Room, Integer> roomIntegerMap = new LinkedHashMap<>();
//    static {
//        facilitys.put(new House("ád", "ád", 1.2, 1.5, 2, "adas", "ád", 2), 1);
//        facilitys.put(new Villa("ád", "ád", 1.2, 1.5, 2, "ád", "dá", 2.2, 2), 5);
//        facilitys.put(new Room("ád", "ád", 1.2, 1.5, 2, "ád", "Dá"), 6);
//    }

    @Override
    public void disPlayFacility() throws IOException {
        facilitys = ReadFile.readFacilityFile(PATH_FILE);
        for (FacilityFurama facilityFurama : facilitys.keySet()) {
            System.out.println(facilityFurama + "+" + facilitys.get(facilityFurama));
        }
    }

    @Override
    public void addFacility() throws IOException {
        comeBack:
        while (true) {
            int choice;
            System.out.println("-----Thêm cơ sở-----\n" +
                    "1.Thêm mới Villa\n" +
                    "2.Thêm mới House\n" +
                    "3.Thêm mới Room\n" +
                    "4.Quay lại");
            System.out.print("Lựa chọn của bạn: ");
            choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    facilitys = ReadFile.readFacilityFile(PATH_FILE);
                    Villa villa = addVilla();
                    facilitys.put(villa, 0);
                    System.out.println("Thêm mới Villa thành công!");
                    WirteFile.writeFacility(PATH_FILE,facilitys);
                    break;
                case 2:
                    facilitys = ReadFile.readFacilityFile(PATH_FILE);
                    House house = addHouse();
                    facilitys.put(house, 0);
                    System.out.println("Thêm mới House thành công!");
                    WirteFile.writeFacility(PATH_FILE,facilitys);
                    break;
                case 3:
                    facilitys = ReadFile.readFacilityFile(PATH_FILE);
                    Room room = addRoom();
                    facilitys.put(room, 0);
                    System.out.println("Thêm mới Room thành công!");
                    WirteFile.writeFacility(PATH_FILE,facilitys);
                    break;
                case 4:
                    break comeBack;
                default:
                    System.out.println("Bạn nhập không đúng vui lòng nhập lại!");
            }
        }

    }

    @Override
    public void disPlayMaintenance() throws IOException {
        faccilityMaintenances = new LinkedHashMap<>();
        facilitys = ReadFile.readFacilityFile(PATH_FILE);
        for (FacilityFurama facilityFurama : facilitys.keySet()) {
            if (facilitys.get(facilityFurama) >= 5) {
                faccilityMaintenances.put(facilityFurama, facilitys.get(facilityFurama));
            }
        }

        for (FacilityFurama facilityFurama : faccilityMaintenances.keySet()) {
            System.out.println(facilityFurama + "+" + faccilityMaintenances.get(facilityFurama));
        }
    }

    public static Villa addVilla() {

        String codeVilla;
        while (true) {
            try {
                System.out.print("Mời bạn nhập mã villa[SVVL-XXXX(X là số 0-9)]: ");
                codeVilla = scanner.nextLine();
                String regex = "[S][V][V][L][-][0-9]{4}";
                if (!(codeVilla.matches(regex))) {
                    throw new CodeVillaException("Bạn nhập không đúng định dạng vui lòng nhập lại!");
                }
                break;
            } catch (CodeVillaException e) {
                System.out.println(e.getMessage());
            }
        }

        String nameVilla;
        while (true) {
            try {
                System.out.print("Mời bạn nhập tên villa: ");
                nameVilla = scanner.nextLine();
                String regex = "[A-Z][a-z\\s]{1,10}";
                if (!(nameVilla.matches(regex))) {
                    throw new NameException("Bạn nhập sai định dạng vui lòng nhập lại!");
                }
                break;
            } catch (NameException e) {
                System.out.println(e.getMessage());
            }
        }
        Double areaVilla;
        while (true) {
            try {
                System.out.print("Mời bạn nhập diện tích sử dụng Villa(>30m2): ");
                areaVilla = Double.parseDouble(scanner.nextLine());
                if (!(areaVilla > 30)) {
                    throw new CheckAreaException("Bạn nhập không đúng theo yêu cầu vui lòng nhập lại!");
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("Bạn nhập không đúng dạng vui lòng nhập lại!");
            } catch (CheckAreaException e) {
                System.out.println(e.getMessage());
            }
        }
        Double rentalCostsVilla;
        while (true) {
            try {
                System.out.print("Mời bạn nhập chi phí thuê Villa: ");
                rentalCostsVilla = Double.parseDouble(scanner.nextLine());
                if (!(rentalCostsVilla > 0)) {
                    throw new CheckRentalCostsException("Bạn nhập không đúng dạng vui lòng nhập lại (>0)");
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("Bạn nhập không đúng dạng vui lòng nhập lại!");
            } catch (CheckRentalCostsException e) {
                System.out.println(e.getMessage());
            }
        }
        int maxNumberPeople;
        while (true) {
            try {
                System.out.print("Mời bạn nhập số lượng người tối đa (0<người<20): ");
                maxNumberPeople = Integer.parseInt(scanner.nextLine());
                if (!(0 < maxNumberPeople && maxNumberPeople < 20)) {
                    throw new CheckNumberPeopleException("Nhập không đúng quy định vui lòng nhập lại!");
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("Bạn nhập không đúng dạng vui lòng nhập lại!");
            } catch (CheckNumberPeopleException e) {
                System.out.println(e.getMessage());
            }
        }

        String lease = lease();

        String roomStandardVilla = roomStandard();

        Double swimmingAreaVilla;
        while (true) {
            try {
                System.out.print("Mời bạn nhập diện tích hồ bơi Villa(>30m2): ");
                swimmingAreaVilla = Double.parseDouble(scanner.nextLine());
                if (!(swimmingAreaVilla > 30)) {
                    throw new CheckAreaException("Bạn nhập không đúng theo yêu cầu vui lòng nhập lại!");
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("Bạn nhập không đúng dạng vui lòng nhập lại!");
            } catch (CheckAreaException e) {
                System.out.println(e.getMessage());
            }
        }

        int numberFloorsVilla;
        while (true) {
            try {
                System.out.print("Mời bạn nhập số tầng: ");
                numberFloorsVilla = Integer.parseInt(scanner.nextLine());
                if (!(0 < numberFloorsVilla && numberFloorsVilla < 5)) {
                    throw new CheckNumberFloorsException("Bạn nhập không phù hợp vui lòng nhập lại!");
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("Bạn nhập không đúng vui lòng nhập lại!");
            } catch (CheckNumberFloorsException e) {
                System.out.println(e.getMessage());
            }
        }

        Villa villa = new Villa(codeVilla, nameVilla, areaVilla, rentalCostsVilla, maxNumberPeople, lease, roomStandardVilla, swimmingAreaVilla, numberFloorsVilla);
        return villa;
    }


    public static House addHouse() {
        String codeHouse;
        while (true) {
            try {
                System.out.print("Mời bạn nhập mã House[SVHO-XXXX(X là số 0-9)]: ");
                codeHouse = scanner.nextLine();
                String regex = "[S][V][H][O][-][0-9]{4}";
                if (!(codeHouse.matches(regex))) {
                    throw new CodeVillaException("Bạn nhập không đúng định dạng vui lòng nhập lại!");
                }
                break;
            } catch (CodeVillaException e) {
                System.out.println(e.getMessage());
            }
        }
        String nameHouse;
        while (true) {
            try {
                System.out.print("Mời bạn nhập tên House: ");
                nameHouse = scanner.nextLine();
                String regex = "[A-Z]{1}[a-z]";
                if (!(nameHouse.matches(regex))) {
                    throw new NameException("Bạn nhập sai định dạng vui lòng nhập lại!");
                }
                break;
            } catch (NameException e) {
                System.out.println(e.getMessage());
            }
        }
        Double areaHouse;
        while (true) {
            try {
                System.out.print("Mời bạn nhập diện tích sử dụng House(>30m2): ");
                areaHouse = Double.parseDouble(scanner.nextLine());
                if (!(areaHouse > 30)) {
                    throw new CheckAreaException("Bạn nhập không đúng theo yêu cầu vui lòng nhập lại!");
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("Bạn nhập không đúng dạng vui lòng nhập lại!");
            } catch (CheckAreaException e) {
                System.out.println(e.getMessage());
            }
        }
        Double rentalCostsHouse;
        while (true) {
            try {
                System.out.print("Mời bạn nhập chi phí thuê House: ");
                rentalCostsHouse = Double.parseDouble(scanner.nextLine());
                if (!(rentalCostsHouse > 0)) {
                    throw new CheckRentalCostsException("Bạn nhập không đúng dạng vui lòng nhập lại (>0)");
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("Bạn nhập không đúng dạng vui lòng nhập lại!");
            } catch (CheckRentalCostsException e) {
                System.out.println(e.getMessage());
            }
        }
        int maxNumberPeople;
        while (true) {
            try {
                System.out.print("Mời bạn nhập số lượng người tối đa (0<người<20): ");
                maxNumberPeople = Integer.parseInt(scanner.nextLine());
                if (!(0 < maxNumberPeople && maxNumberPeople < 20)) {
                    throw new CheckNumberPeopleException("Nhập không đúng quy định vui lòng nhập lại!");
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("Bạn nhập không đúng dạng vui lòng nhập lại!");
            } catch (CheckNumberPeopleException e) {
                System.out.println(e.getMessage());
            }
        }

        String lease = lease();

        String roomStandardHouse = roomStandard();

        int numberFloorsHouse;
        while (true) {
            try {
                System.out.print("Mời bạn nhập số tầng: ");
                numberFloorsHouse = Integer.parseInt(scanner.nextLine());
                if (!(0 < numberFloorsHouse && numberFloorsHouse < 5)) {
                    throw new CheckNumberFloorsException("Bạn nhập không phù hợp vui lòng nhập lại!");
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("Bạn nhập không đúng vui lòng nhập lại!");
            } catch (CheckNumberFloorsException e) {
                System.out.println(e.getMessage());
            }
        }

        House house = new House(codeHouse, nameHouse, areaHouse, rentalCostsHouse, maxNumberPeople, lease, roomStandardHouse, numberFloorsHouse);
        return house;
    }

    public static Room addRoom() {
        String codeRoom;
        while (true) {
            try {
                System.out.print("Mời bạn nhập mã House[SVRO-XXXX(X là số 0-9)]: ");
                codeRoom = scanner.nextLine();
                String regex = "[S][V][R][O][-][0-9]{4}";
                if (!(codeRoom.matches(regex))) {
                    throw new CodeVillaException("Bạn nhập không đúng định dạng vui lòng nhập lại!");
                }
                break;
            } catch (CodeVillaException e) {
                System.out.println(e.getMessage());
            }
        }
        String nameRoom;
        while (true) {
            try {
                System.out.print("Mời bạn nhập tên Room: ");
                nameRoom = scanner.nextLine();
                String regex = "[A-Z]{1}[a-z]";
                if (!(nameRoom.matches(regex))) {
                    throw new NameException("Bạn nhập sai định dạng vui lòng nhập lại!");
                }
                break;
            } catch (NameException e) {
                System.out.println(e.getMessage());
            }
        }
        Double areaRoom;
        while (true) {
            try {
                System.out.print("Mời bạn nhập diện tích sử dụng Room(>30m2): ");
                areaRoom = Double.parseDouble(scanner.nextLine());
                if (!(areaRoom > 30)) {
                    throw new CheckAreaException("Bạn nhập không đúng theo yêu cầu vui lòng nhập lại!");
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("Bạn nhập không đúng dạng vui lòng nhập lại!");
            } catch (CheckAreaException e) {
                System.out.println(e.getMessage());
            }
        }
        Double rentalCostsRoom;
        while (true) {
            try {
                System.out.print("Mời bạn nhập chi phí thuê Room: ");
                rentalCostsRoom = Double.parseDouble(scanner.nextLine());
                if (!(rentalCostsRoom > 0)) {
                    throw new CheckRentalCostsException("Bạn nhập không đúng dạng vui lòng nhập lại (>0)");
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("Bạn nhập không đúng dạng vui lòng nhập lại!");
            } catch (CheckRentalCostsException e) {
                System.out.println(e.getMessage());
            }
        }
        int maxNumberPeople;
        while (true) {
            try {
                System.out.print("Mời bạn nhập số lượng người tối đa (0<người<20): ");
                maxNumberPeople = Integer.parseInt(scanner.nextLine());
                if (!(0 < maxNumberPeople && maxNumberPeople < 20)) {
                    throw new CheckNumberPeopleException("Nhập không đúng quy định vui lòng nhập lại!");
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("Bạn nhập không đúng dạng vui lòng nhập lại!");
            } catch (CheckNumberPeopleException e) {
                System.out.println(e.getMessage());
            }
        }

        String lease = lease();
        System.out.print("Mời bạn nhập dịch vụ miễn phí đi kèm:");
        String freeServiceRoom = scanner.nextLine();

        Room room = new Room(codeRoom, nameRoom, areaRoom, rentalCostsRoom, maxNumberPeople, lease, freeServiceRoom);
        return room;
    }

    public static String lease() {
        while (true) {
            int choice;
            String lease = "";
            try {
                System.out.print("Mời bạn nhập kiểu thuê:\n " +
                        "1.Thuê theo ngày\n" +
                        "2.Thuê theo tháng\n" +
                        "3.Thuê theo năm");
                System.out.print("Lựa chọn của bạn: ");
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Lựa chọn của bạn không phù hợp vui lòng nhập lại!");
                continue;
            }
            switch (choice) {
                case 1:
                    return lease += "Thuê theo ngày";
                case 2:
                    return lease += "Thê theo tháng";
                case 3:
                    return lease += "Thuê theo năm";
                default:
                    System.out.println("lựa chọn của bạn không phù hợp vui lòng nhập lại!");
            }
        }
    }

    public static String roomStandard() {
        while (true) {
            int choice;
            String roomStandard = "";
            try {
                System.out.println("Mời bạn lựa chọn tiêu chuẩn kiểu thuê:\n" +
                        "1.Thuê kiểu cao cấp\n" +
                        "2.Thuê kiểu bình thường");
                System.out.print("Lựa chọn của bạn: ");
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Lựa chọn của bạn không phù hợp vui lòng nhập lại!");
                continue;
            }
            switch (choice) {
                case 1:
                    return roomStandard += "Kiểu thuê cao cấp";
                case 2:
                    return roomStandard += "Kiểu thuê bình thường";
                default:
                    System.out.println("Lựa chọn của bạn không đúng vui lòng nhập lại!");
            }
        }
    }
}
