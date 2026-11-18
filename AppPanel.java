import javax.swing.*;
import java.awt.*;

public abstract class AppPanel extends JPanel {
    protected final InventoryService service;
    protected final MainFrame frame;

    protected AppPanel(InventoryService service, MainFrame frame) {
        this.service = service;
        this.frame = frame;
        setLayout(new BorderLayout());
        setBackground(UiTheme.PAPER);
    }

    protected void showError(String message) {
        JOptionPane.showMessageDialog(this, message, "Error", JOptionPane.ERROR_MESSAGE);
    }

    protected void showInfo(String message) {
        JOptionPane.showMessageDialog(this, message, "Info", JOptionPane.INFORMATION_MESSAGE);
    }
}
