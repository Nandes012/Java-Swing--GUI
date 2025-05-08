import java.awt.*;
import javax.swing.*;

public class Tensura extends JFrame {
    public Tensura() {
        setTitle("Tensura Characters List");
        setSize(1000, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        add(new Sidebar(), BorderLayout.WEST);
        add(new Header(), BorderLayout.NORTH);
        add(new CharacterGrid(), BorderLayout.CENTER);

        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Tensura::new);
    }
}
