import javax.swing.*;
import java.awt.*;

public class NumberPanel extends JPanel
{
    int number_width = 160;
    int number_height = 150;

    public NumberPanel()
    {
        super();
        setPreferredSize(new Dimension(550,450));
        setLayout(new GridLayout(4,3));
        number_Panel one = new number_Panel("1", number_width, number_height);
        add(one);

        number_Panel two = new number_Panel("2", number_width, number_height);
        add(two);

        number_Panel three = new number_Panel("3", number_width, number_height);
        add(three);

        number_Panel four = new number_Panel("4", number_width, number_height);
        add(four);

        number_Panel five = new number_Panel("5", number_width, number_height);
        add(five);

        number_Panel six = new number_Panel("6", number_width, number_height);
        add(six);

        number_Panel seven = new number_Panel("7", number_width, number_height);
        add(seven);

        number_Panel eight = new number_Panel("8", number_width, number_height);
        add(eight);

        number_Panel nine = new number_Panel("9", number_width, number_height);
        add(nine);

        number_Panel dot = new number_Panel(".", number_width, number_height);
        add(dot);

        number_Panel zero = new number_Panel("0", number_width, number_height);
        add(zero);

        number_Panel equals = new number_Panel("=", number_width, number_height);
        add(equals);
        System.out.println(getLayout());


        setBackground(Color.BLUE);

    }
}

class number_Panel extends JPanel
{
    public number_Panel(String n, int width, int height)
    {
        super();
        JButton Num = new JButton(n);
        Num.addActionListener(new numberListener());
        setLayout(new GridBagLayout());
        Num.setPreferredSize(new Dimension(width,height));
        add(Num);//, "push , align center");
        setBackground(Color.LIGHT_GRAY);
    }
}
