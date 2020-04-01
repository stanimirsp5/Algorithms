package graphs.draw;

import java.awt.*;
        import java.awt.image.BufferedImage;
        import javax.swing.*;

public class DrawNodes extends JPanel
{

    public DrawNodes() {

    }
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
    }

    public static void main(String[] args)
    {
        int vertexes = 0;
        // Change this next part later to be dynamic.
        vertexes = 10;
        int canvasSize = vertexes * vertexes;

        JFrame frame = new JFrame();
        JLabel label = new JLabel();
        BufferedImage bImage = new BufferedImage(canvasSize, canvasSize, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = bImage.createGraphics();
        g2d.drawLine(50, 50, 300, 300);
        ImageIcon iIcon = new ImageIcon(bImage);
        label.setIcon(iIcon);
        frame.add(label);
        frame.setSize(600, 600);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        g2d = drawNode(1,1,g2d);
        label.repaint();
    }

    public static Graphics2D drawNode(int x, int y,Graphics2D g2d)
    {
        // Treat each location as a 10x10 block. If position 1,1 then go to (5,5) - If position 3,5 then go to (25, 45) eg: (x*10)-5, (y*10)-5
        int xLoc = (x*10) - 5;
        int yLoc = (y*10) - 5;
        g2d.setColor(Color.white);
        g2d.fillOval(xLoc, yLoc, 8, 8);
        g2d.drawOval(xLoc, yLoc, 8, 8);
        return g2d;
    }
    public static void drawArc(int x, int y, int xx, int yy)
    {
        int xLoc = (x*10) - 5;
        int yLoc = (y*10) - 5;
        int xxLoc = (xx*10) - 5;
        int yyLoc = (yy*10) - 5;
        // g.drawLine(xLoc, yLoc, xxLoc, yyLoc);
    }

}