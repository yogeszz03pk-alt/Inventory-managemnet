public final class Product {
    private final String id;
    private String name;
    private String category;
    private double unitPrice;
    private int quantity;
    private int reorderLevel;
    private String supplierId;
    private String description;
    private String artwork;

    public Product(String id, String name, String category, double unitPrice,
                   int quantity, int reorderLevel, String supplierId,
                   String description, String artwork) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.unitPrice = unitPrice;
        this.quantity = quantity;
        this.reorderLevel = reorderLevel;
        this.supplierId = supplierId;
        this.description = description;
        this.artwork = artwork;
    }

    public String getId() { return id; }
    public String getName() { return name; }
    public String getCategory() { return category; }
    public double getUnitPrice() { return unitPrice; }
    public int getQuantity() { return quantity; }
    public int getReorderLevel() { return reorderLevel; }
    public String getSupplierId() { return supplierId; }
    public String getDescription() { return description; }
    public String getArtwork() { return artwork; }

    public void setName(String name) { this.name = name; }
    public void setCategory(String category) { this.category = category; }
    public void setUnitPrice(double unitPrice) { this.unitPrice = unitPrice; }
    public void setQuantity(int quantity) { this.quantity = quantity; }
    public void setReorderLevel(int reorderLevel) { this.reorderLevel = reorderLevel; }
    public void setSupplierId(String supplierId) { this.supplierId = supplierId; }
    public void setDescription(String description) { this.description = description; }
    public void setArtwork(String artwork) { this.artwork = artwork; }

    public boolean isLowStock() {
        return quantity > 0 && quantity <= reorderLevel;
    }

    public boolean isOutOfStock() {
        return quantity <= 0;
    }
}
