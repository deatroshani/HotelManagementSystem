/**
 * Represents a hotel room with its details and availability status.
 */
public class Room {

    /** The unique room number. */
    private int roomNumber;

    /** The type of the room (e.g. Single, Double, Suite). */
    private String type;

    /** The price per night for the room. */
    private double price;

    /** Whether the room is currently available. */
    private boolean isAvailable;

    /**
     * Constructs a new Room with the given details.
     * @param roomNumber the room number
     * @param type the type of room
     * @param price the price per night
     */
    public Room(int roomNumber, String type, double price) {
        this.roomNumber = roomNumber;
        this.type = type;
        this.price = price;
        this.isAvailable = true;
    }

    /**
     * Returns the room number.
     * @return roomNumber
     */
    public int getRoomNumber() {
        return roomNumber;
    }

    /**
     * Returns the type of the room.
     * @return type
     */
    public String getType() {
        return type;
    }

    /**
     * Returns the price per night.
     * @return price
     */
    public double getPrice() {
        return price;
    }

    /**
     * Returns whether the room is available.
     * @return true if available, false if occupied
     */
    public boolean isAvailable() {
        return isAvailable;
    }

    /**
     * Sets the availability of the room.
     * @param available true to mark as available, false to mark as occupied
     */
    public void setAvailable(boolean available) {
        this.isAvailable = available;
    }

    /**
     * Marks the room as occupied (check-in).
     */
    public void checkIn() {
        this.isAvailable = false;
    }

    /**
     * Marks the room as available (check-out).
     */
    public void checkOut() {
        this.isAvailable = true;
    }
}
