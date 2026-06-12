import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

/**
 * Main entry point for the Hotel Management System.
 * Creates the GUI and initializes the application.
 */
public class Main {

    /** The hotel manager instance. */
    private static HotelManager hotelManager = new HotelManager();

    /**
     * Main method - launches the application.
     * @param args command line arguments
     */
    public static void main(String[] args) {
        // Add some sample rooms
        hotelManager.addRoom(new Room(101, "Single", 50.0));
        hotelManager.addRoom(new Room(102, "Double", 80.0));
        hotelManager.addRoom(new Room(103, "Suite", 150.0));

        SwingUtilities.invokeLater(() -> createAndShowGUI());
    }

    /**
     * Creates and displays the main GUI window.
     */
    private static void createAndShowGUI() {
        JFrame frame = new JFrame("Hotel Management System");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(700, 500);
        frame.setLayout(new BorderLayout());

        // Title
        JLabel title = new JLabel("Hotel Management System", SwingConstants.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 20));
        title.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));
        frame.add(title, BorderLayout.NORTH);

        // Room table
        String[] columns = {"Room Number", "Type", "Price", "Available"};
        DefaultTableModel tableModel = new DefaultTableModel(columns, 0);
        JTable roomTable = new JTable(tableModel);
        refreshTable(tableModel);
        frame.add(new JScrollPane(roomTable), BorderLayout.CENTER);

        // Button panel
        JPanel buttonPanel = new JPanel();

        JButton checkInBtn = new JButton("Check In");
        JButton checkOutBtn = new JButton("Check Out");
        JButton viewBookingsBtn = new JButton("View Bookings");

        buttonPanel.add(checkInBtn);
        buttonPanel.add(checkOutBtn);
        buttonPanel.add(viewBookingsBtn);
        frame.add(buttonPanel, BorderLayout.SOUTH);

        // Check In action
        checkInBtn.addActionListener(e -> {
            String roomNum = JOptionPane.showInputDialog("Enter Room Number:");
            String guestName = JOptionPane.showInputDialog("Enter Guest Name:");
            String contact = JOptionPane.showInputDialog("Enter Guest Contact:");
            String checkIn = JOptionPane.showInputDialog("Enter Check-In Date:");
            String checkOut = JOptionPane.showInputDialog("Enter Check-Out Date:");

            for (Room room : hotelManager.getRooms()) {
                if (room.getRoomNumber() == Integer.parseInt(roomNum)) {
                    Guest guest = new Guest(hotelManager.getBookings().size() + 1, guestName, contact);
                    hotelManager.makeBooking(guest, room, checkIn, checkOut);
                    refreshTable(tableModel);
                    JOptionPane.showMessageDialog(frame, "Check-in successful!");
                    return;
                }
            }
            JOptionPane.showMessageDialog(frame, "Room not found!");
        });

        // Check Out action
        checkOutBtn.addActionListener(e -> {
            String bookingId = JOptionPane.showInputDialog("Enter Booking ID to check out:");
            hotelManager.cancelBooking(Integer.parseInt(bookingId));
            refreshTable(tableModel);
            JOptionPane.showMessageDialog(frame, "Check-out successful!");
        });

        // View Bookings action
        viewBookingsBtn.addActionListener(e -> {
            if (hotelManager.getBookings().isEmpty()) {
                JOptionPane.showMessageDialog(frame, "No bookings found.");
                return;
            }
            StringBuilder sb = new StringBuilder();
            for (Booking b : hotelManager.getBookings()) {
                sb.append("Booking ID: ").append(b.getBookingId())
                        .append(" | Guest: ").append(b.getGuest().getName())
                        .append(" | Room: ").append(b.getRoom().getRoomNumber())
                        .append(" | Check-in: ").append(b.getCheckInDate())
                        .append(" | Check-out: ").append(b.getCheckOutDate())
                        .append("\n");
            }
            JOptionPane.showMessageDialog(frame, sb.toString());
        });

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    /**
     * Refreshes the room table with current data.
     * @param tableModel the table model to refresh
     */
    private static void refreshTable(DefaultTableModel tableModel) {
        tableModel.setRowCount(0);
        for (Room room : hotelManager.getRooms()) {
            tableModel.addRow(new Object[]{
                    room.getRoomNumber(),
                    room.getType(),
                    room.getPrice(),
                    room.isAvailable() ? "Yes" : "No"
            });
        }
    }
}