package visualizer;

import javax.swing.*;
import java.awt.event.KeyEvent;

public class Menu extends JMenuBar {

    private Mode mode = Mode.ADD_VERTEX;
    JLabel modeLabel;
    private final JMenu modeMenu = new JMenu("Mode");;
    public Menu(JLabel modeLabel) {
        this.modeLabel = modeLabel;
        for (Mode m: Mode.values()) {
            createMenu(m);
        }
        add(modeMenu);
    }

    public Mode getMode() {
        return mode;
    }

    private void createMenu(Mode mode) {
        // add menu items
        JMenuItem MenuItem = new JMenuItem(mode.toString());
        MenuItem.setName(mode.toString());
        MenuItem.addActionListener(e -> {
            this.mode = mode;
            modeLabel.setText(mode.getLabelName());
        });
        modeMenu.add(MenuItem);
    }
}