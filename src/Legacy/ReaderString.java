package Legacy;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.ArrayDeque;

public class ReaderString {
//    public static boolean readFile(ArrayDeque<String> deque, BufferedReader br, int[] indexes, int index, boolean isAscend, String lastWritten) throws IOException {
//        String str;
//        int i;
//        for (i = 0; i < 5; i++) {
//            if ((str = br.readLine()) == null) {
//                break;
//            }
//            else {
//                if (Legacy.ValidationsString.isValid(deque, str, indexes[index], index, isAscend, lastWritten)) {
//                    deque.add(str);
//                }
//                indexes[index]++;
//            }
//        }
//        return (i == 5);
//    }
//
//    private static void toEndOfSmallFileAscend(String[] paths, ArrayDeque<String>[] deque, int[] indexes) throws IOException {
//        BufferedReader br1 = new BufferedReader(new FileReader(paths[0]));
//        BufferedReader br2 = new BufferedReader(new FileReader(paths[1]));
//        Path output = Path.of(paths[2]);
//        String lastWritten = Character.toString((char) 0);
//        boolean flag1 = true;
//        boolean flag2 = true;
//
//        while (flag1 || flag2) {
//            flag1 = readFile(deque[0], br1, indexes, 0, true, lastWritten);
//            flag2 = readFile(deque[1], br2, indexes, 1, true, lastWritten);
//            while (!deque[0].isEmpty() && !deque[1].isEmpty())
//                if (Legacy.ValidationsString.isAlphabet(deque[0].peekFirst(), deque[1].peekFirst(), true))
//                    deque[2].add(deque[0].pollFirst());
//                else
//                    deque[2].add(deque[1].pollFirst());
//            while (!deque[2].isEmpty()) {
//                if (Legacy.ValidationsString.isAlphabet(lastWritten, deque[2].peekFirst(), true)) {
//                    lastWritten = deque[2].pollFirst();
//                    Files.writeString(output,
//                            lastWritten.concat("\n"),
//                            StandardOpenOption.APPEND);
//                } else deque[2].pollFirst();
//            }
//        }
//    }
//
//    private static void toEndOfSmallFileDescend(String[] paths, ArrayDeque<String>[] deque, int[] indexes) throws IOException {
//        BufferedReader br1 = new BufferedReader(new FileReader(paths[0]));
//        BufferedReader br2 = new BufferedReader(new FileReader(paths[1]));
//        Path output = Path.of(paths[2]);
//        String lastWritten = Character.toString((char) 254);
//        boolean flag1 = true;
//        boolean flag2 = true;
//
//        while (flag1 || flag2) {
//            flag1 = readFile(deque[0], br1, indexes, 0, false, lastWritten);
//            flag2 = readFile(deque[1], br2, indexes, 1, false, lastWritten);
//            while (!deque[0].isEmpty() && !deque[1].isEmpty())
//                if (!Legacy.ValidationsString.isAlphabet(deque[0].peekFirst(), deque[1].peekFirst(),false)) {
//                    deque[2].add(deque[0].pollFirst());
//                }
//                else {
//                    deque[2].add(deque[1].pollFirst());
//                }
//
//            while (!deque[2].isEmpty()) {
//                if (!Legacy.ValidationsString.isAlphabet(lastWritten, deque[2].peekFirst(), false)) {
//                    lastWritten = deque[2].pollFirst();
//                    Files.writeString(output,
//                            lastWritten.concat("\n"),
//                            StandardOpenOption.APPEND);
//                } else deque[2].pollFirst();
//            }
//        }
//    }
//
//    private static void restOfBigFileAscend(String pathOutput, ArrayDeque<String>[] deque) throws IOException {
//        Path output = Path.of(pathOutput);
//        String lastWritten = Character.toString((char) 0);
//
//        if (deque[0].isEmpty())
//            while (!deque[1].isEmpty())
//                deque[2].add(deque[1].pollFirst());
//        else
//            while (!deque[0].isEmpty())
//                deque[2].add(deque[0].pollFirst());
//        while (!deque[2].isEmpty())
//            if (Legacy.ValidationsString.isAlphabet(lastWritten, deque[2].peekFirst(), true)) {
//                lastWritten = deque[2].pollFirst();
//                Files.writeString(output,
//                        lastWritten.concat("\n"),
//                        StandardOpenOption.APPEND);
//            } else deque[2].pollFirst();
//    }
//
//    private static void restOfBigFileDescend(String pathOutput, ArrayDeque<String>[] deque) throws IOException {
//        Path output = Path.of(pathOutput);
//        String lastWritten = Character.toString((char) 254);
//
//        if (deque[0].isEmpty())
//            while (!deque[1].isEmpty())
//                deque[2].add(deque[1].pollFirst());
//        else
//            while (!deque[0].isEmpty())
//                deque[2].add(deque[0].pollFirst());
//        while (!deque[2].isEmpty())
//            if (!Legacy.ValidationsString.isAlphabet(lastWritten, deque[2].peekFirst(), false)) {
//                lastWritten = deque[2].pollFirst();
//                Files.writeString(output,
//                        lastWritten.concat("\n"),
//                        StandardOpenOption.APPEND);
//            } else {
//                deque[2].pollFirst();
//            }
//    }
//
//    public static void mergeLists(String[] paths, boolean isAscend) throws IOException {
//        ArrayDeque<String>[] deque = new ArrayDeque[3];
//        int[] indexes = new int[2];
//        for (int i = 0; i < 3; i++) {
//            deque[i] = new ArrayDeque<>();
//        }
//        if (isAscend) {
//            toEndOfSmallFileAscend(paths, deque, indexes);
//            restOfBigFileAscend(paths[2], deque);
//        }
//        else {
//            toEndOfSmallFileDescend(paths, deque, indexes);
//            restOfBigFileDescend(paths[2], deque);
//        }
//
//    }
}
