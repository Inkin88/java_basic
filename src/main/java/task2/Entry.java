package task2;

import java.util.StringTokenizer;

public class Entry {

    private String streetName;
    private int numberOfResident;
    private String houseClass;

    public Entry(String text) {
        StringTokenizer st = new StringTokenizer(text, "|");
        this.streetName = st.nextToken().trim();
        this.numberOfResident =Integer.parseInt(st.nextToken().trim());
        this.houseClass = st.nextToken().trim();
    }

    @Override
    public String toString() {
        return  streetName + " | " + numberOfResident + " | " + houseClass;
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
