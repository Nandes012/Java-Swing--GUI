import java.awt.*;
import javax.swing.*;

public class Tensura extends JFrame {
    private final JPanel cardPanel;
    private final CardLayout cardLayout;

    public Tensura() {
        setTitle("Tensura Characters List");
        setSize(1000, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        cardLayout = new CardLayout();
        cardPanel = new JPanel(cardLayout);

        // Add all your panels here
        cardPanel.add(new CharacterGrid(), "Home");
        cardPanel.add(new RacePanel(), "Race"); // Placeholder - replace with actual panel
        cardPanel.add(new EPPanel(), "EP"); // Placeholder
        cardPanel.add(new SkillsPanel(), "Skills"); // Placeholder
        cardPanel.add(new EquipmentPanel(), "Equipment");
        cardPanel.add(new ResidencePanel(), "Residence"); // Placeholder
        cardPanel.add(new JPanel(), "Gallery"); // Placeholder
        cardPanel.add(new JPanel(), "Settings"); // Placeholder

        add(new Sidebar(this), BorderLayout.WEST);
        add(new Header(), BorderLayout.NORTH);
        add(cardPanel, BorderLayout.CENTER);

        setVisible(true);
    }

    public void showPage(String name) {
        cardLayout.show(cardPanel, name);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Tensura::new);
    }
}