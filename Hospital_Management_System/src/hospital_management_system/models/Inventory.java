public class Inventory {
    private String inventoryID;
    private String itemName;
    private String itemCode;
    private String supplierInformation;
    private int stockQuantity;
    private int minimumStock;
    private int maximumStock;
    private String expiryDate;

    // Constructor
    public Inventory(
        String inventoryID, 
        String itemName, 
        String itemCode, 
        String supplierInformation, 
        int stockQuantity, 
        int minimumStock, 
        int maximumStock, 
        String expiryDate
    ) {
        this.inventoryID = inventoryID;
        this.itemName = itemName;
        this.itemCode = itemCode;
        this.supplierInformation = supplierInformation;
        this.stockQuantity = stockQuantity;
        this.minimumStock = minimumStock;
        this.maximumStock = maximumStock;
        this.expiryDate = expiryDate;
    }
    
    // Method to save inventory to the database
    public void save() {
        // Implement database save logic here
        System.out.println("Saving inventory to the database...");
        // For example, execute SQL insert statement
    }

    // Method to clear all fields
    public void clear() {
        inventoryID = "";
        itemName = "";
        itemCode = "";
        supplierInformation = "";
        stockQuantity = 0;
        minimumStock = 0;
        maximumStock = 0;
        expiryDate = null;
    }

    // Getters and Setters
    public String getInventoryID() { return inventoryID; }
    public void setInventoryID(String inventoryID) { this.inventoryID = inventoryID; }

    public String getItemName() { return itemName; }
    public void setItemName(String itemName) { this.itemName = itemName; }

    public String getItemCode() { return itemCode; }
    public void setItemCode(String itemCode) { this.itemCode = itemCode; }

    public String getSupplierInformation() { return supplierInformation; }
    public void setSupplierInformation(String supplierInformation) { this.supplierInformation = supplierInformation; }

    public int getStockQuantity() { return stockQuantity; }
    public void setStockQuantity(int stockQuantity) { this.stockQuantity = stockQuantity; }

    public int getMinimumStock() { return minimumStock; }
    public void setMinimumStock(int minimumStock) { this.minimumStock = minimumStock; }

    public int getMaximumStock() { return maximumStock; }
    public void setMaximumStock(int maximumStock) { this.maximumStock = maximumStock; }

    public Date getExpiryDate() { return expiryDate; }
    public void setExpiryDate(Date expiryDate) { this.expiryDate = expiryDate; }
}
