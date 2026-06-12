/**
 * Represents a hotel guest with their personal details.
 */
public class Guest {

    /** The unique ID of the guest. */
    private int guestId;

    /** The full name of the guest. */
    private String name;

    /** The contact information of the guest (phone or email). */
    private String contact;

    /**
     * Constructs a new Guest with the given details.
     * @param guestId the unique guest ID
     * @param name the full name of the guest
     * @param contact the contact information of the guest
     */
    public Guest(int guestId, String name, String contact) {
        this.guestId = guestId;
        this.name = name;
        this.contact = contact;
    }

    /**
     * Returns the guest ID.
     * @return guestId
     */
    public int getGuestId() {
        return guestId;
    }

    /**
     * Returns the name of the guest.
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the contact information of the guest.
     * @return contact
     */
    public String getContact() {
        return contact;
    }

    /**
     * Sets the name of the guest.
     * @param name the new name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Sets the contact information of the guest.
     * @param contact the new contact information
     */
    public void setContact(String contact) {
        this.contact = contact;
    }

    /**
     * Returns a formatted string with the guest's details.
     * @return a string containing guest ID, name and contact
     */
    public String getDetails() {
        return "Guest ID: " + guestId + " | Name: " + name + " | Contact: " + contact;
    }
}