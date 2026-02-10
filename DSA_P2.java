import java.util.Locale;

public class Mock2 {

    public static Stack generateCoupons(
            StringQueue custNameQueue,
            StringQueue custDobQueue) {

        Stack couponStack = new Stack(50);

     while(!custNameQueue.isEmpty() && !custDobQueue.isEmpty()) {
         // 1. dequeue name  -> "First Last"
         String name = custNameQueue.dequeue();
         String[] splitN = name.split(" ");
         String firstname = splitN[0];
         String lastName = splitN[1];
         // 2. dequeue dob   -> "DD-MM-YYYY"
         String dob = custDobQueue.dequeue();
         // 3. extract year
         String[] splitDOB = dob.split("-");
         int year = Integer.parseInt(splitDOB[2]);
         String date = splitDOB[0];
         int dateD = Integer.parseInt(date);
         String discountPercentage = "";
         // 4. decide discount:
         //    2008–2012 -> 30
          if(year>=2008 && year<=2012){
              discountPercentage = "35";
          }
         //    2013–2017 -> 20
         else if(year>=2013 && year<=2017){
             discountPercentage = "20";
         }
         else{
             discountPercentage = "X";
          }
         // 5. build NameStr:
         //    - first 3 letters of first name (UPPER)
            String firstThree = firstname.substring(0, 3);
            String lastThree = lastName.substring(lastName.length()-3, lastName.length());
            String nameStr = firstThree.toUpperCase() + lastThree.toLowerCase();

         //    - last 3 letters of last name (lower)
         // 6. calculate NumCode:
         //    - sum of all digits in DOB
         int numCode = 0;
         for (int i = 0; i < splitDOB[0].length(); i++) {
             numCode += splitDOB[0].charAt(i) - '0';
         }

         // 7. push: NameStr-NumCode-Discount
         // =====================================
         couponStack.push(nameStr + "-" + numCode + "-" + discountPercentage);
     }
        return couponStack;
    }

    // TEST DRIVER (for you to run locally)
    public static void main(String[] args) {

        StringQueue nameQ = new StringQueue(10);
        StringQueue dobQ = new StringQueue(10);

        nameQ.enqueue("Paul Steven");
        nameQ.enqueue("Elisa Perry");

        dobQ.enqueue("12-07-2009");
        dobQ.enqueue("20-06-2015");

        Stack result = generateCoupons(nameQ, dobQ);

        System.out.println("Coupon Codes (Top -> Bottom):");
        result.display();
    }
}
