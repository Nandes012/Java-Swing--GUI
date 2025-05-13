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
        String message;
        switch (descriptionType) {
        case "Equipment":
            message = "Name: " + name + "\nEquipment: " + description;
            break;
        case "Race":
            message = "Name: " + name + "\nRace: " + description;
            break;
        case "EP":
            message = "Name: " + name + "\nEP: " + description;
            break;
        case "Skills":
            message = "Name: " + name + "\nSkills: " + description;
            break;
        case "Residence":
            message = "Name: " + name + "\nResidence: " + description;
            break;
        case "Gallery":
            message = "Name: " + name + "\nGallery: " + description;
            break;
        case "Settings":
            message = "Name: " + name + "\nSettings: " + description;
            break;
        default:
            message = "Name: " + name + "\nCharacter: " + description;
            break;
    }

    JOptionPane.showMessageDialog(this, message, "Details", JOptionPane.INFORMATION_MESSAGE);
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