import java.util.Scanner;

public class ArithmeticOperations
{
    public int num1, num2;

    public int addNums(int n1, int n2) {
        return n1 + n2;
    }

    public int subNums(int n1, int n2) {
        return n1 - n2;
    }

    public int multNums(int n1, int n2) {
        return n1 * n2;
    }

    public int divNums(int n1, int n2) {
        return n1 / n2;
    }

    public int modNums(int n1, int n2) {
        return n1 % n2;
    }

    public static void main(String[] args) {
        ArithmeticOperations op = new ArithmeticOperations();
        Scanner scan = new Scanner(System.in);

        System.out.print("Enter first number: ");
        op.num1 = scan.nextInt();

        System.out.print("Enter second number: ");
        op.num2 = scan.nextInt();

        int sum  = op.addNums(op.num1, op.num2);
        int diff = op.subNums(op.num1, op.num2);
        int prod = op.multNums(op.num1, op.num2);
        int div  = op.divNums(op.num1, op.num2);
        int rem  = op.modNums(op.num1, op.num2);

        System.out.println("Sum: " + sum);
        System.out.println("Difference: " + diff);
        System.out.println("Product: " + prod);
        System.out.println("Division: " + div);
        System.out.println("Modulus: " + rem);

        scan.close();
    }
}
