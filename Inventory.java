import java.awt.EventQueue;
import java.nio.file.Path;

/**
 * Application entry point.
 */
public final class Inventory {
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            Path dataDir = Path.of("data");
            InventoryService service = new InventoryService(dataDir);
            CustomerDataStore customers = new CustomerDataStore(dataDir);
            RoleAuthStore roles = new RoleAuthStore(dataDir);
            new MainFrame(service, customers, roles).setVisible(true);
        });
    }
}
