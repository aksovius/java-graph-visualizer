package visualizer;

import javax.swing.*;
import java.awt.*;

public class Weight extends JLabel {
    private final Vertex start;
    private final Vertex end;
    public Weight(Vertex start, Vertex end, String weight) {
        this.start = start;
        this.end = end;
        setText(weight);
        String edgeName = "<" +  start.getId() + " -> " + end.getId() + ">";
        setName("EdgeLabel " + edgeName);
        setForeground(Color.WHITE);
        setVerticalAlignment(SwingConstants.TOP);

    }
    @Override
    public void doLayout() {
        super.doLayout();
        // Update the position of the weight label
        int x = (start.getLocation().x + end.getLocation().x) / 2;
        int y = (start.getLocation().y + end.getLocation().y) / 2;
        setBounds(x, y, getPreferredSize().width, getPreferredSize().height + 20);

    }
}
