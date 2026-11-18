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

enum UserRole {
    SELLER("Inventory / Seller"),
    SUPPLIER("Supplier"),
    CUSTOMER("Customer");

    private final String label;

    UserRole(String label) {
        this.label = label;
    }

    String label() {
        return label;
    }
}
