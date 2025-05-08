// BaseCard.java
import java.awt.*;
import javax.swing.*;

public abstract class BaseCard extends JPanel {
    protected BaseCard() {
        setLayout(new BorderLayout());
        setBorder(BorderFactory.createLineBorder(Color.GRAY, 4));
        setPreferredSize(new Dimension(220, 400));
    }

    protected void addNameLabel(String name) {
        JLabel nameLabel = new JLabel(name, SwingConstants.CENTER);
        nameLabel.setFont(new Font("Arial", Font.BOLD, 14));
        nameLabel.setBorder(BorderFactory.createEmptyBorder(5, 0, 5, 0));
        add(nameLabel, BorderLayout.SOUTH);
    }
}