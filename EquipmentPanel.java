import java.awt.*;
import javax.swing.*;

public class EquipmentPanel extends JPanel {
    public EquipmentPanel() {
        setLayout(new GridBagLayout());
        setBackground(new Color(245, 245, 245));
        
        JPanel gridPanel = new JPanel(new GridLayout(4, 4, 15, 15));
        gridPanel.setOpaque(false);
        gridPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));

        // Add weapon cards
        addCharacterCard(gridPanel, "Drago Blade", "Drago-Blade.jpg");
        addCharacterCard(gridPanel, "Scissors", "Scissors.jpeg");
        addCharacterCard(gridPanel, "Moonlight", "Moonlight.jpg");
        addCharacterCard(gridPanel, "Stygian Voidlash", "Stygian_Voidlash.jpg");
        addCharacterCard(gridPanel, "White Progenitor's Bracelet", "White_Progenitor_Bracelet.jpg");
        addCharacterCard(gridPanel, "Golden Gun", "Golden_Gun.jpeg");
        addCharacterCard(gridPanel, "World", "World.jpg");
        addCharacterCard(gridPanel, "Frost Axe", "frost_axe.jpg");
        addCharacterCard(gridPanel, "Thunder Hammer", "thunder_hammer.jpg");
        addCharacterCard(gridPanel, "Void Scythe", "void_scythe.jpg");
        addCharacterCard(gridPanel, "Sun Spear", "sun_spear.jpg");
        addCharacterCard(gridPanel, "Moon Katana", "moon_katana.jpg");
        addCharacterCard(gridPanel, "Blood Whip", "blood_whip.jpg");
        addCharacterCard(gridPanel, "Titan Gauntlets", "titan_gauntlets.jpg");
        addCharacterCard(gridPanel, "Necro Tome", "necro_tome.jpg");
        
        // Empty panel for the 16th cell
        gridPanel.add(new JPanel());

        JScrollPane scrollPane = new JScrollPane(gridPanel);
        scrollPane.setBorder(null);
        scrollPane.getViewport().setBackground(new Color(245, 245, 245));
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.fill = GridBagConstraints.BOTH;
        add(scrollPane, gbc);
    }
    
    private void addCharacterCard(JPanel panel, String name, String filename) {
        String description = switch (name) {
            case "Draconic Sword" -> "A sword forged from dragon scales.";
            case "Scissors" -> "A pair of scissors with a sharp edge.";
            case "Moon Mistress" -> "A bow that channels lunar energy.";
            case "Stygian Voidlash" -> "A whip that can cut through darkness.";
            case "Staff of Wisdom" -> "A staff that enhances magical abilities.";
            default-> "Unknown Weapon";
        };
        panel.add(new CharacterCard(name, filename, description, "Equipment"));
    }
}