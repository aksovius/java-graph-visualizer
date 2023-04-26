package visualizer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Objects;

public class MainFrame extends JFrame {
      private Vertex start;

    public MainFrame() {
        super("Graph-Algorithms Visualizer");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);

        JPanel graph = new JPanel();
        graph.setName("Graph");
        graph.setLayout(null);
        graph.setBackground(Color.BLACK);

        // mode indicator
        JLabel modeLabel = new JLabel("Current Mode -> Add a Vertex");
        modeLabel.setName("Mode");
        modeLabel.setBackground(Color.BLACK);
        modeLabel.setForeground(Color.WHITE);
        modeLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        modeLabel.setVerticalAlignment(SwingConstants.CENTER);
        modeLabel.setOpaque(true);
        add(modeLabel,BorderLayout.NORTH);

       Menu menu = new Menu(modeLabel);
        setJMenuBar(menu);
        setListeners(graph, menu);


        add(graph);
        setVisible(true);

    }
    public void setListeners(JPanel graph, Menu menu) {
        graph.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
            super.mouseClicked(e);
            int x = e.getX() - 25;
            int y = e.getY() - 25;
            if(menu.getMode() == Mode.ADD_VERTEX) {   // add vertex only on mode = 0
                String label = actionPerformed(graph,menu.getMode()); // check if not clicked cancel
                if(!label.equals("")) { // if not cancel
                    Vertex vertex = new Vertex(label, x, y); // new vertex
                    vertex.addMouseListener(new MouseAdapter() {
                        @Override
                        public void mouseClicked(MouseEvent e) {
                            super.mouseClicked(e);
                            if (menu.getMode() == Mode.ADD_EDGE) {
                                Vertex node = (Vertex) e.getComponent();
                                if(start == null) {
                                    start = node;
                                } else {
                                    String weight = actionPerformed(graph,menu.getMode());
                                    if (!Objects.equals(weight, "")) {
                                        Edge edge = new Edge(start, node);
                                        Edge edgeRev = new Edge(node, start);
                                        Weight wLabel = new Weight(start, node, weight);
                                        graph.add(edge);
                                        graph.add(edgeRev);
                                        graph.add(wLabel);
                                        graph.revalidate();
                                        graph.repaint();
                                        start = null;
                                    }

                                }
                            }
                        }
                    });
                    graph.add(vertex);
                    graph.revalidate();
                    graph.repaint();
            }


            }
            }
        });


    }

    public String actionPerformed( JPanel panel, Mode mode) {
        String message = null;
        String title = null;
        switch (mode) {
            case ADD_VERTEX -> {
                message = "Enter the Vertex ID (Should be 1 char):";
                title = "Vertex";
            }
            case ADD_EDGE -> {
                message = "Enter Weight";
                title = "Input";
            }
        }
        String output = JOptionPane.showInputDialog(panel, message, title, JOptionPane.QUESTION_MESSAGE );
        if (output == null) {
            return "";
        } else if( mode == Mode.ADD_VERTEX ) {
            if (output.length() == 1 && !Character.isSpaceChar(output.charAt(0))) {
                return output;
            }
        } else if (mode == Mode.REMOVE_EDGE) {
            if (output.length() != 0 && output.matches("-*\\d+")) {
                return output;
            }
        }
        return actionPerformed(panel, mode);
    }

}

