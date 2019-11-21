import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;

/**
 * @Classname DateTime
 * @Description TODO
 * @DATE 2019/11/18 22:24
 * @Created by Administrator
 */
public class DateTime {

    private static  void handleDate(){
        //构造指定年月日   2019-11-18
        LocalDate of = LocalDate.of(2019, 1, 10);
        System.out.println(of);

        //获取当前日期
        LocalDate localDate = LocalDate.now();
        String format1 = localDate.format(DateTimeFormatter.BASIC_ISO_DATE);
        System.out.println(format1);//20191118

        String format2 = localDate.format(DateTimeFormatter.ISO_DATE);
        System.out.println(format2);//2019-11-18

        int year = localDate.getYear();
        System.out.println(year);// 2019
        int y = localDate.get(ChronoField.YEAR);
        System.out.println(y);//2019

        Month month = localDate.getMonth();
        System.out.println(month);//NOVEMBER
        int m = localDate.get(ChronoField.MONTH_OF_YEAR);
        System.out.println(m);//11

        int dayOfYear = localDate.getDayOfYear();
        System.out.println(dayOfYear);//322

        int dayOfMonth = localDate.getDayOfMonth();
        System.out.println(dayOfMonth);//18
        int dm = localDate.get(ChronoField.DAY_OF_MONTH);
        System.out.println(dm);//18

        DayOfWeek dayOfWeek = localDate.getDayOfWeek();
        System.out.println(dayOfWeek);//MONDAY
        int dw = localDate.get(ChronoField.DAY_OF_WEEK);
        System.out.println(dw);//1
    }

    private static void handleTime(){
        LocalTime of = LocalTime.of(12, 24, 48);
        System.out.println(of);//12:24:48

        LocalTime now = LocalTime.now();
        String format1 = now.format(DateTimeFormatter.ISO_TIME);
        System.out.println(format1);//23:01:34.734

        int hour = now.getHour();
        System.out.println(hour);//23
        int h = now.get(ChronoField.HOUR_OF_DAY);
        System.out.println(h);//23

        int minute = now.getMinute();
        System.out.println(minute);//1
        int m = now.get(ChronoField.MINUTE_OF_HOUR);
        System.out.println(m);//1

        int second = now.getSecond();
        System.out.println(second);//34
        int s = now.get(ChronoField.SECOND_OF_MINUTE);
        System.out.println(s);//34
    }

    private static void handleDateTime(){

    }


    public static void main(String[] args) {

        handleTime();


    }
}
