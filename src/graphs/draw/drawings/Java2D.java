package graphs.draw.drawings;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;
import java.util.HashMap;
import java.util.Random;

public class Java2D extends JPanel{
    @Override
    public void paint(Graphics g){
//        drawShape(g);
        drawPolyline(g);
//        drawLine(g);
//        roundRectangle(g);
    }
//    public void drawLine(Graphics g){
//        Graphics2D g2 = (Graphics2D) g;
//        int x2Points[] = {0, 100, 0, 100};
//        int y2Points[] = {0, 50, 50, 0};
//
//        Line2D line = new Line2D.Float(point1, point2);
//line.co
//        polyline.moveTo (x2Points[0], y2Points[0]);
//
//        for (int index = 1; index < x2Points.length; index++) {
//            polyline.lineTo(x2Points[index], y2Points[index]);
//        };
//
//        g2.draw(polyline);
//    }
    public void drawVertex(Graphics g, HashMap<Integer, Integer[]> verticesCoordinates, int i){
        Random rand = new Random();
        int x = rand.nextInt(550);
        int y = rand.nextInt(550);
        verticesCoordinates.put(i, new Integer[]{x, y});
       g.drawOval(x, y, 10, 10);

       g.drawString(Integer.toString(i),x,y);
    } 
    public void drawEdges(Graphics g, HashMap<Integer, Integer[]> verticesCoordinates, int fromVertex, int toVertex){
        Graphics2D g2 = (Graphics2D) g;
        int x1 = verticesCoordinates.get(fromVertex)[0];
        int y1 = verticesCoordinates.get(fromVertex)[1];

        int x2 = verticesCoordinates.get(toVertex)[0];
        int y2 = verticesCoordinates.get(toVertex)[1];
        g2.draw(new Line2D.Double(x1, y1, x2, y2));
    }
    public void drawPolyline(Graphics g){
        int[][] graph = {{0}, {1,2}, {1},{0,4},{2},{0},{3},{4},{4},{3,1}};
        int numberOfVertices = graph.length/2;
        HashMap<Integer, Integer[]> verticesCoordinates = new HashMap<Integer, Integer[]>();
        for (int i = 0; i < numberOfVertices; i++) {
            drawVertex(g,verticesCoordinates, i);
        }
        
        for (int i = 0; i < numberOfVertices; i++) {
            for (int j = 1; j < graph[i].length; j+=2) {
                drawEdges(g,verticesCoordinates, i, graph[i][j]);
            }
        }


//        int x2Points[] = {20, 50, 300, 150, 200};
//        int y2Points[] = {20, 20, 100, 150, 200};
//        int V = 5;
//        g.drawOval(20, 20, 10, 10); //0
//        g.drawOval(50, 20, 10, 10); //1
//        g.drawOval(70, 50, 10, 10); //4
//        g.drawOval(20, 80, 10, 10); //2
//        g.drawOval(50, 80, 10, 10); //3
//
//        g2.draw(new Line2D.Double(20, 20, 50, 20)); // 0 -1
//        g2.draw(new Line2D.Double(20, 20, 20, 80)); // 0 -2
//        g2.draw(new Line2D.Double(50, 20, 70, 50)); // 1 -4
//        g2.draw(new Line2D.Double(50, 80, 70, 50)); // 3 -4
//        g2.draw(new Line2D.Double(50, 80, 20, 20)); // 3 -0


//        GeneralPath polyline =
//                new GeneralPath(GeneralPath.WIND_EVEN_ODD, x2Points.length);
//
//        polyline.moveTo(x2Points[0], y2Points[0]);
//        for (int index = 1; index < x2Points.length; index++) {
//            polyline.lineTo(x2Points[index], y2Points[index]);
//        };
//        g2.draw(polyline);
    }
    public void roundRectangle(Graphics g){
        Graphics2D g2 = (Graphics2D) g;

        final float[] dash1 = {10.0f};
        final BasicStroke dashed =
                new BasicStroke(1.0f,
                        BasicStroke.CAP_ROUND,
                        BasicStroke.JOIN_MITER,
                        10.0f, dash1, 0.0f);
        g2.setStroke(dashed);
        g2.draw(new RoundRectangle2D.Double(50, 100,
                200,
                250,
                10, 10));
    }

    public void drawShape(Graphics g) {
    Graphics2D g2 = (Graphics2D) g;
    // Draw Hello World String
    g2.drawString("Hello W11orld!", 50, 100);
    // (x1, y1) is the start point of the line, and (x2, y2) is the end point of the line.
    g2.draw(new Line2D.Double(300, 300, 30, 40));
    g2.draw(new Line2D.Double(30, 40,500, 40 ));
    g2.draw(new Line2D.Double(500, 40,300, 300));

    //        setLocation(double x, double y) – To set the location of the point- defining coordinates as double values.
    //        setLocation(Point2D p) – To set the location of the point using the coordinates of another point.
    Point2D point1 = new Point2D.Float();
    point1.setLocation(500, 550);
    Point2D point2 = new Point2D.Float(400, 450);
    Line2D L2D = new Line2D.Float(point1, point2);
    //Rectangle2D.Double rect = new Rectangle2D.Double(point1.getX(), point1.getY() , 4, 4);
    g2.draw(L2D);
}

    public static void main(String[] args)
    {
        JFrame frame = new JFrame();
        frame.setTitle("Draw String Demo");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.add(new Java2D());
        frame.pack();
        frame.setSize(620, 620);
        frame.setVisible(true);
    }


}
