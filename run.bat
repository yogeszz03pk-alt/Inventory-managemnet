@echo off
if not exist dist\InventoryManager.jar call build.bat
java -jar dist\InventoryManager.jar
