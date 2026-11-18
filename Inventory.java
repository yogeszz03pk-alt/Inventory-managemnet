import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.nio.charset.*;
import java.nio.file.*;
import java.security.*;
import java.text.*;
import java.time.*;
import java.time.format.*;
import java.util.*;
import java.util.List;
import javax.crypto.*;
import javax.crypto.spec.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.plaf.basic.*;
import javax.swing.table.*;

public final class Inventory {
    private Inventory() { }

    public static void main(String[] args) {
        UiTheme.apply();
        SwingUtilities.invokeLater(Inventory::launch);
    }

    private static void launch() {
        try {
            Path data = Path.of("data");
            CsvDatabase database = new CsvDatabase(data);
            InventoryService service = new InventoryService(database);
            CustomerDataStore customers = new CustomerDataStore(data);
            RoleAuthStore roles = new RoleAuthStore(data);
            customers.fulfillPendingOrders(service);
            new MainFrame(service, customers, roles).setVisible(true);
        } catch (IOException | RuntimeException exception) {
            String detail = exception.getMessage() == null ? exception.toString() : exception.getMessage();
            JOptionPane.showMessageDialog(null,
                    "The inventory application could not load its data.\n\n" + detail
                            + "\n\nCheck the CSV files in the data folder and restart.",
                    "Unable to start", JOptionPane.ERROR_MESSAGE);
        }
    }
}
