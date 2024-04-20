package View.BorderRadCompenent;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.RoundRectangle2D;

public class BorderRadPasswordField extends JPasswordField {
    private int borderRadius;

    public BorderRadPasswordField( int borderRadius) {
        this.borderRadius = borderRadius;
        setOpaque(false); // Rendre le champ de texte transparent
    }

    public void setBorderRadius(int borderRadius) {
        this.borderRadius = borderRadius;
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(getBackground());
        g2.fill(new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), borderRadius, borderRadius));
        super.paintComponent(g2);
        g2.dispose();
    }

    @Override
    protected void paintBorder(Graphics g) {
        // Pas de bordure
    }
}
