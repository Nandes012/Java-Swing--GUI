import java.awt.*;
import javax.swing.*;

public class EquipmentButton extends JButton {
    public EquipmentButton() {
        super("Equipment");
        configureButton();
    }

    private void configureButton() {
        setAlignmentX(Component.CENTER_ALIGNMENT);
        setMaximumSize(new Dimension(160, 40));
        setFont(new Font("Arial", Font.PLAIN, 14));
        setFocusPainted(false);
        setBorderPainted(false);
        setBackground(new Color(200, 200, 220));
    }
}