package sorting.convexHull.jpanelTest;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Line2D;

public class JPanelView extends JFrame {

    // JFrame
    static JFrame f;

    // JButton
    static JButton b, b1, b2;

    // label to diaplay text
    static JLabel l;

//    public void paint(Graphics g){
//        setSize();
//    }

    // main class
    public static void main(String[] args)
    {
        // create a new frame to store text field and button
        f = new JFrame("panel");

        // create a label to display text
        l = new JLabel("panel label");

        // create a new buttons
        b = new JButton("button1");
        b1 = new JButton("button2");
        b2 = new JButton("button3");


        // create a panel to add buttons
        JPanel p = new JPanel();
//        p = new JPanel() {
//            protected void paintComponent(Graphics g) {
//                super.paintComponent(g);
//                g.drawLine(0,0, 20, 35);
//            };
        // add buttons and textfield to panel
        p.add(b);
        p.add(b1);
        p.add(b2);
        p.add(l);

        // setbackground of panel
        p.setBackground(Color.gray);

        // add panel to frame
        f.add(p);

        // set the size of frame
        f.setSize(300, 300);

        f.show();
    }
}
