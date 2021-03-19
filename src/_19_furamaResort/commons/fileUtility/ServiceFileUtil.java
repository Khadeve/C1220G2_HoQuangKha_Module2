package furamaResort.commons.fileUtility;

import furamaResort.models.House;
import furamaResort.models.Room;
import furamaResort.models.Service;
import furamaResort.models.Villa;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class ServiceFileUtil extends FileUtil {

    public static final String VILLA_FILE = "Villa.csv";
    public static final String HOUSE_FILE = "House.csv";
    public static final String ROOM_FILE = "Room.csv";


    /**
     * Construct a service object from a string of data.
     *
     * @param data The string of data.
     * @return A service object.
     */
    public static Service readService(String data) {
        String[] tokens = data.split(",");

        String serviceName = tokens[0];
        String id = tokens[1];
        String area = tokens[2];
        String price = tokens[3];
        String largestNumberOfGuests = tokens[4];
        String typeOfRental = tokens[5];

        if (id.contains("SVVL")) {  // In case of villa.
            String classificationOfRoom = tokens[6];
            String utility = tokens[7];
            String areaOfPool = tokens[8];
            String numberOfFloors = tokens[9];

            return new Villa(serviceName, id, Double.parseDouble(area), Double.parseDouble(price),
                    Integer.parseInt(largestNumberOfGuests), typeOfRental, classificationOfRoom,
                    utility, Double.parseDouble(areaOfPool), Integer.parseInt(numberOfFloors));

        }
        if (id.contains("SVHO")) {  // In case of house.
            String classificationOfRoom = tokens[6];
            String utility = tokens[7];
            String numberOfFloors = tokens[8];

            return new House(serviceName, id, Double.parseDouble(area), Double.parseDouble(price),
                    Integer.parseInt(largestNumberOfGuests), typeOfRental, classificationOfRoom,
                    utility, Integer.parseInt(numberOfFloors));

        }
        // In case of room.
        String freeUtility = tokens[6];

        return new Room(serviceName, id, Double.parseDouble(area), Double.parseDouble(price),
                Integer.parseInt(largestNumberOfGuests), typeOfRental, freeUtility);
    }

    /**
     * Retrieve a list of services from a file
     * and print them all on the console.
     *
     * @param path - the path of an input stream.
     * @throws IOException - from the static method readAllLines of the Files class.
     */
    public static Service[] readServiceData(Path path) throws IOException {
        List<String> lines = Files.readAllLines(path, StandardCharsets.UTF_8);
        int numberOfServices = lines.size() - 1;

        Service[] services = new Service[numberOfServices];
        for (int i = 0; i < numberOfServices; i++) {
            services[i] = readService(lines.get(i + 1));    // Skip the first line of header.
        }
        return services;
    }
}
