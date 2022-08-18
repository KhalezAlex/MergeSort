import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        String logPath = "log.txt";
        Engine engine = new Engine(logPath);
        engine.flushOutput();
        engine.merge();
    }
}
//        Строки для команд в командной строке
//        String valsAsc = "-a -i inputASC1Vals.txt inputASC2Vals.txt Output.txt";
//        String valsDesc = "-d -i inputDESC1Vals.txt inputDESC2Vals.txt Output.txt";
//        String strAsc = "-a -s inputASC1Str.txt inputASC2Str.txt Output.txt";
//        String strDEsc = "-d -s inputDESC1Str.txt inputDESC2Str.txt Output.txt";