import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Exercises {

    public Calendar easterDate(Calendar date){

        BigDecimal year = new BigDecimal(date.get(Calendar.YEAR));
        MathContext mc = new MathContext(2,RoundingMode.DOWN);
        MathContext mc1 = new MathContext(1,RoundingMode.DOWN);
        BigDecimal four = new BigDecimal("4");
        BigDecimal houndret = new BigDecimal("100");
        BigDecimal two = new BigDecimal("2");

        BigDecimal a = year.remainder(new BigDecimal("19"));
        BigDecimal b = year.divide(houndret,mc);
        BigDecimal c = year.remainder(houndret);
        BigDecimal d = b.divide(four,mc1);
        BigDecimal e = b.remainder(four);

        BigDecimal f = (b.add(new BigDecimal("8")))
                .divide(new BigDecimal("25"),mc1);

        BigDecimal g = (
                b.subtract(f)
                .add(new BigDecimal("1")))
                .divide(new BigDecimal("3"),mc1);

        BigDecimal h = (new BigDecimal("19")
                        .multiply(a)
                        .add(b)
                        .subtract(d)
                        .subtract(g)
                        .add(new BigDecimal("15"))
                ).remainder(new BigDecimal("30"));

        BigDecimal i = c.divide(four,mc1);
        BigDecimal k = c.remainder(four);

        BigDecimal l = ((e.multiply(two))
                        .add(i.multiply(two))
                        .add(new BigDecimal("32"))
                        .subtract(i).subtract(h).subtract(k))
                .remainder(new BigDecimal("7"));

        BigDecimal m = (a.add((new BigDecimal("11").multiply(h))
                        .add((new BigDecimal("22").multiply(l)))
                        )).remainder(new BigDecimal("451"));

        BigDecimal p =(
                    h.add(l).subtract(new BigDecimal(7).multiply(m))
                    .add(new BigDecimal("114"))
                    ).remainder(new BigDecimal("31"));

        int easterDay = p.intValue() + 1;

        BigDecimal bigEasterMonth =
                (h.add(l)
                        .subtract(new BigDecimal("7").multiply(m))
                        .add(new BigDecimal("114")))
                .divide(new BigDecimal("31"),mc);
        int easterMonth = bigEasterMonth.intValue();
        int month;
        if (easterMonth==4) month = 4;
        else month = 3;

        int easterYear = year.intValue();

        GregorianCalendar easterDate = new GregorianCalendar(easterDay,month,easterYear);
        return easterDate;
    }

    public String poorCamelCase(String input) {

        String output;
        input = input.toLowerCase();

        char[] charArray = input.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            if (charArray[i] == 261) charArray[i] = 'a';
            if (charArray[i] == 263) charArray[i] = 'c';
            if (charArray[i] == 281) charArray[i] = 'e';
            if (charArray[i] == 322) charArray[i] = 'l';
            if (charArray[i] == 324) charArray[i] = 'n';
            if (charArray[i] == 243) charArray[i] = 'o';
            if (charArray[i] == 347) charArray[i] = 's';
            if (charArray[i] == 378) charArray[i] = 'z';
            if (charArray[i] == 380) charArray[i] = 'z';
        }


        //check if scope of chars is in from a to Z
        for (char chars :
                charArray) {
            if (!((chars >= 'a' && chars <= 'z') || (chars >= 'A' && chars <= 'Z') || chars == ' ')){
                System.out.println("Wrong set of chars, should be between a,z and A,Z");
            }
        }
        //first character will be uppercase
        if (charArray[0] >= 'a' && charArray[0] <= 'z' && charArray[0] != ' ') {
                charArray[0] = (char) (charArray[0] - 'a' + 'A');
        }
        for (int i = 1; i < charArray.length; i++) {
            if (isUppercase(charArray[i-1]) && charArray[i] != ' ' && charArray[i-1] != ' ') {
                if (isUppercase(charArray[i])) charArray[i] = (char) (charArray[i] - 'A' + 'a');
            }
            else if (!isUppercase(charArray[i-1]) && charArray[i] != ' ' && charArray[i-1] != ' '){
                if (!isUppercase(charArray[i])) charArray[i] = (char) (charArray[i] - 'a' + 'A');
            }
            else if (isUppercase(charArray[i-2]) && charArray[i] != ' ' && charArray[i-1] == ' ') {
                if (isUppercase(charArray[i])) charArray[i] = (char) (charArray[i] - 'A' + 'a');
            }
            else if (!isUppercase(charArray[i-2]) && charArray[i] != ' ' && charArray[i-1] == ' ') {
                if (!isUppercase(charArray[i])) charArray[i] = (char) (charArray[i] - 'a' + 'A');
            }
        }
        return new String(charArray);
    }

    public boolean isUppercase(char chari){
        if (chari>='A' && chari<='Z') return true;
        else return false;
    }

    public void changeSpacesIntoCamelCase(){

    }


    public static void main(String[] args) {
    Exercises exercises = new Exercises();
    Calendar calendar = exercises.easterDate(new GregorianCalendar(2016,10,23));
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMMM-YYYY");
                dateFormat.setTimeZone(calendar.getTimeZone());
        System.out.println(dateFormat.format(calendar.getTime()));

    }
}
