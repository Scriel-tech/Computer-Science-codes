import javax.swing.*;
import java.awt.*;

public class ViewPanel extends JPanel
{
    JTextField view;

    public ViewPanel()
    {
        super();
        setBackground(Color.GREEN);
        setPreferredSize(new Dimension(800, 120));

        //Add a JTextField
        view = new JTextField(65);
        view.setEditable(true);
        add(view);
    }

    public JTextField getTextField()
    {
        return view;
    }

    public void addToView(String s)
    {
        String text_present = view.getText();

        if(text_present == "")
        {
            view.setText(s);
        }else
        {
            view.setText(view.getText() + " " + s);
        }
    }

    public void addToView_solution(String s)
    {
        view.setText(s);
    }

    public JTextField getView()
    {
        return view;
    }
}
