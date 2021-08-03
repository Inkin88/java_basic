package task2;

public class Entry {

    private String streetName;
    private int numberOfResident;
    private String houseClass;

    public Entry(String text) {
        String [] values = text.split("\\|");
        this.streetName = values[0].trim();
        this.numberOfResident =Integer.parseInt(values[1].trim());
        this.houseClass = values[2].trim();
    }

    @Override
    public String toString() {
        return String.join(" | ", streetName, String.valueOf(numberOfResident), houseClass);
    }

    public String getStreetName() {
        return streetName;
    }

    public int getNumberOfResident() {
        return numberOfResident;
    }

    public String getHouseClass() {
        return houseClass;
    }
}
