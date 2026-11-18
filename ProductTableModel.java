import javax.swing.table.AbstractTableModel;
import java.util.List;
import java.util.ArrayList;

public final class ProductTableModel extends AbstractTableModel {
    private final String[] columns = {"ID", "Name", "Category", "Price", "Qty", "Reorder", "Supplier"};
    private List<Product> products = new ArrayList<>();

    public void setProducts(List<Product> products) {
        this.products = products != null ? products : new ArrayList<>();
        fireTableDataChanged();
    }

    @Override
    public int getRowCount() {
        return products.size();
    }

    @Override
    public int getColumnCount() {
        return columns.length;
    }

    @Override
    public String getColumnName(int column) {
        return columns[column];
    }

    @Override
    public Object getValueAt(int row, int column) {
        Product p = products.get(row);
        return switch (column) {
            case 0 -> p.getId();
            case 1 -> p.getName();
            case 2 -> p.getCategory();
            case 3 -> p.getUnitPrice();
            case 4 -> p.getQuantity();
            case 5 -> p.getReorderLevel();
            case 6 -> p.getSupplierId();
            default -> null;
        };
    }

    public Product getProductAt(int row) {
        return row >= 0 && row < products.size() ? products.get(row) : null;
    }
}
