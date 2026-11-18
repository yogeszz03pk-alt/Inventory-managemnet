# Inventory Manager

A clean, practical desktop application for managing stock, purchases, and sales — built entirely in **Java Swing** with simple CSV files as the data store.

Whether you're tracking products as an inventory team member, raising purchase orders as a supplier, or placing orders as a customer, everything lives in one familiar desktop window. No database server, no external dependencies, and no internet required after you have a JDK.

This started life as a single large Java file for a lab assessment. It has since been carefully split into focused source files so the models, persistence, business rules, and UI are easier to read, maintain, and explain.

![Inventory Manager dashboard showing live stock threshold warnings](assets/dashboard-stock-alerts.png)

## What you can do

### Inventory & Seller workspace
- See a live dashboard with product counts, units on hand, stock value, recent sales, and activity.
- Add, edit, search, import, and export products via CSV.
- Record sales (with discounts and payment methods), process returns (optionally restocking items), and adjust stock after a physical count.
- Review sales, purchases, refunds, and estimated gross profit.

### Supplier workspace
- Maintain supplier records.
- Create purchase orders and track their status.
- Record full or partial deliveries.
- Review restock requests that were raised when customer orders could not be fulfilled from existing stock.

### Customer workspace
- Register and sign in to a personal account.
- Browse available products and place orders.
- Follow the status of your orders and any restock requests.

### Live stock warnings
Every product has a **reorder level**. When available quantity drops to or below that level, the product is flagged. Zero-stock items appear as critical; others at or below the reorder point appear as low stock. The alert count and dashboard warning update automatically after sales, returns, deliveries, adjustments, or CSV imports.

![Customer registration screen](assets/customer-registration.png)

## Built with

- **Java 17+**
- Java Swing & AWT for the desktop interface
- Standard Java I/O and NIO for CSV persistence
- Built-in Java cryptography APIs for salted password hashing
- Java2D for icons and the small charts

There are **no third-party libraries**. You do not need Maven, Gradle, or a database server.

## Getting started

Install a JDK 17 or later, clone this repository, and open a terminal in the project folder.

### Quick compile and run

```bash
javac -encoding UTF-8 Inventory.java
java Inventory
```

The compiler pulls in the other source files automatically. Use `java Inventory` (not `java Inventory.java`).

### Build a runnable JAR

**Windows**
```bat
build.bat
run.bat
```

**Linux / macOS**
```bash
chmod +x build.sh run.sh
./build.sh
./run.sh
```

The build produces `dist/InventoryManager.jar`. You can also launch it directly:

```bash
java -jar dist/InventoryManager.jar
```

## Data storage

On first launch the application creates a `data/` folder next to the program. All records live in simple CSV files:

| File | What it holds |
|------|----------------|
| `products.csv` | Product details, prices, quantities, and reorder levels |
| `suppliers.csv` | Supplier contact information |
| `transactions.csv` | Purchases, sales, returns, and stock adjustments |
| `purchase_orders.csv` | Purchase orders and delivery progress |
| `customers.csv` | Customer accounts and password hashes |
| `customer_orders.csv` | Customer orders and their status |
| `restock_requests.csv` | Requests raised when stock was insufficient |
| `role_accounts.csv` | Inventory/seller and supplier login records |

Keep the `data/` folder if you want to preserve records between runs. Back it up before editing CSV files by hand. The application checks headers and reports invalid rows instead of silently accepting bad data.

## First-time staff accounts

If no staff accounts exist yet, the application creates these local starter logins:

| Workspace | Username | Initial password |
|-----------|----------|------------------|
| Inventory / Seller | `seller` | `Seller@123` |
| Supplier | `supplier` | `Supplier@123` |

These are for demonstration and lab use only. Change them before using the application with real data. Customers create their own accounts through the registration screen.

## Project layout

All production `.java` files sit in the repository root and use the default package, so the compile command stays simple.

- `Inventory.java` — entry point
- Domain models: `Product.java`, `Supplier.java`, `PurchaseOrder.java`, `TransactionRecord.java`, …
- Persistence: `CsvUtil.java`, `CsvDatabase.java`, `FileReplacer.java`
- Business rules: `InventoryService.java`
- Accounts: `CustomerDataStore.java`, `RoleAuthStore.java`
- UI: `MainFrame.java`, the various `*Panel.java` files, `UiTheme.java`, `AppIcon.java`
- Stock alerts: `StockAlertBanner.java`, `StockAlertDialog.java`
- `qa/` — smoke tests for core workflows and the GUI
- `dist/` — pre-built runnable JAR

Each production source file is kept under 500 lines. `SOURCE_MAP.txt` and `SOURCE_LINE_COUNTS.txt` give a quick overview of the split.

## Running the smoke tests

```bash
mkdir -p build
javac -encoding UTF-8 -d build Inventory.java
javac -encoding UTF-8 -cp build -d build qa/InventorySmokeTest.java qa/GuiSmokeTest.java
```

Business-logic checks:
```bash
java -cp build InventorySmokeTest
```

GUI smoke test (needs a desktop):
```bash
java -cp build GuiSmokeTest
```

On a headless machine you can use a virtual display, for example:
```bash
xvfb-run -a java -cp build GuiSmokeTest
```

## Scope

This is a local desktop application intended for learning, demonstration, and small-scale practice. Data stays on the machine that runs the program. It is not a multi-user cloud service. Treat the starter credentials as demo-only and do not enter real customer information without adding the appropriate access controls, backups, and operational safeguards.

---

Built as a practical Java Swing + CSV inventory system. Feel free to explore the source, run the tests, or adapt it for your own small-scale needs.
