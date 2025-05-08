import java.awt.*;
import javax.swing.*;

public class Sidebar extends JPanel {
    public Sidebar() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setPreferredSize(new Dimension(180, 600));
        setBackground(new Color(230, 230, 250)); // Light purple background
        
        add(Box.createVerticalStrut(20));
        
        // Add all 8 buttons (each from its own class)
        add(new HomeButton());
        add(Box.createVerticalStrut(10));
        add(new RaceButton());
        add(Box.createVerticalStrut(10));
        add(new EPButton());
        add(Box.createVerticalStrut(10));
        add(new SkillsButton());
        add(Box.createVerticalStrut(10));
        add(new EquipmentButton());
        add(Box.createVerticalStrut(10));
        add(new ResidenceButton());
        add(Box.createVerticalStrut(10));
        add(new GalleryButton());
        add(Box.createVerticalStrut(10));
        add(new SettingsButton());
    }
}