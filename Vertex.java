package visualizer;

import javax.swing.*;
import java.awt.*;

public class Vertex extends JPanel{
    private final String id;
    private final int x;
    private final int y;
    public Vertex(String vertexId, int x, int y) {
        this.id = vertexId;
        this.x = x;
        this.y = y;
        // Set the vertex appearance
        setOpaque(false);
        setName("Vertex " + vertexId);

        // Create the vertex label
        JLabel label = new JLabel(vertexId);
        label.setName("VertexLabel " + vertexId);
        label.setForeground(Color.BLACK);
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setVerticalAlignment(SwingConstants.CENTER);
        label.setOpaque(false);

        // Set the vertex bounds
        setBounds(x, y, 50, 50);
        setPreferredSize(new Dimension(50, 50));

        // Set layout manager and add the label to the vertex
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.CENTER;
        // Add the label to the vertex
        add(label, gbc);
    }
    public String getId() {
        return this.id;
    }

    public Point getCenterPoint() {
        return new Point(x+ this.getWidth() / 2, y+ this.getHeight() / 2 );
    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.WHITE);
        g.fillOval(0, 0, 50, 50);
    }
}
