import java.io.*;
import java.io.IOException;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;



class testJPanel extends JPanel{ 
    private JLabel header;
    public testJPanel(String s){
       header = new JLabel(s);
       add(header);
   }
}

abstract class Cake extends JFrame{ 
   String name, get_size;
   String[] topping;
   String[] toppingOrder;
   double priceSize, priceSmall, priceMedium, priceBig, totalPrice;
   int size, quantity;
   int pc = 25, po = 5;
   String filename = "";
   String save = "";

   Cake(String name){
      this.name = name;                   
      setTitle("Cake GUI");
      getContentPane().setBackground(Color.orange);
      setSize(500, 500);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setResizable(false);
      
      testJPanel panel = new testJPanel("Cake order GUI"); 
      add(panel, BorderLayout.NORTH); 
      setLocationRelativeTo(null);
      setVisible(true);
   }

   abstract void setCake(String[] topping, double priceSmall, double priceMedium, double priceBig);

   void orderCake(String[] toppingOrder, int quantity, int size){
      this.toppingOrder = toppingOrder;
      this.quantity = quantity;
      this.size = size;
   }
   double getSizePrice(){
      switch (size) {
			case 1: 
				priceSize = priceSmall; break;
			case 2: 
				priceSize = priceMedium; break;
			case 3: 
				priceSize = priceBig; break;
			default: break;
		}
		return priceSize;                        
   }
   
   double getTotalPrice(){
      totalPrice = getSizePrice() * quantity + (toppingOrder.length*10);
      return totalPrice;
   }

   String getSizeCake(){
      switch (size) {
			case 1: get_size = "Small"; break;
			case 2: get_size = "Medium"; break;
			case 3: get_size = "Big"; break;
			default: get_size = "None"; break;
		}
		return get_size;  
   }

   void printCake(){
      
              
        JLabel menu1 = new JLabel ("     Cake Order");
        JLabel line1 = new JLabel ("-----------------------");
        JLabel menu2 = new JLabel ("Cake Menu");
        JLabel line2 = new JLabel ("-----------------------");
        JLabel toppings1 = new JLabel (name + " cake with available toppings");//
        
        int a = topping.length;
        JLabel[] avail_toppings = new JLabel[a];
        for(int i=0; i<a ;i++){
            avail_toppings[i] = new JLabel( "[" + (i+1) + "] " + topping[i]); 
            add(avail_toppings[i]);
            avail_toppings[i].setBounds (25, 90 + pc, 200, 30);
            pc += 20;
        }

        JLabel price = new JLabel ("Price:");
        JLabel small = new JLabel ("[1] Small      : " + String.valueOf(priceSmall));
        JLabel medium = new JLabel ("[2] Medium : " + String.valueOf(priceMedium));
        JLabel big = new JLabel ("[3] Big          : " + String.valueOf(priceBig));
        setLayout (null);

        add (menu1);
        add (line1);
        add (menu2);
        add (line2);
        add (toppings1);
        add (price);
        add (small);
        add (medium);
        add (big);

        menu1.setBounds (190, 20, 120, 30);
        line1.setBounds (15, 40, 100, 30);
        menu2.setBounds (35, 55, 100, 30);
        line2.setBounds (15, 70, 100, 30);
        toppings1.setBounds (20, 95, 261, 25);
        price.setBounds (20, pc+95, 100, 25);
        small.setBounds (25, pc+110, 143, 25);
        medium.setBounds (25, pc+130, 200, 25);
        big.setBounds (25, pc+150, 200, 25);

        save += "\n-------------------------------------\n" + 
                "\t\tCake Menu" +
                "\n-------------------------------------\n" +
                name + " cake with available toppings\n" ;
                
        for(int i=0; i<a ;i++){
            save += "[" + (i+1) + "] " + topping[i] + "\n"; 
        }                        
        save += "Price:" +
                "\n[1] Small     : " + String.valueOf(priceSmall) +
                "\n[2] Medium : " + String.valueOf(priceMedium) +
                "\n[3] Big         : " + String.valueOf(priceBig);  
        
    }
      
   
   void printOrder(){

      JLabel detail = new JLabel ("Cake Order Details: ");
      JLabel size = new JLabel ("Size: " + getSizeCake());
      
      int tl = toppingOrder.length;
      JLabel[] choiceTopping = new JLabel[tl];

         for(int i=0; i<tl; i++){
            choiceTopping[i] = new JLabel("[" + (i+1) + "] " + toppingOrder[i]); 
            add(choiceTopping[i]);
            choiceTopping[i].setBounds (80, 315+po, 150, 25);
            po += 20;
         }
      
      JLabel toppings2 = new JLabel ("Toppings:");      
      JLabel line3 = new JLabel ("-----------------------------------------------");
      JLabel line4 = new JLabel ("-----------------------------------------------");
      JLabel total = new JLabel ("TOTAL PRICE: RM " + String.valueOf(getTotalPrice()));
      JLabel line5 = new JLabel ("-----------------------------------------------\n\n");
      JButton print = new JButton ("Print");
            
      setLayout (null);
      
      add(detail);
      add(size);
      add(toppings2);
      add(line3);
      add(line4);
      add(total);
      add(line5);
      add(print);
      
      
      detail.setBounds (10, 285, 250, 25);
      toppings2.setBounds (10, 315, 100, 25);
      line3.setBounds (10, 296, 250, 25);
      size.setBounds (11, po+315, 100, 25);
      line4.setBounds (10, po+335, 250, 25);
      total.setBounds (10, po+355, 250, 25);
      line5.setBounds (10, po+375, 250, 25);
      print.setBounds (200, po+355, 100, 25);
      
      save += "\nCake Order Details: " +
              "\nSize: " + getSizeCake() + 
              "\nToppings: \n";
      
      for(int i=0; i<tl; i++){
            save += "[" + (i+1) + "] "  + toppingOrder[i] + "\n"; 
      }
      save += "\n-----------------------------------------------" +
              "\n-----------------------------------------------" +
              "\nTOTAL PRICE: RM " + String.valueOf(getTotalPrice()) +
              "\n-----------------------------------------------\n\n";
                 
              
      
      print.addActionListener(new ActionListener(){ 
            public void actionPerformed(ActionEvent pr){
              JFrame popupz = new JFrame();
              filename=JOptionPane.showInputDialog(popupz,"Enter the name of file with extension: ");
              if(filename==null)   
                 popupz.dispose();
              else{
                 writeData();}
            }
       });
   }
   
 
   public void writeData(){
      File file = new File(filename);
		FileWriter fw = null;
		BufferedWriter br = null;
		PrintWriter pw = null;
      
      
		try {
			fw = new FileWriter(file, true);
			br = new BufferedWriter(fw);
			pw = new PrintWriter(br);
			pw.println(save);
         System.out.println("Order successfully print to " + filename);
		} catch (IOException pr) {			
         System.out.println(pr.toString());
		} finally {
			try {
				pw.close();
				br.close();
				fw.close();
			} catch (IOException pr) {
				System.out.println("Error! -> File not found");
			}catch(NullPointerException f){
            System.out.println("Error! -> Cannot empty");
         }
		}
   
   
   
   }

}

class BlackForest extends Cake{
   BlackForest(String name){
      super(name);
   }

   void setCake(String[] topping, double priceSmall, double priceMedium, double priceBig){
      this.topping = topping;
      this.priceSmall = priceSmall;
      this.priceMedium = priceMedium;
      this.priceBig = priceBig;
   }
}
public class Lab6CakeGUI{

    
    public static void main(String args[]){
       javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                Cake c = new BlackForest("BlackForest");
                String[] topping = {"Chocolate", "Cherries", "Whipped Cream"};
                c.setCake(topping, 45.00, 65.00, 80.00);
                c.printCake();
         
                String[] order = {"Chocolate", "Cherries"};
                c.orderCake(order, 1, 2);
                c.printOrder();
            }
        });
    }
}