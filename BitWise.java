// Implemented in my github[]
// Bit array using random
import java.util.BitSet;
import java.util.Random;
import java.util.Scanner;

public class BitWise {

    static Scanner sc = new Scanner(System.in);
    static int n = sc.nextInt();
   static int N_BITS = n;

   public static void main(String[] args) {
      //Initialize bit array
      BitSet b1 = new BitSet(N_BITS);
      BitSet b2 = new BitSet(N_BITS);
      //Set random value as bit using setbits   ->Defined below
      setBits(b1);
      setBits(b2);
      //Conversion of Bit array to decimal
      String A = "";
        String B = "";
        for (int i = 0; i<N_BITS;i++){
            A = A+(b1.get(i)? "1" : "0").toString();  
        }
        for (int i = 0; i<N_BITS;i++){
            B = B+(b2.get(i)? "1" : "0").toString();
        }

        int A1 = 0;
        int B1 = 0;
 
        // Initializing base value to 1,
        // i.e 2^0
        int base = 1;
        // Converting Bit array a to decimal 
        int len = A.length();
        for (int i = len - 1; i >= 0; i--) {
            if (A.charAt(i) == '1')
                A1 += base;
            base = base * 2;
        }
        // Converting Bit array b to decimal
        int len1 = B.length();
        for (int i = len1 - 1; i >= 0; i--) {
            if (A.charAt(i) == '1')
                B1 += base;
            base = base * 2;
        }

        //Calling all the functions
        andop(b1,b2);
        orop(b1, b2);
        xorop(b1, b2);
        addop(A1, B1);
        subop(A1, B1);
        mulop(A1, B1);
   }

   public static void setBits(BitSet b) {
    Random r = new Random();
    for (int i = 0; i < N_BITS / 2; i++)
    b.set(r.nextInt(N_BITS));
   }

   public static void printBits(String prompt, BitSet b) {
    System.out.print(prompt + " ");
    for (int i = 0; i < N_BITS; i++) {
       System.out.print(b.get(i) ? "1" : "0");
        }
    System.out.println();
    }

    public static void andop(BitSet a, BitSet b){
        b.and(a);
        printBits("B and a", b);
    }

    public static void orop(BitSet a, BitSet b){
        a.or(b);
        printBits("A or B", b);
    }

    public static void xorop(BitSet a, BitSet b){
        a.xor(b);
        printBits("A xor B", b);
        b.xor(a);
        printBits("B xor A", b);
    }

    public static void addop(int a, int b){

        // Addition of converted values
        int c = a+b;
        BitSet C = new BitSet(N_BITS);
        for (int i = N_BITS-1;i>=0;i--){
            C.set(c % 2); 
            c = c / 2; 
        }
        printBits("Addition", C);
    }

    public static void subop(int a, int b){

        // Addition of converted values
        int c = b-a;
        BitSet C = new BitSet(N_BITS);
        for (int i = N_BITS-1;i>=0;i--){
            C.set(c % 2); 
            c = c / 2; 
        }
        printBits("Substraction", C);
    }
    public static void mulop(int a, int b){

        // Addition of converted values
        int c = a * b;
        BitSet C = new BitSet(N_BITS);
        for (int i = N_BITS-1;i>=0;i--){
            C.set(c % 2); 
            c = c / 2; 
        }
        printBits("Multiplication", C);
    }
}