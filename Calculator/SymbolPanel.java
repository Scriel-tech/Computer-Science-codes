import javax.swing.*;
import java.awt.*;

public class SymbolPanel extends JPanel
{
    int panel_width = 110;
    int panel_height = 112;

    public SymbolPanel()
    {
        super();
        setBackground(Color.YELLOW);
        setPreferredSize(new Dimension(260,450));
        setLayout(new GridLayout(4,2));

        number_Panel plus = new number_Panel("+", panel_width, panel_height);
        add(plus);
        number_Panel minus = new number_Panel("-", panel_width, panel_height);
        add(minus);
        number_Panel mult = new number_Panel("*", panel_width, panel_height);
        add(mult);
        number_Panel div = new number_Panel("/", panel_width, panel_height);
        add(div);
        number_Panel openBracket = new number_Panel("(", panel_width, panel_height);
        add(openBracket);
        number_Panel closeBracket = new number_Panel(")", panel_width, panel_height);
        add(closeBracket);
        number_Panel del = new number_Panel("del", panel_width * 2,panel_height);
        add(del);
    }
}
