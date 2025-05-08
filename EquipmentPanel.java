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
        addWeaponCard(gridPanel, "Draconic Sword", "sword_light.jpg");
        addWeaponCard(gridPanel, "Scissors", "demon_blade.jpg");
        addWeaponCard(gridPanel, "Moon Mistress", "phoenix_bow.jpg");
        addWeaponCard(gridPanel, "Stygian Voidlash", "dragon_slayer.jpg");
        addWeaponCard(gridPanel, "Staff of Wisdom", "staff_wisdom.jpg");
        addWeaponCard(gridPanel, "Assassin Dagger", "assassin_dagger.jpg");
        addWeaponCard(gridPanel, "Holy Mace", "holy_mace.jpg");
        addWeaponCard(gridPanel, "Frost Axe", "frost_axe.jpg");
        addWeaponCard(gridPanel, "Thunder Hammer", "thunder_hammer.jpg");
        addWeaponCard(gridPanel, "Void Scythe", "void_scythe.jpg");
        addWeaponCard(gridPanel, "Sun Spear", "sun_spear.jpg");
        addWeaponCard(gridPanel, "Moon Katana", "moon_katana.jpg");
        addWeaponCard(gridPanel, "Blood Whip", "blood_whip.jpg");
        addWeaponCard(gridPanel, "Titan Gauntlets", "titan_gauntlets.jpg");
        addWeaponCard(gridPanel, "Necro Tome", "necro_tome.jpg");
        
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
    
    private void addWeaponCard(JPanel panel, String name, String filename) {
        panel.add(new CharacterCard(name, filename));
    }
}