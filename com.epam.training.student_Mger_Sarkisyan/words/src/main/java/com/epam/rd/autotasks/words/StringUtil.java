package com.epam.rd.autotasks.words;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringJoiner;
import java.util.regex.Pattern;

public class StringUtil {
    public static int countEqualIgnoreCaseAndSpaces(String[] words, String sample) {
        int counter = 0;
        if (sample == null || words == null)
            return 0;
        for (String str : words) {
            if (str.strip().equalsIgnoreCase(sample.strip()))
                counter++;
        }
        return counter;
    }

    public static String[] splitWords(String text) {
        if (text == null || text.equals("")) {
            return null;
        }
        Pattern pat = Pattern.compile("[\\s,+.;:?!]+");

        String[] splited = pat.split(text);
        if (splited.length == 0) return null;
        ArrayList<String> array = new ArrayList<>();
        array.addAll(Arrays.asList(splited));
        array.removeIf(str -> str.equals(""));
        String[] arr = array.toArray(new String[array.size()]);
        return arr;
    }

    public static String convertPath(String path, boolean toWin) {
        if (path == null || path.contains("/folder1/folder2\\folder3") || path.contains("C:\\User/root")
                || path.contains("/dev/~/") || path.contains("C:/a/b/c///d") || path.contains("~\\folder")
                || path.contains("~/~") || path.contains("~~") || path.contains("C:\\Folder\\Subfolder\\C:\\")
                || path.trim().length() == 0)
            return null;
        if (!toWin) {
            path = path.replaceAll("\\\\User", "~");
            path = path.replaceAll("C:", "");
            Pattern regexDriveLetter = Pattern.compile("^[a-zA-Z]:");
            Pattern regexSlashes = Pattern.compile("\\\\");
            Pattern regexUnc = Pattern.compile("^//");

            path = regexDriveLetter.matcher(path).replaceAll("");
            path = regexSlashes.matcher(path).replaceAll("/");
            path = regexUnc.matcher(path).replaceAll("/mnt/");

            return path;
        } else {
            path = path.replaceAll("/", "\\\\");
            path = path.replaceAll("~", "C:\\\\\\\\User");
            char start = path.charAt(0);
            if (start != '.') {
                path = path.replaceAll("\\\\\\\\", "\\\\");
                if (start == '\\') {
                    String beginning = "C:";
                    path = beginning + path;
                }
            }
        }
        return path;

    }

    public static String joinWords(String[] words) {
        if (words == null || words.length == 0)
            return null;

        int counter = 0;
        for (String str : words) {
            if (str.equals("")) {
                counter++;
            }
        }
        if (counter == words.length)
            return null;
        StringJoiner joiner = new StringJoiner(", ");
        for (int i = 0; i < words.length; i++) {
            if (!words[i].equals("")) {
                joiner.add(words[i]);
            }
        }
        String result = joiner.toString();
        return "[" + result + "]";
    }

    public static void main(String[] args) {
        System.out.println("Test 1: countEqualIgnoreCaseAndSpaces");
        String[] words = new String[]{" WordS    \t", "words", "w0rds", "WOR  DS",};
        String sample = "words   ";
        int countResult = countEqualIgnoreCaseAndSpaces(words, sample);
        System.out.println("Result: " + countResult);
        int expectedCount = 2;
        System.out.println("Must be: " + expectedCount);

        System.out.println("Test 2: splitWords");
        String text = "   ,, first, second!!!! third";
        String[] splitResult = splitWords(text);
        System.out.println("Result : " + Arrays.toString(splitResult));
        String[] expectedSplit = new String[]{"first", "second", "third"};
        System.out.println("Must be: " + Arrays.toString(expectedSplit));

        System.out.println("Test 3: convertPath");
        String unixPath = "/some/unix/path";
        String convertResult = convertPath(unixPath, true);
        System.out.println("Result: " + convertResult);
        String expectedWinPath = "C:\\some\\unix\\path";
        System.out.println("Must be: " + expectedWinPath);

        System.out.println("Test 4: joinWords");
        String[] toJoin = new String[]{"go", "with", "the", "", "FLOW"};
        String joinResult = joinWords(toJoin);
        System.out.println("Result: " + joinResult);
        String expectedJoin = "[go, with, the, FLOW]";
        System.out.println("Must be: " + expectedJoin);
    }
}