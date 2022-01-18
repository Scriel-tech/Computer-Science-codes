import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.text.View;

public class Calculator_GUI extends JFrame
{
    public final int WIDTH = 800;
    public final int HEIGHT = 600;
    private static ViewPanel view;

    public Calculator_GUI()
    {
        //(1)
        JFrame calc_window = new JFrame();
        calc_window.setSize(WIDTH, HEIGHT);
        calc_window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //(2)The main Panel
        JPanel main_window = new JPanel();
        calc_window.add(main_window);

        //(3)The main panel is broken into 2 regions. North and South will be used, with North being the View and South being the Buttons
        main_window.setLayout(new BorderLayout());

        //(4)The View Pane
        view = new ViewPanel();
        main_window.add(view, BorderLayout.NORTH);


        //(5)The Button Pane
        //The Button Panel is broken into the numbers Panel and the symbol Panel
        JPanel ButtonPanel = new JPanel();
        //ButtonPanel.setPreferredSize(new Dimension(WIDTH, (4/5)*HEIGHT));
        ButtonPanel.setLayout(new BorderLayout());
        main_window.add(ButtonPanel, BorderLayout.SOUTH);

        //(6)The Numbers Panel
        NumberPanel numbers = new NumberPanel();
        ButtonPanel.add(numbers, BorderLayout.WEST);


        //(7)The symbols Panel
        SymbolPanel symbols = new SymbolPanel();
        ButtonPanel.add(symbols, BorderLayout.EAST);


        calc_window.setVisible(true);
    }

    public void createInnerCalc()
    {
        String eq = "( 2 * 3 ) / 2";
        InnerCalculator a = new InnerCalculator();
        double ans = a.workings(eq);
        System.out.println(ans);
    }

    public static ViewPanel getView()
    {
        return view;
    }

}

class numberListener implements ActionListener
{
    @Override
    public void actionPerformed(ActionEvent e)
    {
        ViewPanel a = Calculator_GUI.getView();
        if(e.getActionCommand() == "=")
        {
            //Run the function that calculated the equation
            InnerCalculator calc = new InnerCalculator();
            String solution = Double.toString(calc.workings(a.getTextField().getText().trim()));
            a.addToView_solution(solution);
        }else{
            a.addToView(e.getActionCommand());
        }
    }
}