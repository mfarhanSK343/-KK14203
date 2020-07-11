abstract class Cake{
   String name, get_size;
   String[] topping;
   String[] toppingOrder;
   double priceSize, priceSmall, priceMedium, priceBig, totalPrice;
   int size, quantity;

   Cake(String name){
      this.name = name;
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
   
   double getTotalPrice(double priceSize){
      totalPrice = priceSize * quantity + (toppingOrder.length*10);
      return totalPrice;
   }

   String getSize(){
			switch (size) {
			case 1: get_size = "Small"; break;
			case 2: get_size = "Medium"; break;
			case 3: get_size = "Big"; break;
			default: get_size = "None"; break;
		}
		return get_size; 
   }

   void printCake(){
      System.out.println("----------------------");
      System.out.println("       Cake Menu      ");
      System.out.println("----------------------");
      System.out.println(name + " cake with available toppings: ");
      for(int i=0; i<topping.length; i++){
         System.out.println((i+1)+ ") " + topping[i]);   
      }
      System.out.println("\nPrice: ");
      System.out.println("[1] Small  : " + priceSmall);
      System.out.println("[2] Medium : " + priceMedium);
      System.out.println("[3] Big    : " + priceBig); 
   }
   
   void printOrder(String get_size, double totalPrice){
      System.out.println("\n\nCake Order details: ");
      System.out.println("-------------------------------");
      System.out.print("Topping: ");
      for(int i=0; i<toppingOrder.length; i++){
            System.out.print((i+1)+ ") " + toppingOrder[i] + "\t");   
         }
      System.out.println("\nSize: " + get_size);
      System.out.println("-------------------------------");
      System.out.println("TOTAL PRICE: RM " + totalPrice );
      System.out.println("-------------------------------");
      
   }

}
