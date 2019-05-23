package coordinate;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class CoordinateApp {
    public static void main(String[] args) {
        Scanner SCANNER = new Scanner(System.in);

        String input =SCANNER.nextLine();
        Matcher matcher = Pattern.compile("\\(\\d,\\d\\)(-\\(\\d,\\d\\))*").matcher(input);

        if (matcher.find()) {
            List<String> points = Arrays.asList(input.split("-"));
            System.out.println(points.stream().map(s -> s.substring(1, s.length()-1)).collect(Collectors.toList()));
        }
    }
}
