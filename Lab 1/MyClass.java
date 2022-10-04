import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class MyClass {

    public static int[] input(){

        Scanner in = new Scanner(System.in);
        System.out.print("Введите числитель: ");
        int num = in.nextInt();

        System.out.print("Введите знаменатель: ");
        int denum = in.nextInt();
        in.close();
        return new int[] {num, denum};
    }

    public static int[] find() {
        int integer = 0;
        int[] x = input();
        int num = x[0];
        int denum = x[1];

        if (num > denum) {
            while (num >= denum) {
                num = num - denum;
                integer = integer +1;
                if (num == denum){
                    num = 0;
                    denum = 0;
                    integer = integer +1;
                    break;
                }
            }
        }

        else if (num == denum){
            integer = 1;
            num = 0;
            denum = 0;
        }

        return new int[] {integer, num, denum,x[0],x[1]};
        
    }

    public static void write_in_file(String filename, int[]x) throws IOException {

        BufferedWriter outputWriter = null;
        outputWriter = new BufferedWriter(new FileWriter("nums.txt",true));
        outputWriter.write("Целое число: "+x[0]+", числитель: "+x[1]+", знаменатель: "+x[2]+". Исходные данные: "+x[3]+", "+x[4]+".\n");
        outputWriter.flush();
        outputWriter.close();
        System.out.println("[Log]: "+"Целое число: "+x[0]+", числитель: "+x[1]+", знаменатель: "+x[2]+". Исходные данные: "+x[3]+", "+x[4]+".");
    }

    public static void writeByte(String filename, int[]x){
        String text = ("Целое число: "+x[0]+", числитель: "+x[1]+", знаменатель: "+x[2]+". Исходные данные: "+x[3]+", "+x[4]+".");
        try(FileOutputStream fos = new FileOutputStream("bytecode"))
        {
            byte[] buffer = text.getBytes();
            System.out.println("[Log]: "+buffer);
            fos.write(buffer,0,buffer.length);

            System.out.println("[Log]: "+"Записано в двоичный поток.");
        }
        catch(IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    public static void main(String[] args) throws IOException {
        int[] x = find();
        write_in_file("nums.txt",x);
        writeByte("bytecode", x);
    }

}

