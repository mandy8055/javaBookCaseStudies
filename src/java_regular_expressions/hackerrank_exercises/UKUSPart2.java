package java_regular_expressions.hackerrank_exercises;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class UKUSPart2 {
    private static final Scanner sc = new Scanner(System.in);
    //= Pattern.compile("\\b[a-zA-Z]+(?:se|ze)\\b");
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
            System.out.println(getTotalCount(singleTestString, lineString));
        // Releasing the resources
        sc.close();
    }

    private static int getTotalCount(String testStr, String sentence){
        int count = 0;
        String temp = "";
        final String regex = "ou?r";
        if(testStr.endsWith("our") || testStr.endsWith("or"))
            temp = "\\b" + testStr.split(regex)[0] + regex + "\\b";
        else if(testStr.contains("or") || testStr.contains("our"))
            temp = testStr.split(regex)[0] + regex + testStr.split(regex)[1];
        // Constructing the regex for every test strings
        final Pattern p = Pattern.compile(temp);

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
