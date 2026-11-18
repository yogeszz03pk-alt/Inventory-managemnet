#!/usr/bin/env bash
set -euo pipefail
if [[ ! -f dist/InventoryManager.jar ]]; then
  ./build.sh
fi
exec java -jar dist/InventoryManager.jar
