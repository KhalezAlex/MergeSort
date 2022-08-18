import java.io.File;
import java.io.IOException;
import java.util.ArrayDeque;

public class Validations {
    private static void log(String str) throws IOException {
        Logger.getLogger().log(str);
    }

//Value Validations
    private static boolean isValue(String str, int indexes, int index) throws IOException {
        if (str.length() == 0) {
            log("В файле " + (index + 1) + " строка " + (indexes + 1) + "- пуста.");
            return false;
        }
        for (int i = 0; i < str.length(); i++) {
            if (!Character.isDigit(str.charAt(i))) {
                log("В файле " + (index + 1) + " на " + (indexes + 1) + " строке не число");
                return false;
            }
        }
        return true;
    }
    private static boolean notEmptyValidI(ArrayDeque<Integer> deque, String str, int indexes, int index, boolean isAscend) throws IOException {
        if (isAscend) {
            if (deque.peekLast() <= Integer.parseInt(str))
                return true;
            else {
                log("В файле " + (index + 1) + " на " + (indexes + 1) + " строке число, не прошедшее сортировку");
                return false;
            }
        }
        else {
            if (deque.peekLast() >= Integer.parseInt(str))
                return true;
            else {
                log("В файле " + (index + 1) + " на " + (indexes + 1) + " строке число, не прошедшее сортировку");
                return false;
            }
        }
    }
    private static boolean emptyValid(String str, int indexes, int index, boolean isAscend, int lastWritten) throws IOException {
        if (isAscend) {
            if (lastWritten <= Integer.parseInt(str))
                return true;
            else {
                log("В файле " + (index + 1) + " на " + (indexes + 1) + " строке число, не прошедшее сортировку");
                return false;
            }
        }
        else {
            if (lastWritten >= Integer.parseInt(str))
                return true;
            else {
                log("В файле " + (index + 1) + " на " + (indexes + 1) + " строке число, не прошедшее сортировку");
                return false;
            }
        }
    }
    private static boolean isValueValid(ArrayDeque<Integer> deque, String str, int indexes, int index, boolean isAscend, int lastWritten) throws IOException {
        if (!deque.isEmpty()) {
            return notEmptyValidI(deque, str, indexes, index, isAscend);
        }
        else {
            return emptyValid(str, indexes, index, isAscend, lastWritten);
        }
    }
    public static boolean isValid(ArrayDeque<Integer> deque, String str, int indexes, int index, boolean isAscend, int lastWritten) throws IOException {
        if (!isValue(str, indexes, index)) return false;
        return isValueValid(deque, str, indexes, index, isAscend, lastWritten);
    }

//String Validations
    public static boolean isAlphabet(String word1, String word2, boolean isAscend) {
        for (int i = 0; i < Math.min(word1.length(), word2.length()); i++) {
            if (Character.toLowerCase(word1.charAt(i)) != Character.toLowerCase(word2.charAt(i))) {
                return (Character.toLowerCase(word1.charAt(i)) < Character.toLowerCase(word2.charAt(i)));
            }
        }
        if (word1.length() == word2.length())
            return isAscend;
        else
            return (word1.length() < word2.length());
    }
    private static boolean isString(String str, int indexes, int index) throws IOException {
        if (str.length() == 0) {
            log("В файле " + (index + 1) + " строка " + (indexes + 1) + "- пуста.");
            return false;
        }
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ' ') {
                log("В файле " + (index + 1) + " на " + (indexes + 1) + " строке есть пробел");
                return false;
            }
        }
        return true;
    }
    private static boolean notEmptyValidS(ArrayDeque<String> deque, String str, int indexes, int index, boolean isAscend) throws IOException {
        assert deque.peekLast() != null;
        if (isAscend) {
            if (isAlphabet(deque.peekLast(), str, true))
                return true;
            else {
                log("В файле " + (index + 1) + " на " + (indexes + 1) + " строке - строка, не прошедшая сортировку");
                return false;
            }
        } else {
            if (!isAlphabet(deque.peekLast(), str, false))
                return true;
            else {
                log("В файле " + (index + 1) + " на " + (indexes + 1) + " строке - строка, не прошедшая сортировку");
                return false;
            }
        }
    }
    private static boolean emptyValid(String str, int indexes, int index, boolean isAscend, String lastWritten) throws IOException {
        if (isAscend) {
            if (isAlphabet(lastWritten, str, true))
                return true;
            else {
                log("В файле " + (index + 1) + " на " + (indexes + 1) + " строке - строка, не прошедшая сортировку");
                return false;
            }
        } else {
            if (!isAlphabet(lastWritten, str, false))
                return true;
            else {
                log("В файле " + (index + 1) + " на " + (indexes + 1) + " строке - строка, не прошедшая сортировку");
                return false;
            }
        }
    }
    private static boolean isStringValid(ArrayDeque<String> deque, String str, int indexes, int index, boolean isAscend, String lastWritten) throws IOException {
        if (!deque.isEmpty()) {
            return notEmptyValidS(deque, str, indexes, index, isAscend);
        } else {
            return emptyValid(str, indexes, index, isAscend, lastWritten);
        }
    }
    public static boolean isValid(ArrayDeque<String> deque, String str, int indexes, int index, boolean isAscend, String lastWritten) throws IOException {
        if (!isString(str, indexes, index)) return false;
        return isStringValid(deque, str, indexes, index, isAscend, lastWritten);
    }

//Input Validations
    private static boolean isTypeValid(String str) {
        if (str.length() != 2) return true;
        if (str.charAt(0) != '-') return true;
        if (str.charAt(1) != 'i')
            return str.charAt(1) != 's';
        return false;
    }
    private static boolean isOrderValid(String str) {
        if (str.length() != 2) return false;
        if (str.charAt(0) != '-') return false;
        if (str.charAt(1) != 'a')
            return str.charAt(1) == 'd';
        return true;
    }
    private static boolean isFileValid(String path) {
        return !new File(path).exists();
    }
    private static boolean isInputValid4(String[] str) {
        if (isTypeValid(str[0])) return false;
        for (int i = 1; i < str.length; i++)
            if (isFileValid(str[i])) return false;
        return true;
    }
    private static boolean isInputValid5(String[] str) {
        if (!isOrderValid(str[0])) return false;
        if (isTypeValid(str[1])) return false;
        for (int i = 2; i < str.length; i++)
            if (isFileValid(str[i])) return false;
        return true;
    }
    public  static boolean isInputValid(String[] str) {
        if (str.length != 4 && str.length != 5)
            return false;
        if (str.length == 4)
            return isInputValid4(str);
        else
            return isInputValid5(str);
    }
}