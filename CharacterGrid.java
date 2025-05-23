// CharacterGrid.java - Improved with scroll pane and better spacing
import java.awt.*;
import javax.swing.*;

public class CharacterGrid extends JPanel {
    public CharacterGrid() {
        setLayout(new GridBagLayout());
        setBackground(new Color(245, 245, 245));
        
        JPanel gridPanel = new JPanel(new GridLayout(4, 4, 15, 15));
        gridPanel.setOpaque(false);
        gridPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));

        // Add character cards
        addCharacterCard(gridPanel, "Rimuru Tempest", "Rimuru.jpg");
        addCharacterCard(gridPanel, "Ciel", "Ciel.jpg");
        addCharacterCard(gridPanel, "Chloe", "Chloe.jpg");
        addCharacterCard(gridPanel, "Diablo", "Diablo.jpg");
        addCharacterCard(gridPanel, "Ultima", "Ultima.jpg");
        addCharacterCard(gridPanel, "Testarossa", "Testarossa.jpg");
        addCharacterCard(gridPanel, "Carrera", "Carrera.jpg");
        addCharacterCard(gridPanel, "Guy", "Guy.jpg");
        addCharacterCard(gridPanel, "Velzard", "Velzard.jpg");
        addCharacterCard(gridPanel, "Veldora", "Veldora.jpg");
        addCharacterCard(gridPanel, "Zegion", "Zegion.jpg");
        addCharacterCard(gridPanel, "Milim", "Milim.jpg");
        addCharacterCard(gridPanel, "Shuna", "Shuna.jpg");
        addCharacterCard(gridPanel, "Luminous", "Luminous.jpg");
        addCharacterCard(gridPanel, "Benimaru", "Benimaru.jpg");
        
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
            case "Rimuru Tempest" -> "Not a bad slime";
            case "Ciel" -> "Rimuru's 'Wife' Partner";
            case "Chloe" -> "Would go through countless loops to save Rimuru";
            case "Diablo" -> "Very loyal and fanatical to Rimuru";
            case "Ultima" -> "Loyal to Rimuru";
            case "Testarossa" -> "Loyal to Rimuru";
            case "Carrera" -> "Loyal to Rimuru";
            case "Guy" -> "Very powerful and prideful, strongest demon lord in the anime";
            case "Velzard" -> "Very powerful and sister of veldora, discipline veldora with violence";
            case "Veldora" -> "Very powerful and brother of Velzard, loves to read manga, afraid of his sisters";
            case "Zegion" -> "Loyal to Rimuru, have Rimuru's cell in his body";
            case "Milim" -> "Very powerful, loves to fight, very childish, BFF with Rimuru";
            case "Shuna" -> "Loyal to Rimuru, Very Respected among his friends and colleagues, loves to cook";
            case "Luminous" -> "Powerful, very into woman's body especially Chloe";
            case "Benimaru" -> "Loyal to Rimuru,powerful, loves to fight, skills are connected with sun god amaterasu";            
            default -> "Unknown";
        };
        panel.add(new CharacterCard(name, filename, description,"character"));
    }
}