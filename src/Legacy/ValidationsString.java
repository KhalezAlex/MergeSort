package Legacy;

import java.io.IOException;
import java.util.ArrayDeque;

public class ValidationsString {
//    public static boolean isAlphabet(String word1, String word2, boolean isAscend) {
//        for (int i = 0; i < Math.min(word1.length(), word2.length()); i++) {
//            if (Character.toLowerCase(word1.charAt(i)) != Character.toLowerCase(word2.charAt(i))) {
//                return (Character.toLowerCase(word1.charAt(i)) < Character.toLowerCase(word2.charAt(i)));
//            }
//        }
//        if (word1.length() == word2.length())
//            return isAscend;
//        else
//            return (word1.length() < word2.length());
//    }
//
//    private static void log(String str) throws IOException {
//        Logger.getLogger().log(str);
//    }
//
//    private static boolean isString(String str, int indexes, int index) throws IOException {
//        if (str.length() == 0) {
//            log("В файле " + (index + 1) + " строка " + (indexes + 1) + "- пуста.");
//            return false;
//        }
//        for (int i = 0; i < str.length(); i++) {
//            if (str.charAt(i) == ' ') {
//                log("В файле " + (index + 1) + " на " + (indexes + 1) + " строке есть пробел");
//                return false;
//            }
//        }
//        return true;
//    }
//
//    private static boolean notEmptyValid(ArrayDeque<String> deque, String str, int indexes, int index, boolean isAscend) throws IOException {
//        assert deque.peekLast() != null;
//        if (isAscend) {
//            if (isAlphabet(deque.peekLast(), str, true))
//                return true;
//            else {
//                log("В файле " + (index + 1) + " на " + (indexes + 1) + " строке - строка, не прошедшая сортировку");
//                return false;
//            }
//        } else {
//            if (!isAlphabet(deque.peekLast(), str, false))
//                return true;
//            else {
//                log("В файле " + (index + 1) + " на " + (indexes + 1) + " строке - строка, не прошедшая сортировку");
//                return false;
//            }
//        }
//    }
//
//    private static boolean emptyValid(String str, int indexes, int index, boolean isAscend, String lastWritten) throws IOException {
//        if (isAscend) {
//            if (isAlphabet(lastWritten, str, true))
//                return true;
//            else {
//                log("В файле " + (index + 1) + " на " + (indexes + 1) + " строке - строка, не прошедшая сортировку");
//                return false;
//            }
//        } else {
//            if (!isAlphabet(lastWritten, str, false))
//                return true;
//            else {
//                log("В файле " + (index + 1) + " на " + (indexes + 1) + " строке - строка, не прошедшая сортировку");
//                return false;
//            }
//        }
//    }
//
//    private static boolean isStringValid(ArrayDeque<String> deque, String str, int indexes, int index, boolean isAscend, String lastWritten) throws IOException {
//        if (!deque.isEmpty()) {
//            return notEmptyValid(deque, str, indexes, index, isAscend);
//        } else {
//            return emptyValid(str, indexes, index, isAscend, lastWritten);
//        }
//    }
//
//    public static boolean isValid(ArrayDeque<String> deque, String str, int indexes, int index, boolean isAscend, String lastWritten) throws IOException {
//        if (!isString(str, indexes, index)) return false;
//        return isStringValid(deque, str, indexes, index, isAscend, lastWritten);
//    }
}
