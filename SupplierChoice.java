import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.nio.charset.*;
import java.nio.file.*;
import java.security.*;
import java.text.*;
import java.time.*;
import java.time.format.*;
import java.util.*;
import java.util.List;
import javax.crypto.*;
import javax.crypto.spec.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.plaf.basic.*;
import javax.swing.table.*;

final class SupplierChoice {
    final Supplier supplier;

    SupplierChoice(Supplier supplier) {
        this.supplier = supplier;
    }

    @Override
    public String toString() {
        return supplier.getName() + " (" + supplier.getId() + ")";
    }
}
