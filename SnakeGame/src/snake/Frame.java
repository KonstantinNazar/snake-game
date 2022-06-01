package snake;

import javax.swing.*;
import java.awt.*;

public class Frame extends JFrame
{
    public Frame(Component panel)
    {
        setTitle("Змейка");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(Settings.SIZEX, Settings.SIZEY);
        setLocationRelativeTo(null);
        add(panel);
        setResizable(false);
        setVisible(true);

    }
}
