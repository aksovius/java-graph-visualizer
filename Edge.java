package visualizer;

import javax.swing.*;
import java.awt.*;

public class Edge extends JComponent {
    private final Vertex start;
    private final Vertex end;

    public Edge(Vertex start, Vertex end) {
        this.start = start;
        this.end = end;
        String edgeName = "<" +  start.getId() + " -> " + end.getId() + ">";
        setOpaque(false);
        setName("Edge " + edgeName);
        setBounds(0, 0, 800, 600);
        setPreferredSize(new Dimension(800, 600));
    }
    @Override
    protected  void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.WHITE);
        // calculating center point must be here because
        // calling getCenterPoint method before the path panel is added to the graph panel lead issue with size.
        Point startPoint = start.getCenterPoint();
        Point endPoint = end.getCenterPoint();
        g.drawLine(startPoint.x, startPoint.y, endPoint.x, endPoint.y);
    }

}
