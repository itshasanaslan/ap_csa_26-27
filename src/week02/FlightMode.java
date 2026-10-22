package week02;

public class FlightMode {
    
    public static void main(String[] args) {
        System.out.println("Hrlooo");
        int myNumber = 10;


      int r =   doSomething(myNumber);
      System.out.println(r);



            System.out.println(myNumber);

    }


    public static int doSomething(int myNumber) {
        // increment my num by 1
        // multiply by 5
        myNumber++;
        int result = myNumber * 5;

        return result;
    }


}
