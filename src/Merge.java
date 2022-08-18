import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.ArrayDeque;
import java.util.Objects;

public class Merge {
    private static void toEndOfJrCollectionAS(String[] paths, ArrayDeque<String>[] deque, int[] indexes) throws IOException {
        BufferedReader br1 = new BufferedReader(new FileReader(paths[0]));
        BufferedReader br2 = new BufferedReader(new FileReader(paths[1]));
        Path output = Path.of(paths[2]);
        String lastWritten = Character.toString((char) 0);
        boolean flag1 = true;
        boolean flag2 = true;

        while (flag1 || flag2) {
            flag1 = Reader.readFile(deque[0], br1, indexes, 0, true, lastWritten);
            flag2 = Reader.readFile(deque[1], br2, indexes, 1, true, lastWritten);
            while (!deque[0].isEmpty() && !deque[1].isEmpty())
                if (Validations.isAlphabet(deque[0].peekFirst(), deque[1].peekFirst(), true))
                    deque[2].add(Objects.requireNonNull(deque[0].pollFirst()));
                else
                    deque[2].add(Objects.requireNonNull(deque[1].pollFirst()));
            while (!deque[2].isEmpty()) {
                if (Validations.isAlphabet(lastWritten, deque[2].peekFirst(), true)) {
                    lastWritten = deque[2].pollFirst();
                    assert lastWritten != null;
                    Files.writeString(output,
                            lastWritten.concat("\n"),
                            StandardOpenOption.APPEND);
                } else deque[2].pollFirst();
            }
        }
    }
    private static void toEndOfJrCollectionDS(String[] paths, ArrayDeque<String>[] deque, int[] indexes) throws IOException {
        BufferedReader br1 = new BufferedReader(new FileReader(paths[0]));
        BufferedReader br2 = new BufferedReader(new FileReader(paths[1]));
        Path output = Path.of(paths[2]);
        String lastWritten = Character.toString((char) 254);
        boolean flag1 = true;
        boolean flag2 = true;

        while (flag1 || flag2) {
            flag1 = Reader.readFile(deque[0], br1, indexes, 0, false, lastWritten);
            flag2 = Reader.readFile(deque[1], br2, indexes, 1, false, lastWritten);
            while (!deque[0].isEmpty() && !deque[1].isEmpty())
                if (!Validations.isAlphabet(deque[0].peekFirst(), deque[1].peekFirst(),false)) {
                    deque[2].add(Objects.requireNonNull(deque[0].pollFirst()));
                }
                else {
                    deque[2].add(Objects.requireNonNull(deque[1].pollFirst()));
                }

            while (!deque[2].isEmpty()) {
                if (!Validations.isAlphabet(lastWritten, deque[2].peekFirst(), false)) {
                    lastWritten = deque[2].pollFirst();
                    assert lastWritten != null;
                    Files.writeString(output,
                            lastWritten.concat("\n"),
                            StandardOpenOption.APPEND);
                } else deque[2].pollFirst();
            }
        }
    }
    private static void toEndOfElderCollectionAS(String pathOutput, ArrayDeque<String>[] deque) throws IOException {
        Path output = Path.of(pathOutput);
        String lastWritten = Character.toString((char) 0);

        if (deque[0].isEmpty())
            while (!deque[1].isEmpty())
                deque[2].add(deque[1].pollFirst());
        else
            while (!deque[0].isEmpty())
                deque[2].add(deque[0].pollFirst());
        while (!deque[2].isEmpty())
            if (Validations.isAlphabet(lastWritten, deque[2].peekFirst(), true)) {
                lastWritten = deque[2].pollFirst();
                assert lastWritten != null;
                Files.writeString(output,
                        lastWritten.concat("\n"),
                        StandardOpenOption.APPEND);
            } else deque[2].pollFirst();
    }
    private static void toEndOfElderCollectionDS(String pathOutput, ArrayDeque<String>[] deque) throws IOException {
        Path output = Path.of(pathOutput);
        String lastWritten = Character.toString((char) 254);

        if (deque[0].isEmpty())
            while (!deque[1].isEmpty())
                deque[2].add(deque[1].pollFirst());
        else
            while (!deque[0].isEmpty())
                deque[2].add(deque[0].pollFirst());
        while (!deque[2].isEmpty())
            if (!Validations.isAlphabet(lastWritten, deque[2].peekFirst(), false)) {
                lastWritten = deque[2].pollFirst();
                assert lastWritten != null;
                Files.writeString(output,
                        lastWritten.concat("\n"),
                        StandardOpenOption.APPEND);
            } else {
                deque[2].pollFirst();
            }
    }
    public static void mergeListsS(String[] paths, boolean isAscend) throws IOException {
        ArrayDeque<String>[] deque = new ArrayDeque[3];
        int[] indexes = new int[2];
        for (int i = 0; i < 3; i++) {
            deque[i] = new ArrayDeque<>();
        }
        if (isAscend) {
            toEndOfJrCollectionAS(paths, deque, indexes);
            toEndOfElderCollectionAS(paths[2], deque);
        }
        else {
            toEndOfJrCollectionDS(paths, deque, indexes);
            toEndOfElderCollectionDS(paths[2], deque);
        }

    }


    private static void toEndOfJrCollectionAI(String[] paths, ArrayDeque<Integer>[] deque, int[] indexes) throws IOException {
        BufferedReader br1 = new BufferedReader(new FileReader(paths[0]));
        BufferedReader br2 = new BufferedReader(new FileReader(paths[1]));
        Path output = Path.of(paths[2]);
        int lastWritten = -2000000;
        boolean flag1 = true;
        boolean flag2 = true;

        while (flag1 || flag2) {
            flag1 = Reader.readFile(deque[0], br1, indexes, 0, true, lastWritten);
            flag2 = Reader.readFile(deque[1], br2, indexes, 1, true, lastWritten);
            while (!deque[0].isEmpty() && !deque[1].isEmpty())
                if (deque[0].peekFirst() <= deque[1].peekFirst())
                    deque[2].add(deque[0].pollFirst());
                else
                    deque[2].add(deque[1].pollFirst());
            while (!deque[2].isEmpty()) {
                if (lastWritten <= deque[2].peekFirst()) {
                    lastWritten = deque[2].pollFirst();
                    Files.writeString(output,
                            Integer.toString(lastWritten).concat("\n"),
                            StandardOpenOption.APPEND);
                } else deque[2].pollFirst();
            }
        }
    }
    private static void toEndOfJrCollectionDI(String[] paths, ArrayDeque<Integer>[] deque, int[] indexes) throws IOException {
        BufferedReader br1 = new BufferedReader(new FileReader(paths[0]));
        BufferedReader br2 = new BufferedReader(new FileReader(paths[1]));
        Path output = Path.of(paths[2]);
        int lastWritten = 2000000;
        boolean flag1 = true;
        boolean flag2 = true;

        while (flag1 || flag2) {
            flag1 = Reader.readFile(deque[0], br1, indexes, 0, false, lastWritten);
            flag2 = Reader.readFile(deque[1], br2, indexes, 1, false, lastWritten);
            while (!deque[0].isEmpty() && !deque[1].isEmpty())
                if (deque[0].peekFirst() >= deque[1].peekFirst()) {
                    deque[2].add(deque[0].pollFirst());
                }
                else {
                    deque[2].add(deque[1].pollFirst());
                }

            while (!deque[2].isEmpty()) {
                if (lastWritten >= deque[2].peekFirst()) {
                    lastWritten = deque[2].pollFirst();
                    Files.writeString(output,
                            Integer.toString(lastWritten).concat("\n"),
                            StandardOpenOption.APPEND);
                } else deque[2].pollFirst();
            }
        }
    }
    private static void toEndOfElderCollectionAI(String pathOutput, ArrayDeque<Integer>[] deque) throws IOException {
        Path output = Path.of(pathOutput);
        int lastWritten = -2000000;

        if (deque[0].isEmpty())
            while (!deque[1].isEmpty())
                deque[2].add(deque[1].pollFirst());
        else
            while (!deque[0].isEmpty())
                deque[2].add(deque[0].pollFirst());
        while (!deque[2].isEmpty())
            if (lastWritten <= deque[2].peekFirst()) {
                lastWritten = deque[2].pollFirst();
                Files.writeString(output,
                        Integer.toString(lastWritten).concat("\n"),
                        StandardOpenOption.APPEND);
            } else deque[2].pollFirst();
    }
    private static void toEndOfElderCollectionDI(String pathOutput, ArrayDeque<Integer>[] deque) throws IOException {
        Path output = Path.of(pathOutput);
        int lastWritten = 2000000;

        if (deque[0].isEmpty())
            while (!deque[1].isEmpty())
                deque[2].add(deque[1].pollFirst());
        else
            while (!deque[0].isEmpty())
                deque[2].add(deque[0].pollFirst());
        while (!deque[2].isEmpty())
            if (lastWritten >= deque[2].peekFirst()) {
                lastWritten = deque[2].pollFirst();
                Files.writeString(output,
                        Integer.toString(lastWritten).concat("\n"),
                        StandardOpenOption.APPEND);
            } else {
                deque[2].pollFirst();
            }
    }
    public static void mergeListsI(String[] paths, boolean isAscend) throws IOException {
        ArrayDeque<Integer>[] deque = new ArrayDeque[3];
        int[] indexes = new int[2];
        for (int i = 0; i < 3; i++) {
            deque[i] = new ArrayDeque<>();
        }
        if (isAscend) {
            toEndOfJrCollectionAI(paths, deque, indexes);
            toEndOfElderCollectionAI(paths[2], deque);
        }
        else {
            toEndOfJrCollectionDI(paths, deque, indexes);
            toEndOfElderCollectionDI(paths[2], deque);
        }
    }
}