import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayDeque;

public class Reader {
    public static boolean readFile(ArrayDeque<Integer> deque, BufferedReader br, int[] indexes, int index, boolean isAscend, int lastWritten) throws IOException {
        String str;
        int i;
        for (i = 0; i < 5; i++) {
            if ((str = br.readLine()) == null) {
                break;
            }
            else {
                if (Validations.isValid(deque, str, indexes[index], index, isAscend, lastWritten)) {
                    deque.add(Integer.parseInt(str));
                }
                indexes[index]++;
            }
        }
        return (i == 5);
    }

    public static boolean readFile(ArrayDeque<String> deque, BufferedReader br, int[] indexes, int index, boolean isAscend, String lastWritten) throws IOException {
        String str;
        int i;
        for (i = 0; i < 5; i++) {
            if ((str = br.readLine()) == null) {
                break;
            }
            else {
                if (Validations.isValid(deque, str, indexes[index], index, isAscend, lastWritten)) {
                    deque.add(str);
                }
                indexes[index]++;
            }
        }
        return (i == 5);
    }
}
