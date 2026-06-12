/**
 * Represents a booking made by a guest for a specific room.
 */

public class Booking {

    /** The unique booking ID. */
    private int bookingId;

    /** The guest who made the booking. */
    private Guest guest;

    /** The room that has been booked. */
    private Room room;

    /** The check-in date. */
    private String checkInDate;

    /** The check-out date. */
    private String checkOutDate;

    /**
     * Constructs a new Booking with the given details.
     * @param bookingId the unique booking ID
     * @param guest the guest making the booking
     * @param room the room being booked
     * @param checkInDate the check-in date
     * @param checkOutDate the check-out date
     */
    public Booking(int bookingId, Guest guest, Room room, String checkInDate, String checkOutDate) {
        this.bookingId = bookingId;
        this.guest = guest;
        this.room = room;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
    }

    /**
     * Returns the booking ID.
     * @return bookingId
     */
    public int getBookingId() {
        return bookingId;
    }

    /**
     * Returns the guest associated with this booking.
     * @return guest
     */
    public Guest getGuest() {
        return guest;
    }

    /**
     * Returns the room associated with this booking.
     * @return room
     */
    public Room getRoom() {
        return room;
    }

    /**
     * Returns the check-in date.
     * @return checkInDate
     */
    public String getCheckInDate() {
        return checkInDate;
    }

    /**
     * Returns the check-out date.
     * @return checkOutDate
     */
    public String getCheckOutDate() {
        return checkOutDate;
    }

    /**
     * Confirms the booking by marking the room as occupied.
     */
    public void confirm() {
        room.checkIn();
        System.out.println("Booking confirmed for " + guest.getName() + " in room " + room.getRoomNumber());
    }

    /**
     * Cancels the booking by marking the room as available.
     */
    public void cancel() {
        room.checkOut();
        System.out.println("Booking cancelled for " + guest.getName() + " in room " + room.getRoomNumber());
    }

}

