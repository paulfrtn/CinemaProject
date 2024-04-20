package View.BorderRadCompenent;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;

public class RoundButton extends JButton {
    public RoundButton(String label) {
        super(label);
        setContentAreaFilled(false); // On ne remplit pas le contenu par défaut
        setFocusPainted(false); // Ne pas dessiner l'anneau de focus
        setBorderPainted(false); // Ne pas peindre la bordure standard
    }

    @Override
    protected void paintComponent(Graphics g) {
        if (getModel().isArmed()) {
            g.setColor(Color.lightGray); // Couleur quand le bouton est pressé
        } else {
            g.setColor(getBackground()); // Couleur normale du fond
        }
        Graphics2D g2 = (Graphics2D) g;
        g2.fill(new Ellipse2D.Double(0, 0, getSize().width-1, getSize().height-1));
        super.paintComponent(g);
    }

    @Override
    protected void paintBorder(Graphics g) {
        g.setColor(getForeground());
        Graphics2D g2 = (Graphics2D) g;
        g2.draw(new Ellipse2D.Double(0, 0, getSize().width-1, getSize().height-1));
    }

    @Override
    public boolean contains(int x, int y) {
        Shape shape = new Ellipse2D.Double(0, 0, getWidth(), getHeight());
        return shape.contains(x, y);
    }
}
