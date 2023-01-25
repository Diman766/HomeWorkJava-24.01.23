
/**
Реализовать функцию возведения числа а в степень b. a, b ∈ Z. Сводя количество выполняемых действий к минимуму. 
Пример 1: а = 3, b = 2, ответ: 9 
Пример 2: а = 2, b = -2, ответ: 0.25
Пример 3: а = 3, b = 0, ответ: 1
Пример 4: а = 0, b = 0, ответ: не определено
Пример 5
входные данные находятся в файле input.txt в виде
b 3
a 10
Результат нужно сохранить в файле output.txt
1000
 */
import java.io.*;
import java.io.FileWriter;
import java.io.IOException;

public class task {

    public static void main(String[] args) throws Exception {
        writer(worker(reader()));
    }

    public static void writer(String result) {
        try (FileWriter fw = new FileWriter("C:/Users/first/Desktop/Java/HomeWorkJava 24.01.23/output.txt", false)) {
            fw.write(result);
            fw.flush();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static String worker(int[] array) {
        int a = array[0];
        int b = array[1];
        String result = null;
        if (b < 0) {
            b = b * -1;
            result = String.valueOf(1. / pow(a, b));
        } else if (b > 0) {
            result = String.valueOf(pow(a, b));
        } else if (b == 0 && a > 0) {
            result = "1";
        } else if (b == 0 && a == 0) {
            result = "не определено";
        }
        return result;
    }

    public static int[] reader() throws Exception {
        BufferedReader br = new BufferedReader(
                new FileReader("C:/Users/first/Desktop/Java/HomeWorkJava 24.01.23/input.txt"));
        String str;
        int a = 0;
        int b = 0;
        while ((str = br.readLine()) != null) {
            if (str.indexOf('b') != -1) {
                b = Integer.parseInt(str.replaceAll("[^0-9]", ""));
            } else {
                a = Integer.parseInt(str.replaceAll("[^0-9]", ""));
            }
        }
        br.close();
        int[] array = { a, b };
        return array;
    }

    public static int pow(int value, int powValue) {
        if (powValue == 1) {
            return value;
        } else {
            return value * pow(value, powValue - 1);
        }
    }
}