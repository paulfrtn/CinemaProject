package View.BorderRadCompenent;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * La classe BorderRadButton crée un JButton avec une bordure arrondie.
 */
public class BorderRadButton extends JButton {
    private static final long serialVersionUID = 1L;
    private int borderRadius;

    /**
     * Crée un bouton avec une bordure arrondie et du texte.
     * @param text Le texte du bouton.
     * @param rad Le rayon de la bordure arrondie.
     */
    public BorderRadButton(String text, int rad) {
        super(text);
        this.borderRadius = rad;
        setOpaque(false);
        setContentAreaFilled(false);
        setFocusPainted(false);
        setBorderPainted(false);

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                setCursor(new Cursor(Cursor.HAND_CURSOR)); // Changer le curseur en main quand la souris entre
            }

            @Override
            public void mouseExited(MouseEvent e) {
                setCursor(new Cursor(Cursor.DEFAULT_CURSOR)); // Changer le curseur par défaut quand la souris sort
            }
        });
    }

    /**
     * Crée un bouton avec une bordure arrondie sans texte.
     * @param rad Le rayon de la bordure arrondie.
     */
    public BorderRadButton(int rad) {
        this.borderRadius = rad;
        setOpaque(false);
        setContentAreaFilled(false);
        setFocusPainted(false);

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                setCursor(new Cursor(Cursor.HAND_CURSOR)); // Changer le curseur en main quand la souris entre
            }

            @Override
            public void mouseExited(MouseEvent e) {
                setCursor(new Cursor(Cursor.DEFAULT_CURSOR)); // Changer le curseur par défaut quand la souris sort
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(getBackground());
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), borderRadius, borderRadius);
        super.paintComponent(g2);
        g2.dispose();
    }

    @Override
    protected void paintBorder(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(getForeground());
        g2.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, borderRadius, borderRadius);
        g2.dispose();
    }
}
