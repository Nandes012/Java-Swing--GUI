import java.awt.*;
import javax.swing.*;

public abstract class BaseButton extends JButton {
    public BaseButton(String text) {
        super(text);
        setPreferredSize(new Dimension(150, 40));
        setMaximumSize(new Dimension(150, 40));
        setAlignmentX(CENTER_ALIGNMENT);
    }
    
    public void addListener(Tensura tensuraFrame, String cardName) {
        addActionListener(e -> tensuraFrame.showPage(cardName));
    }
}