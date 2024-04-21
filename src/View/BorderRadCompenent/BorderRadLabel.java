package View.BorderRadCompenent;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.RoundRectangle2D;

public class BorderRadLabel extends JLabel {
    private static final long serialVersionUID = 1L;
    private int borderRadius;
    private Color borderColor;

    public BorderRadLabel(ImageIcon icon, int rad) {
        super(icon);
        this.borderRadius = rad;
        setOpaque(false);
    }

    public BorderRadLabel(String string, int rad) {
        super(string);
        this.borderRadius = rad;
        setOpaque(false);
    }

    public BorderRadLabel(ImageIcon icon, int rad, Color color) {
        super(icon);
        this.borderRadius = rad;
        this.borderColor = color;
        setOpaque(false);
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g.create();
        Image img = ((ImageIcon) getIcon()).getImage();
        g2d.setClip(new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), borderRadius, borderRadius));
        g2d.drawImage(img, 0, 0, getWidth(), getHeight(), this);
        g2d.dispose();
    }

    @Override
    protected void paintBorder(Graphics g) {
        Graphics2D g2d = (Graphics2D) g.create();
        g2d.setColor(getForeground());
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.draw(new RoundRectangle2D.Double(0, 0, getWidth() - 1, getHeight() - 1, borderRadius, borderRadius));
        g2d.dispose();
    }
}
