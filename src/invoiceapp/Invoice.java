package invoiceapp;

import javax.swing.*;

public class Invoice {
    static String customerName;
    static String[] productName = new String[3];
    static double[] unitPriceProduct  = new double[3];
    static int[] quantityPerProduct = new int[3];
    static double[] totalPerProduct = new double[3];

    public static void main(String[] args) {
        inputInvoiceData();
    }

    private static void inputInvoiceData() {
        customerName = JOptionPane.showInputDialog(null, "Enter customer name: ", "Full name", JOptionPane.INFORMATION_MESSAGE);
        for (int i = 0; i < 3; i++) {
            productName[i] = JOptionPane.showInputDialog(null, "Enter product name: " + (i + 1), "Product name", JOptionPane.INFORMATION_MESSAGE);
            unitPriceProduct[i] = Double.parseDouble(JOptionPane.showInputDialog(null, "Enter unit price product " + (i + 1), "Unit price product", JOptionPane.INFORMATION_MESSAGE));
            quantityPerProduct[i] = Integer.parseInt(JOptionPane.showInputDialog(null, "Quantity of product" + (i + 1), "Quantity per product", JOptionPane.INFORMATION_MESSAGE));
        }
    }

}
