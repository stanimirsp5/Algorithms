package graphs.draw;

import simpleDS.Bag;

import javax.swing.*;

public class MainDraw {
    public static void main(Bag[] args)
    {
        JFrame frame = new JFrame();
        frame.setTitle("Draw String Demo");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.add(new DrawGraph(args));
        frame.pack();
        frame.setSize(620, 620);
        frame.setVisible(true);
    }
}
