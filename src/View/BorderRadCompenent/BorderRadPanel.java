package View.BorderRadCompenent;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.RoundRectangle2D;

public class BorderRadPanel extends JPanel {
    private int borderRadius;

    public BorderRadPanel(int rad) {
        this.borderRadius = rad;
        setOpaque(false); // Rendre le panel transparent
    }
    public BorderRadPanel(LayoutManager layout,int rad) {
        super(layout);
        this.borderRadius = rad;
        setOpaque(false); // Rendre le panel transparent
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g.create();
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setColor(getBackground());
        g2d.fillRoundRect(0, 0, getWidth() - 1, getHeight() - 1, borderRadius, borderRadius);
        g2d.dispose();
    }

    @Override
    protected void paintBorder(Graphics g) {
        super.paintBorder(g);
        Graphics2D g2d = (Graphics2D) g.create();
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, borderRadius, borderRadius);
        g2d.dispose();
    }
}
