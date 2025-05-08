import java.awt.*;
import java.awt.image.*;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;

public class CharacterCard extends JPanel {
    public CharacterCard(String name, String filename) {
        setLayout(new BorderLayout());
        setBorder(BorderFactory.createLineBorder(Color.GRAY, 4));
        setPreferredSize(new Dimension(220, 400));

        // Use ImagePanel directly
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
    }

    // Fully implement the ImagePanel class
    private static class ImagePanel extends JPanel {
        private Image image;

        public void setImage(Image img) {
            this.image = img;
            repaint();
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            if (image != null) {
                int panelWidth = getWidth();
                int panelHeight = getHeight();

                double imgRatio = (double) image.getWidth(null) / image.getHeight(null);
                double panelRatio = (double) panelWidth / panelHeight;

                int width, height;
                if (panelRatio > imgRatio) {
                    height = panelHeight;
                    width = (int) (height * imgRatio);
                } else {
                    width = panelWidth;
                    height = (int) (width / imgRatio);
                }

                int x = (panelWidth - width) / 2;
                int y = (panelHeight - height) / 2;

                Graphics2D g2d = (Graphics2D) g;
                g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
                g2d.drawImage(image, x, y, width, height, null);
            }
        }
    }
}