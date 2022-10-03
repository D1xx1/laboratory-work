import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class MyClass {

    public static int[] input(){

        Scanner innum = new Scanner(System.in);
        System.out.print("Введите числитель: ");
        int num = innum.nextInt();

        Scanner in = new Scanner(System.in);
        System.out.print("Введите знаменатель: ");
        int denum = in.nextInt();
        innum.close();
        in.close();
        return new int[] {num, denum};
    }

    public static void write (String filename, int[]x) throws IOException{

        BufferedWriter outputWriter = null;
        outputWriter = new BufferedWriter(new FileWriter("nums.txt",true));
        outputWriter.write("Числитель: "+x[0]+", знаменатель: "+x[1]+"\n");
        outputWriter.flush();
        outputWriter.close();
    }

    public static void finding_a_fraction(){

    }


    public static void main(String[] args) throws IOException {
        int[] x = input();
        write("nums.txt",x);

    }

}