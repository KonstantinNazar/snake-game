package snake;

import javax.swing.*;
import java.awt.*;

public class SnakeCell extends Cell
{
    public static int lenght = 0;
    public int index;
    public int next;
    public int previus;
    private Image crashImage;

    SnakeCell(int x, int y)
    {
        super(x, y);
        index = lenght;
        setSnakeImage();
        setCrashImage();
        previus = index - 1;
        next = index + 1;
        lenght++;
    }

    private void setSnakeImage()
    {
        ImageIcon imageCellIcon = new ImageIcon(getClass().getResource("/img/black.png"));
        super.image = imageCellIcon.getImage();
    }

    private void setCrashImage()
    {
        ImageIcon imageCellIcon = new ImageIcon(getClass().getResource("/img/crash.png"));
        crashImage = imageCellIcon.getImage();
    }

    public Image getCrashImage()
    {
        return crashImage;
    }

}
