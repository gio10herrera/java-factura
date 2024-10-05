package invoiceapp;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class Invoice {
    static String customerName;
    static String[] productName = new String[3];
    static double[] unitPriceProduct  = new double[3];
    static int[] quantityPerProduct = new int[3];
    static double[] totalPerProduct = new double[3];
    static double totalToPay = 0;

    public static void main(String[] args) {
        inputInvoiceData();
        calculateTotalPerProduct();
        calculateTotalToPay();
        showResults();
    }

    private static void calculateTotalToPay() {
        for (int i = 0; i < 3; i++) {
            totalToPay += totalPerProduct[i];
        }
    }

    private static void showResults() {
        JTextArea textArea = new JTextArea();
        String result = "PURCHASE ORDER\n\nCustomer: " + customerName + "\n\nProduct\t\tUnit Price\t\tQuantity\t\tTotal per Product\n";
        for (int i = 0; i < 3; i++) {
            result += productName[i] + "\t\t" + unitPriceProduct[i] + "\t\t" + quantityPerProduct[i] + "\t\t" + totalPerProduct[i] + "\n";
        }
        result += "\n\t\t\t\t\t\tTotal to pay: " + totalToPay + "\n\n\nMr./Ms " + customerName.toUpperCase() + " the total of your purchase is: " + totalToPay + "\n\n";
        
        //JTextArea Configuration
        textArea.setEditable(false);
        textArea.setSize(720, 400);
        textArea.setBorder(new EmptyBorder(5, 5, 5, 5));
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setText(result);
        JOptionPane.showMessageDialog(null, textArea, "Invoice", JOptionPane.INFORMATION_MESSAGE);
    }

    private static void calculateTotalPerProduct() {
        for (int i = 0; i < 3; i++) {
            totalPerProduct[i] = (unitPriceProduct[i] * quantityPerProduct[i]);
        }
    }

    private static void inputInvoiceData() {
        customerName = JOptionPane.showInputDialog(null, "Enter customer name: ", "Full name", JOptionPane.INFORMATION_MESSAGE);
        for (int i = 0; i < 3; i++) {
            productName[i] = JOptionPane.showInputDialog(null, "Enter product name: " + (i + 1), "Product name", JOptionPane.INFORMATION_MESSAGE);
            unitPriceProduct[i] = Double.parseDouble(JOptionPane.showInputDialog(null, "Enter unit price product " + (i + 1), "Unit price product", JOptionPane.INFORMATION_MESSAGE));
            quantityPerProduct[i] = Integer.parseInt(JOptionPane.showInputDialog(null, "Quantity of product " + (i + 1), "Quantity per product", JOptionPane.INFORMATION_MESSAGE));
        }
    }

}
