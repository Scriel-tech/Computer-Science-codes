import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;

public class InnerCalculator {
    //Given an equation string, it will compute the solution
    double solution;

    public double workings(String equation)
    {
        System.out.println(equation);
        equation = equation.trim();
        System.out.println(equation);
        String [] c = equation.split(" ");
        LinkedList<String> e = new LinkedList<String>();
        //Collections.addAll(e, c);



        //Keeps track of the number of multiplication and division signs
        int md = 0;
        int as = 0;

        //Deals with brackets
        for(int i = 0; i<c.length;i++)
        {
            if (c[i].equals("("))
            {
                int b = i + 1;
                String a = c[b];
                while (!a.equals(")"))
                {
                    a = c[b];
                    if(a.equals(")"))
                    {
                        break;
                    }
                    b += 1;
                }

                String sub_equation = createEquation(Arrays.copyOfRange(c, i + 1, b));

                double temp = workings(sub_equation);
                e.addLast("" + temp);
                i = b;
            } else
            {
                if (c[i].equals("+") || c[i].equals("-") || c[i].equals("*") || c[i].equals("/"))
                {
                    if (c[i].equals("*") || c[i].equals("/"))
                    {
                        md += 1;
                    } else
                    {
                        as += 1;
                    }
                }
                e.addLast(c[i]);
            }
        }

        /*for(int k=0;k<e.size();k++)
        {
            System.out.print(e.get(k));
        }
        System.out.println();*/

        //Only does multiplication and division if there's more than one sign in it
        //Note that this is only the first approach, a better way is to search for the signs.

        if(md > 0)
        {
            int j = 0;
            while(md !=0)
            {
                //System.out.println("j = " + j);
                if(e.get(j).equals("*") || e.get(j).equals("/"))
                {
                    md -= 1;

                    //System.out.println(e.get(j));
                    if(e.get(j).equals("*"))
                    {
                        e.set(j,multiply(Double.parseDouble(e.get(j-1)), Double.parseDouble(e.get(j+1))));
                    }else{
                        e.set(j,div(Double.parseDouble(e.get(j-1)), Double.parseDouble(e.get(j+1))));
                    }
                    e.remove(j-1);
                    e.remove(j);

                    if(e.size() == 1)
                    {
                        break;
                    }
                }
                else{j += 1;}
            }
        }

        //Only does addition and subtraction if there's more than one sign in it
        if(as > 0)
        {
            int j = 0;
            while(as !=0)
            {
                //System.out.println("j = " + j);
                if(e.get(j).equals("+") || e.get(j).equals("-"))
                {
                    as -= 1;

                    //System.out.println(e.get(j));
                    if(e.get(j).equals("+"))
                    {
                        e.set(j,add(Double.parseDouble(e.get(j-1)), Double.parseDouble(e.get(j+1))));
                    }else{
                        e.set(j,minus(Double.parseDouble(e.get(j-1)), Double.parseDouble(e.get(j+1))));
                    }
                    e.remove(j-1);
                    e.remove(j);

                    if(e.size() == 1)
                    {
                        break;
                    }
                }
                else{j += 1;}
            }
        }


        //double ans = final_sum(e);
        double ans = Double.parseDouble(e.pop());
        return ans;
    }

    public String createEquation(String [] arr)
    {
        String r = "";

        for(int i = 0;i< arr.length;i++)
        {
            r = r + arr[i] + " ";
        }
        return r;
    }


    public String add(double a, double b)
    {
        return(Double.toString(a + b));
    }

    public String minus(double a, double b)
    {
        return(Double.toString(a - b));
    }

    public String multiply(double a, double b)
    {
        return(Double.toString(a * b));
    }

    public String div(double a, double b)
    {
        return(Double.toString((a/b) + (a%b)));
    }

    /*public double final_sum(LinkedList<String> a)
    {
        double ans = 0;
        while(a.getLast() != null && a.size() >0)
        {
            System.out.println(a.getLast());
            ans += Double.parseDouble(a.getLast());
            a.removeLast();
        }
        return ans;
    }*/
}
