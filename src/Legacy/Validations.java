package Legacy;

import java.io.IOException;
import java.util.ArrayDeque;

public class Validations {
//    private static void log(String str) throws IOException {
//        Logger.getLogger().log(str);
//    }
//
//    private static boolean isValue(String str, int indexes, int index) throws IOException {
//        if (str.length() == 0) {
//            log("В файле " + (index + 1) + " строка " + (indexes + 1) + "- пуста.");
//            return false;
//        }
//        for (int i = 0; i < str.length(); i++) {
//            if (!Character.isDigit(str.charAt(i))) {
//                log("В файле " + (index + 1) + " на " + (indexes + 1) + " строке не число");
//                return false;
//            }
//        }
//        return true;
//    }
//
//    private static boolean notEmptyValid(ArrayDeque<Integer> deque, String str, int indexes, int index, boolean isAscend) throws IOException {
//        if (isAscend) {
//            if (deque.peekLast() <= Integer.parseInt(str))
//                return true;
//            else {
//                log("В файле " + (index + 1) + " на " + (indexes + 1) + " строке число, не прошедшее сортировку");
//                return false;
//            }
//        }
//        else {
//            if (deque.peekLast() >= Integer.parseInt(str))
//                return true;
//            else {
//                log("В файле " + (index + 1) + " на " + (indexes + 1) + " строке число, не прошедшее сортировку");
//                return false;
//            }
//        }
//    }
//
//    private static boolean emptyValid(String str, int indexes, int index, boolean isAscend, int lastWritten) throws IOException {
//        if (isAscend) {
//            if (lastWritten <= Integer.parseInt(str))
//                return true;
//            else {
//                log("В файле " + (index + 1) + " на " + (indexes + 1) + " строке число, не прошедшее сортировку");
//                return false;
//            }
//        }
//        else {
//            if (lastWritten >= Integer.parseInt(str))
//                return true;
//            else {
//                log("В файле " + (index + 1) + " на " + (indexes + 1) + " строке число, не прошедшее сортировку");
//                return false;
//            }
//        }
//    }
//    private static boolean isValueValid(ArrayDeque<Integer> deque, String str, int indexes, int index, boolean isAscend, int lastWritten) throws IOException {
//        if (!deque.isEmpty()) {
//            return notEmptyValid(deque, str, indexes, index, isAscend);
//        }
//        else {
//            return emptyValid(str, indexes, index, isAscend, lastWritten);
//        }
//    }
//
//    public static boolean isValid(ArrayDeque<Integer> deque, String str, int indexes, int index, boolean isAscend, int lastWritten) throws IOException {
//        if (!isValue(str, indexes, index)) return false;
//        return isValueValid(deque, str, indexes, index, isAscend, lastWritten);
//    }
}