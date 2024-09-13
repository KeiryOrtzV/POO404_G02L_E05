package sv.edu.udb.util;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;
public class MatchDate {
// public static void main(String[] args) {
// compareTelephone("1999-03-08");
// }
public static boolean compareDate (String date) {
    String expresion="\\d{4}-\\d{2}-\\d{2}";
    Pattern pat = Pattern.compile(expresion);
    Matcher mat = pat.matcher(date);
    if (mat.matches()) {
        System.out.println("SI");
        return TRUE;
    }
    return FALSE;
} //Cierre del main
}