package View.BorderRadCompenent;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.RoundRectangle2D;

/**
 * La classe BorderRadTextField crée un champ de texte avec une bordure arrondie.
 */
public class BorderRadTextField extends JTextField {
    private int borderRadius;

    /**
     * Crée un champ de texte avec une bordure arrondie.
     *
     * @param borderRadius Le rayon de la bordure arrondie.
     */
    public BorderRadTextField(int borderRadius) {
        this.borderRadius = borderRadius;
        setOpaque(false); // Rendre le champ de texte transparent
    }

    /**
     * Définit le rayon de la bordure arrondie.
     *
     * @param borderRadius Le nouveau rayon de la bordure arrondie.
     */
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
