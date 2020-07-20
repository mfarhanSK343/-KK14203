import java.util.Scanner;

class Menu{
   private String item;
   private double price;
   
   Menu(String i, double p){
      item = i;
      price = p;   
   }
   
   String getItem(){
      return item;
   }
   
   double getPrice(){
      return price;
   }
   
   void setItem(String item){
        this.item = item; 
   }
   
   void setPrice(double price){
      this.price = price; 
   }
   
   String getMenuItem(){
       return (item + " RM" + String.format("%.2f", price));  
   }
   
   double calcPrice(int quantity){
      return ((double)(price*quantity));   
   }
}

class Orders{ 
   private int m_id; 
   private String m_Name; 
   private int o_Quantity; 
   private double subTotal; 
      
   Orders(int id, String name, int quantity, double subto){ 
      m_id = id;
      m_Name = name;
      o_Quantity = quantity;
      subTotal = subto;
   }
   
   void print(){
      System.out.println(m_id + " \t" + m_Name + " \t\t" + o_Quantity + " \t\tRM" + subTotal);
   }
   
   double getSubTotal(){
      return subTotal;
   }
   
   //accessor & mutator   
}

public class Lab3_MenuDemo {
   public static void main(String args[]) throws java.io.IOException{
      char choice;
      int qty;
      double total=0.0;
      Scanner scan = new Scanner(System.in);
      
      //initialize menu
      Menu item[] = new Menu[4];
      item[0] = new Menu("Nasi Lemak", 2.00);
      item[1] = new Menu("Roti      ", 1.00);
      item[2] = new Menu("Teh Tarik ", 1.50);
      item[3] = new Menu("Kopi O    ", 1.00);
      
      //print menu
      System.out.println("Menu Order System");
      System.out.println("----------------------------------------------");     
      System.out.println("[1] " + item[0].getMenuItem());      
      System.out.println("[2] " + item[1].getMenuItem());
      System.out.println("[3] " + item[2].getMenuItem());      
      System.out.println("[4] " + item[3].getMenuItem()); 
      System.out.println("----------------------------------------------");     
      System.out.println("Press n for new order | q to exit.");
      /*   
      do{
         System.out.print("Add order: ");
         choice = (char) System.in.read();
         switch(choice){
            case '1':
               System.out.print("\t" + nl.getItem() + " - ");
               System.out.print("Quantity: ");
               qty = scan.nextInt();
               total += (nl.calcPrice(qty));
               System.out.println("\tPrice: RM" + nl.calcPrice(qty) + "\n");
               break;
            case '2':
               System.out.print("\t" + ro.getItem() + " - ");
               System.out.print("Quantity: ");
               qty = scan.nextInt();
               total += (ro.calcPrice(qty));
               System.out.println("\tPrice: RM" + ro.calcPrice(qty) + "\n");
               break;
            case '3':
               System.out.print("\t" + tt.getItem() + " - ");
               System.out.print("Quantity: ");
               qty = scan.nextInt();
               total += (tt.calcPrice(qty));
               System.out.println("\tPrice: RM" + tt.calcPrice(qty) + "\n");
               break;
         }
      }*/ while (choice!='q');       
      
      System.out.println("\nThank you for your order.");
      System.out.printf("Total due: RM %.2f", total);
            
   }
}