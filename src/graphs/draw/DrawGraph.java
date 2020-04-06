package graphs.draw;

import simpleDS.Bag;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;
import java.util.HashMap;
import java.util.Random;

public class DrawGraph extends JPanel {
    Bag[] adj;
    public DrawGraph(Bag[] args) {
        this.adj = args;
    }
    @Override
    public void paint(Graphics g){ // method used to create all graphics on the screen
        super.paint(g);
        draw(g);
    }
    public void draw(Graphics g) {
        int[][] graph = {{0}, {1, 2}, {1}, {0, 4}, {2}, {0}, {3}, {4}, {4}, {3, 1}};
        int test = adj.length;
        int numberOfVertices = adj.length;
        HashMap<Integer, Integer[]> verticesCoordinates = new HashMap<Integer, Integer[]>();
        for (int i = 0; i < numberOfVertices; i++) {
           // System.out.println("vertex " + i + " edge ");
            //adj[i].print();
            drawVertex(g, verticesCoordinates, i);
        }
//        for (int i = 0; i < numberOfVertices; i++) {
//            drawVertex(g, verticesCoordinates, i);
//        }
        
        for (int i = 0; i < numberOfVertices; i++) {
            for (int j = 1; j < graph[i].length; j += 2) {
                drawEdges(g, verticesCoordinates, i, graph[i][j]);
            }
        }
    }
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
}
