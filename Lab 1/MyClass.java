import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class MyClass {

    /*
     * Метод, который изменяет полученные данные,
     * представляя дробь целым числом,
     * числителем и знаменателем.
     * Возвращает массив с целым числом, новыми
     * числителем и знаменателем и исходными данными.
     */
    public static int[] find(int[]x) throws IOException {
        int integer = 0;
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
        
    /*
     * Данный метод используется для сохранения
     * результата выполнения программы в текстовый файл.
     */
    public static void write_in_file(String filename, int[]x) throws IOException {

        BufferedWriter outputWriter = null;
        outputWriter = new BufferedWriter(new FileWriter(filename,true));
        x=find(x);
        outputWriter.write("Целое число: "+x[0]+", числитель: "+x[1]+", знаменатель: "+x[2]+"\n");
        outputWriter.flush();
        outputWriter.close();
        System.out.println("[Log]: "+"Целое число: "+x[0]+", числитель: "+x[1]+", знаменатель: "+x[2]);
    }
    
    /*
     * Метод для считывания исходных данных
     */
    public static int[] read_from_file(String filename) throws IOException {
        Scanner scanner = new Scanner(new File(filename));
        int[] x = new int[100];
        int i = 0;
        while(scanner.hasNextInt()){
            x[i++] = scanner.nextInt();
        }
        int num = x[0];
        int denum = x[1];
        return new int[] {num, denum};
    }

    /*
     * Метод для записи результата в байтовом представлении.
     */
    public static void writeByte(String filename, int[]x) throws IOException{
        x=find(x);
        String text = ("Целое число: "+x[0]+", числитель: "+x[1]+", знаменатель: "+x[2]);
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

        int[]x=read_from_file("input.txt");
        write_in_file("nums.txt",x);
        writeByte("bytecode", x);
    }
}