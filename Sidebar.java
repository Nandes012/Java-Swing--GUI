import java.awt.*;
import javax.swing.*;

public class Sidebar extends JPanel {
    public Sidebar(Tensura tensuraFrame) {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setPreferredSize(new Dimension(180, 600));
        setBackground(new Color(230, 230, 250));
        
        add(Box.createVerticalStrut(20));
        
        // Add all buttons with listeners
        HomeButton homeButton = new HomeButton();
        homeButton.addListener(tensuraFrame, "Home");
        add(homeButton);
        
        add(Box.createVerticalStrut(10));
        
        RaceButton raceButton = new RaceButton();
        raceButton.addListener(tensuraFrame, "Race");
        add(raceButton);
        
        add(Box.createVerticalStrut(10));
        
        EPButton epButton = new EPButton();
        epButton.addListener(tensuraFrame, "EP");
        add(epButton);
        
        add(Box.createVerticalStrut(10));
        
        SkillsButton skillsButton = new SkillsButton();
        skillsButton.addListener(tensuraFrame, "Skills");
        add(skillsButton);
        
        add(Box.createVerticalStrut(10));
        
        EquipmentButton equipmentButton = new EquipmentButton();
        equipmentButton.addListener(tensuraFrame, "Equipment");
        add(equipmentButton);
        
        add(Box.createVerticalStrut(10));
        
        ResidenceButton residenceButton = new ResidenceButton();
        residenceButton.addListener(tensuraFrame, "Residence");
        add(residenceButton);
        
        add(Box.createVerticalStrut(10));
        
        GalleryButton galleryButton = new GalleryButton();
        galleryButton.addListener(tensuraFrame, "Gallery");
        add(galleryButton);
        
        add(Box.createVerticalStrut(10));
        
        SettingsButton settingsButton = new SettingsButton();
        settingsButton.addListener(tensuraFrame, "Settings");
        add(settingsButton);
    }
}