#!/usr/bin/env bash
set -euo pipefail
rm -rf build dist/InventoryManager.jar
mkdir -p build dist
javac -encoding UTF-8 -d build Inventory.java
jar --create --file dist/InventoryManager.jar --main-class Inventory -C build .
echo "Build complete: dist/InventoryManager.jar"
