package java_regular_expressions.hackerrank_exercises;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
public class FindAWord {
    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args){
        int numberOfLines = sc.nextInt();
        sc.nextLine();
        // Reading the total lines given in the following program
        String lineString = readLines(numberOfLines);
        int testCases = sc.nextInt();
        // Reading the test Strings from the files
        String testStr = readLines(testCases + 1);
        // Trimming the leading or trailing spaces present in the program
        testStr = testStr.trim();
        // Splitting individual test strings from the complete string
        String[] arr = testStr.split("\\s");

        for(String singleTestString : arr)
            System.out.println(getTotalCountOfTheWord(singleTestString, lineString));
        // Releasing the resources
        sc.close();
    }
    private static int getTotalCountOfTheWord(String testStr, String sentence){
        int count = 0;
        // Constructing the regex for every test strings
        final Pattern p = Pattern.compile("\\b" +  testStr + "\\b");

        Matcher matchWord = p.matcher(sentence);
        while(matchWord.find()){
            count++;
        }
        return count;
    }

    private static String readLines(int numberOfLines){
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < numberOfLines; i++){
            sb.append(sc.nextLine());
            sb.append(" ");
        }
        return sb.toString();
    }
}
