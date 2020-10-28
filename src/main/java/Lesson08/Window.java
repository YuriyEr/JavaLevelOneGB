package Lesson08;

import javax.swing.*;
import java.awt.*;

public class Window {
    JFrame window;
    Integer hight;
    Integer width;

    public Window() {
        JFrame window = new JFrame("Set");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //первичные параметры
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        hight = (int)((double) screenSize.height * 0.4d);
        width = (int)((double) screenSize.width * 0.4d);
        window.setSize(new Dimension(width,hight));
        window.setVisible(true);

        //элементы
        JScrollBar scroll = new JScrollBar();
        //scroll.setSize(new Dimension((int)((double) width * 0.2),hight));

        JTextField textField = new JTextField("Какой то текст");
        //textField.setBounds(0,0,(int)((double) width * 0.6),hight);

        JMenuItem a1,a2;
        JMenu menu = new JMenu("options");
        JMenuBar m1 = new JMenuBar();
        a1 = new JMenuItem("example");
        a2 = new JMenuItem("example1");
        menu.add(a1);
        menu.add(a2);

        window.getContentPane().add(BorderLayout.EAST, scroll);
        window.getContentPane().add(BorderLayout.CENTER, textField);
        window.getContentPane().add(BorderLayout.NORTH, menu);
    }
}
