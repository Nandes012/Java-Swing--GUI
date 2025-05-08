import java.awt.*;
import javax.swing.*;

public class Header extends JPanel {
    public Header() {
        setLayout(new BorderLayout());
        JLabel title = new JLabel("Tensura Characters List", JLabel.LEFT);
        title.setFont(new Font("Arial", Font.BOLD, 16));
        add(title, BorderLayout.WEST);

        JPanel buttons = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        JButton discordBtn = new JButton("Join Discord");
        discordBtn.setBackground(new Color(88, 101, 242)); // Discord color
        discordBtn.setBorderPainted(false);
        discordBtn.setFocusPainted(false);

        JButton kofiBtn = new JButton("Buy us a Ko-Fi");
        kofiBtn.setBackground(new Color(255, 105, 120)); // Ko-Fi color
        kofiBtn.setBorderPainted(false);
        kofiBtn.setFocusPainted(false);

        buttons.add(discordBtn);
        buttons.add(kofiBtn);
        add(buttons, BorderLayout.EAST);
    }
}