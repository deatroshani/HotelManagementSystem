import java.util.ArrayList;
import java.util.List;

/**
 * Manages the hotel's rooms and bookings.
 * Acts as the main controller for the Hotel Management System.
 */
public class HotelManager {

    /** List of all rooms in the hotel. */
    private List<Room> rooms;

    /** List of all bookings made. */
    private List<Booking> bookings;

    /**
     * Constructs a new HotelManager with empty room and booking lists.
     */
    public HotelManager() {
        this.rooms = new ArrayList<>();
        this.bookings = new ArrayList<>();
    }

    /**
     * Returns the list of all rooms.
     * @return list of rooms
     */
    public List<Room> getRooms() {
        return rooms;
    }

    /**
     * Returns the list of all bookings.
     * @return list of bookings
     */
    public List<Booking> getBookings() {
        return bookings;
    }

    /**
     * Adds a new room to the hotel.
     * @param room the room to add
     */
    public void addRoom(Room room) {
        rooms.add(room);
    }

    /**
     * Creates a new booking for a guest and a room.
     * @param guest the guest making the booking
     * @param room the room to book
     * @param checkInDate the check-in date
     * @param checkOutDate the check-out date
     */
    public void makeBooking(Guest guest, Room room, String checkInDate, String checkOutDate) {
        if (room.isAvailable()) {
            Booking booking = new Booking(bookings.size() + 1, guest, room, checkInDate, checkOutDate);
            booking.confirm();
            bookings.add(booking);
            System.out.println("Booking successful!");
        } else {
            System.out.println("Room " + room.getRoomNumber() + " is not available.");
        }
    }

    /**
     * Cancels a booking by its ID.
     * @param bookingId the ID of the booking to cancel
     */
    public void cancelBooking(int bookingId) {
        for (Booking booking : bookings) {
            if (booking.getBookingId() == bookingId) {
                booking.cancel();
                bookings.remove(booking);
                System.out.println("Booking " + bookingId + " cancelled.");
                return;
            }
        }
        System.out.println("Booking not found.");
    }

    /**
     * Returns a list of all currently available rooms.
     * @return list of available rooms
     */
    public List<Room> getAvailableRooms() {
        List<Room> availableRooms = new ArrayList<>();
        for (Room room : rooms) {
            if (room.isAvailable()) {
                availableRooms.add(room);
            }
        }
        return availableRooms;
    }
}
