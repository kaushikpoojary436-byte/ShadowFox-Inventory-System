import java.awt.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class InventoryGUI extends JFrame {

    JTable table;
    DefaultTableModel model;

    JTextField itemField;
    JTextField quantityField;
    JTextField priceField;

    public InventoryGUI() {

        setTitle("Inventory Management System");
        setSize(700, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Input Panel
        JPanel panel = new JPanel(new GridLayout(4, 2, 10, 10));

        panel.add(new JLabel("Item Name:"));
        itemField = new JTextField();
        panel.add(itemField);

        panel.add(new JLabel("Quantity:"));
        quantityField = new JTextField();
        panel.add(quantityField);

        panel.add(new JLabel("Price:"));
        priceField = new JTextField();
        panel.add(priceField);

        JButton addButton = new JButton("Add Item");
        panel.add(addButton);

        JButton deleteButton = new JButton("Delete Item");
        panel.add(deleteButton);

        add(panel, BorderLayout.NORTH);

        // Table
        String[] columns = {"Item Name", "Quantity", "Price"};

        model = new DefaultTableModel(columns, 0);

        table = new JTable(model);

        JScrollPane scrollPane = new JScrollPane(table);

        add(scrollPane, BorderLayout.CENTER);

        // Add Button Action
        addButton.addActionListener(e -> {

            String item = itemField.getText();
            String quantity = quantityField.getText();
            String price = priceField.getText();

            if (item.isEmpty() || quantity.isEmpty() || price.isEmpty()) {

                JOptionPane.showMessageDialog(this,
                        "Please Fill All Fields");

            } else {

                model.addRow(new Object[]{item, quantity, price});

                itemField.setText("");
                quantityField.setText("");
                priceField.setText("");
            }
        });

        // Delete Button Action
        deleteButton.addActionListener(e -> {

            int selectedRow = table.getSelectedRow();

            if (selectedRow != -1) {

                model.removeRow(selectedRow);

            } else {

                JOptionPane.showMessageDialog(this,
                        "Select Row To Delete");
            }
        });
    }

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {

            new InventoryGUI().setVisible(true);
        });
    }
}
