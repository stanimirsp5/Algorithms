package sorting.convexHull;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Line2D;
import java.util.*;
import java.util.List;

public class ConvexHullDemo {
    static class Point {
        public Point(double x, double y) {
            this.x = x;
            this.y = y;
        }
        double x, y;

        //formula from geometry course
        static int ccw(Point a, Point b, Point c) {
            double area = (b.x - a.x) * (c.y - a.y) - (b.y - a.y) * (c.x - a.x);
            if(area < 0) return -1;
            if(area > 0) return 1;  //counter clockwise
            else return 0;
        }

        public final Comparator<Point> POLAR_ORDER = new PolarOrder();

        private class PolarOrder implements Comparator<Point> {
            public int compare(Point q1, Point q2) {
                double dx1 = q1.x - x;
                double dy1 = q1.y - y;
                double dx2 = q2.x - x;
                double dy2 = q2.y - y;

                if      (dy1 >= 0 && dy2 < 0) return -1;    // q1 above; q2 below
                else if (dy2 >= 0 && dy1 < 0) return +1;    // q1 below; q2 above
                else if (dy1 == 0 && dy2 == 0) {            // 3-collinear and horizontal
                    if      (dx1 >= 0 && dx2 < 0) return -1;
                    else if (dx2 >= 0 && dx1 < 0) return +1;
                    else                          return  0;
                }
                else return -ccw(Point.this, q1, q2);     // both above or below

            }
        }

        @Override
        public String toString() {
            return "(" + x + "," + y + ")";
        }
    }

    private static List<Point> points = new ArrayList<>();
    private static final int N = 300;
    private static final double Max = 300;

    public static void main(String...args) {
        Random r = new Random();
        for(int i = 0; i < N; i++) {
            points.add(new Point(r.nextDouble() * Max, r.nextDouble() * Max));
        }

        Collections.sort(points, (p1, p2) -> (int)(p1.y - p2.y));
        Collections.sort(points, points.get(0).POLAR_ORDER);

        Deque<Point> hull = new ArrayDeque<>();
        hull.push(points.get(0));
        hull.push(points.get(1));
        for(int i = 2; i < points.size(); i++) {
            Point top = hull.pop();
            Point c = points.get(i);
            while(Point.ccw(hull.peek(), top, c) <= 0) {
                top = hull.pop();
            }
            hull.push(top);
            hull.push(c);
        }

        myDraw(new PolarDraw(points.get(0), points, hull));


    }

    static void myDraw(JPanel jpanel) {
        JFrame frame = new JFrame("Points");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(jpanel);
        frame.setSize((int)(Max * 2), (int)(Max * 1.5));
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    static class PolarDraw extends JPanel {
        private Point origin;
        private List<Point> points;
        private Deque<Point> hull;
        public PolarDraw(Point origin, List<Point> points, Deque<Point> hull) {
            this.origin = origin;
            this.points = points;
            this.hull = hull;
        }
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g;
            g2d.setColor(Color.red);
            int i = 0;
            for (Point p: points) {
                g2d.draw(new Line2D.Double(origin.x, origin.y, p.x, p.y));
                g2d.drawString("" + (i++), (int)p.x, (int)p.y);
            }

            g2d.setColor(Color.blue);
            Point p0 = hull.poll();
            Point p;
            while((p = hull.poll()) != null) {
                g2d.draw(new Line2D.Double(p0.x, p0.y, p.x, p.y));
                p0 = p;
            }
        }
    }

}