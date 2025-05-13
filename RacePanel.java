// CharacterGrid.java - Improved with scroll pane and better spacing
import java.awt.*;
import javax.swing.*;

public class RacePanel extends JPanel {
    public RacePanel() {
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
            case "Rimuru Tempest" -> "Ultimate Slime";
            case "Ciel" -> "Digital Spirit Lifeform";
            case "Chloe" -> "Divine Human";
            case "Diablo" -> "Primordial Demon(Black), Daemon Lord";
            case "Ultima" -> "Primordial Demon(Violet), Daemon Peer";
            case "Testarossa" -> "Primordial Demon(White), Daemon Peer";
            case "Carrera" -> "Primordial Demon(Yellow), Daemon Peer";
            case "Guy" -> "Primordial Demon(Red),Daemon God";
            case "Velzard" -> "True Dragon, Ice Dragon";
            case "Veldora" -> "True Dragon, Storm Dragon";
            case "Zegion" -> "Insectar";
            case "Milim" -> "Dragonoid, True Demon Lord";
            case "Shuna" -> "Oni";
            case "Luminous" -> "True Demon Lord, Vampire";
            case "Benimaru" -> "Divine Oni";
            default -> "Unknown";
        };
        panel.add(new CharacterCard(name, filename, description, "Race"));
    }
}