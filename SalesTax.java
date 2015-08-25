/**
 * Created by karthikr on 24/08/15.
 */

import java.util.ArrayList;
import java.util.Scanner;

public class SalesTax {

        float Total=0.0f,salesTax=0.0f;
        String input;
        ArrayList<String> lines =new ArrayList<String>();

        public static void main(String []args )
        {

            SalesTax salesTaxes = new SalesTax();
            salesTaxes.receiveInput();
            salesTaxes.format();
        }

        void receiveInput()
        {
            Scanner scanner=new Scanner(System.in);
            System.out.println("Input1:");
            while(true)
            {
                input = scanner.nextLine();
                if(input.equals(""))
                    break;
                lines.add(input);

            }
        }


        void format()
        {  // System.out.print(lines.size());

            for(int i=0;i< lines.size();++i)
            {
                String [] parts= lines.get(i).split(" ");
                int quantity=Integer.parseInt(parts[0]);
                float cost=Float.parseFloat(parts[parts.length-1]);

                //System.out.println(quantity);
                //System.out.println(cost);
                boolean imported = parts[1].equals("imported") ? true : false;
                Total+=computeTax(parts, imported, quantity, cost);



            }

            System.out.println("Sales Tax:"+salesTax);
            System.out.println("Total:"+Total);
        }



    float computeTax(String words[], boolean imported,int quan,float price)
    {

        if(imported)
        {

            salesTax += price* 0.05;
            price+= salesTax;



        }



        for (int i = 1; i < words.length-1; ++i)
        {
            switch (words[i])
            {

                case "book":display(quan,"book",price,imported);
                    break;
                case "chocolate":display(quan,"chocolate",price,imported);
                    break;
                case "music":
                    salesTax += quan * price * 0.1;
                    price+= salesTax;

                    display(quan,"music Cd",price,imported);
                    break;

                default:
                    break;
            }
        }
        return price;
    }





    void display(int quan,String item,float price,boolean imported)
    {
      if(!imported)
       System.out.println(quan+" "+item+":"+price);
      else
       System.out.println(quan + " imported " + item + ":" + price);

    }
}






