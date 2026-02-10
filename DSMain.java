import java.util.Arrays;

public class DSMain {

    public static Stack process(Stack inStack, Queue inQueue) {

        Stack outStack = new Stack(50);

        // =====================================
        // WRITE YOUR LOGIC HERE ONLY
        //

        while(!inStack.isEmpty() && !inQueue.isEmpty()) { // 1. while both not empty

           String str =  inStack.pop();
           int z = inQueue.dequeue();

          String[] splitS = str.split(":");
          String x = splitS[0];
          int y = Integer.parseInt(splitS[1]);

          if(x.length() == y) {
              if(z == y*y){
                  outStack.push(y+":"+z);
              }
          else{
                  outStack.push(y+":D");
              }
          }
          else{
              outStack.push("D");
          }

        }
            // 2. handle leftover stack
           /* while(!inStack.isEmpty()){
                inStack.pop();
                outStack.push("High");
            }
            // 3. handle leftover queue
            //    - push "Low"
            while(!inQueue.isEmpty()){
                inQueue.dequeue();
                outStack.push("Low");
            } */


        return outStack;
    }

    // TEST DRIVER
    public static void main(String[] args) {

        Stack inStack = new Stack(10);
        Queue inQueue = new Queue(10);

        // Stack: top -> bottom
        inStack.push("Paul Steven");
        inStack.push("Elisa Perry");
        inStack.push("James Gun");
        inStack.push("John Deol");


        // Queue: front -> rear
        inQueue.enqueue(16);
        inQueue.enqueue(23);
        inQueue.enqueue(144);
        inQueue.enqueue(49);
        inQueue.enqueue(62);

        Stack result = process(inStack, inQueue);
        result.display();
    }
}
