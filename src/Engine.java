import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Engine {
    String[] paths;
    boolean isInt;
    boolean isAscend;
    //Можно объявить переменную, отвечающую за шаг Reader'а. Сейчас- 5 элементов

    public Engine(String logPath) {
        String[] str = getCommand();
        this.paths = new String[4];
        if (str.length == 4) {
            System.arraycopy(str, 1, paths, 0, 3);
            this.isInt = (str[0].charAt(1) == 'i');
            this.isAscend = true;
        }
        else {
            System.arraycopy(str, 2, paths, 0, 3);
            this.isInt = (str[1].charAt(1) == 'i');
            this.isAscend = (str[0].charAt(1) == 'a');
        }
        this.paths[3] = logPath;
    }

    private static String[] getCommand() {
        System.out.print("Введите данные для сортировки: ");
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        if (!Validations.isInputValid(str.split(" "))) {
            System.out.println("Введена неверная команда!");
            return getCommand();
        }
        else return str.split(" ");
    }

    public void flushOutput() throws FileNotFoundException {
        PrintWriter writer = new PrintWriter(this.paths[2]);
        writer.print("");
        writer.close();
        writer = new PrintWriter(this.paths[3]);
        writer.print("");
        writer.close();
    }

    public void merge() throws IOException {
        if (isInt) Merge.mergeListsI(this.paths, this.isAscend);
        else Merge.mergeListsS(this.paths, this.isAscend);
    }
}