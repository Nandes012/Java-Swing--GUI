import java.awt.*;
import java.awt.image.*;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;

public class CharacterCard extends JPanel {
    private String name;
    private String filename;
    private String description;
    private String descriptionType;

    // Constructor for 3 parameters (name, filename, description)
    public CharacterCard(String name, String filename, String description) {
        this(name, filename, description, "equipment"); // Default descriptionType
    }

    // Constructor for 4 parameters (name, filename, description, descriptionType)
    public CharacterCard(String name, String filename, String description, String descriptionType) {
        this.name = name;
        this.filename = filename;
        this.description = description;
        this.descriptionType = descriptionType;

        setLayout(new BorderLayout());
        setBorder(BorderFactory.createLineBorder(Color.GRAY, 4));
        setPreferredSize(new Dimension(220, 400));

        // Load image
        ImagePanel imagePanel = new ImagePanel();
        try {
            BufferedImage originalImage = ImageIO.read(new File("Images/" + filename));
            if (originalImage != null) {
                imagePanel.setImage(originalImage);
            } else {
                throw new IOException("Image is null");
            }
        } catch (IOException e) {
            System.err.println("Failed to load image: " + filename);
            JLabel errorLabel = new JLabel("No Image", SwingConstants.CENTER);
            errorLabel.setForeground(Color.RED);
            imagePanel.setLayout(new BorderLayout());
            imagePanel.add(errorLabel, BorderLayout.CENTER);
        }

        // Name label
        JLabel nameLabel = new JLabel(name, SwingConstants.CENTER);
        nameLabel.setFont(new Font("Arial", Font.BOLD, 14));
        nameLabel.setBorder(BorderFactory.createEmptyBorder(5, 0, 5, 0));

        add(imagePanel, BorderLayout.CENTER);
        add(nameLabel, BorderLayout.SOUTH);

        // Mouse listener for popup
        addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent e) {
                showPopup();
            }
        });
    }

private void showPopup() {
    // Create a panel for the pop-up content
    JPanel popupPanel = new JPanel(new BorderLayout(10, 10));
    popupPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));

    // Add the image to the pop-up
    JLabel imageLabel = new JLabel();
    if (filename != null) {
        try {
            BufferedImage image = ImageIO.read(new File("Images/" + filename));
            ImageIcon icon = new ImageIcon(image.getScaledInstance(120, 180, Image.SCALE_SMOOTH));
            imageLabel.setIcon(icon);
            imageLabel.setHorizontalAlignment(SwingConstants.CENTER);
        } catch (IOException e) {
            imageLabel.setText("No Image Available");
            imageLabel.setHorizontalAlignment(SwingConstants.CENTER);
            imageLabel.setForeground(Color.RED);
        }
    }
    popupPanel.add(imageLabel, BorderLayout.WEST);

    // Add the description to the pop-up
    JPanel textPanel = new JPanel(new BorderLayout());
    textPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

    JLabel nameLabel = new JLabel("Name: " + name);
    nameLabel.setFont(new Font("Arial", Font.BOLD, 16));
    textPanel.add(nameLabel, BorderLayout.NORTH);

    JTextArea descriptionArea = new JTextArea(descriptionType + ": " + description);
    descriptionArea.setEditable(false);
    descriptionArea.setWrapStyleWord(true);
    descriptionArea.setLineWrap(true);
    descriptionArea.setFont(new Font("Arial", Font.PLAIN, 14));
    descriptionArea.setBackground(popupPanel.getBackground());
    textPanel.add(descriptionArea, BorderLayout.CENTER);

    popupPanel.add(textPanel, BorderLayout.CENTER);

    // Show the pop-up
    JOptionPane.showMessageDialog(this, popupPanel, "Character Details", JOptionPane.INFORMATION_MESSAGE);
}
    // ImagePanel class remains the same
    private static class ImagePanel extends JPanel {
        private BufferedImage image;

        public void setImage(BufferedImage image) {
            this.image = image;
            repaint();
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            if (image != null) {
                g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
            }
        }
    }
}