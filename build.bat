@echo off
rmdir /s /q build 2>nul
del /q dist\InventoryManager.jar 2>nul
mkdir build dist 2>nul
javac -encoding UTF-8 -d build Inventory.java
jar --create --file dist\InventoryManager.jar --main-class Inventory -C build .
echo Build complete: dist\InventoryManager.jar
