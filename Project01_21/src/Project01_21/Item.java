package Project01_21;

public class Item {
         private String name;
         private double price;
         private double disc;
         public int numPurchased;
         
         public Item(String name, double price, int disc) {
        	 this.name = name;
        	 this.price = price;
        	 this.disc = disc;
         }
         public void setNumPurchased(int amount) {
        	 this.numPurchased = amount;
         }
         
         public String getName() {
        	 return this.name;
         }
         
         public int getAmount() {
        	 return this.numPurchased;
         }
         public double getPrice() {
        	 return this.price;
         }
         
         public double getSpecialDisc() {
        	    double amt = this.numPurchased, discTotal = 0;
        	    if(amt > 0) { 
        	    	 if(this.disc > 0) {
        	    		     discTotal = (int)(amt / (this.disc + 1)) * this.price;
        	    	 }else {
        	    		     discTotal = 0;
        	    	 }
        	    }
        	    	 return discTotal;
         }
}

