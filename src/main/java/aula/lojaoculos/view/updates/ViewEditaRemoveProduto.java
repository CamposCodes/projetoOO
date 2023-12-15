import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ViewEditaRemoveProduto extends JFrame {
    private DefaultListModel<String> productListModel;
    private JList<String> productList;
    private JTextField nameText, priceText, descriptionText;
    private JButton editButton, removeButton;

    public ViewEditaRemoveProduto() {
        setTitle("Edit and Remove Products");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        setLayout(null);

        productListModel = new DefaultListModel<>();
        productList = new JList<>(productListModel);
        JScrollPane listScrollPane = new JScrollPane(productList);
        listScrollPane.setBounds(50, 50, 200, 400);
        add(listScrollPane);

        JPanel formPanel = new JPanel();
        formPanel.setLayout(null);
        formPanel.setBounds(280, 50, 450, 400);
        add(formPanel);

        JLabel nameLabel = new JLabel("Name:");
        nameLabel.setBounds(10, 20, 80, 20);
        formPanel.add(nameLabel);

        nameText = new JTextField();
        nameText.setBounds(100, 20, 250, 20);
        formPanel.add(nameText);

        JLabel priceLabel = new JLabel("Price:");
        priceLabel.setBounds(10, 50, 80, 20);
        formPanel.add(priceLabel);

        priceText = new JTextField();
        priceText.setBounds(100, 50, 100, 20);
        formPanel.add(priceText);

        JLabel descriptionLabel = new JLabel("Description:");
        descriptionLabel.setBounds(10, 80, 80, 20);
        formPanel.add(descriptionLabel);

        descriptionText = new JTextField();
        descriptionText.setBounds(100, 80, 300, 20);
        formPanel.add(descriptionText);

        editButton = new JButton("Edit");
        editButton.setBounds(100, 120, 100, 30);
        formPanel.add(editButton);

        removeButton = new JButton("Remove");
        removeButton.setBounds(230, 120, 100, 30);
        formPanel.add(removeButton);

        setVisible(true);
    }
}
