import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.util.Date;

/**
 * @Classname DateTime
 * @Description TODO
 * @DATE 2019/11/18 22:24
 * @Created by Administrator
 */
public class DateTime {

    private static void handleDate() {
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

    private static void handleTime() {
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

    private static void handleDateTime() {
        //2019-12-12 11:23:18
        String format = LocalDateTime.now(ZoneId.of("UTC+08:00")).format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        System.out.println(format);

        //2019-11-25T16:09:19.054
        LocalDateTime now = LocalDateTime.now();
        System.out.println(now);

        //2019-11-11T12:16:04
        LocalDateTime of = LocalDateTime.of(2019, Month.NOVEMBER, 11, 12, 16, 4);
        System.out.println(of);

        //2019-11-11
        LocalDate date = of.toLocalDate();
        System.out.println(date);
        //12:16:04
        LocalTime time = of.toLocalTime();
        System.out.println(time);

    }

    private static void format() {
        LocalDate now = LocalDate.now();
        //20191125
        String format1 = now.format(DateTimeFormatter.BASIC_ISO_DATE);
        //2019-11-25
        String format2 = now.format(DateTimeFormatter.ISO_LOCAL_DATE);
        //25/11/2019
        String format3 = now.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        System.out.println(format1);
        System.out.println(format2);
        System.out.println(format3);
    }

    private static void parse() {
        //2019-11-25T12:23:23
        LocalDateTime dateTime = LocalDateTime.parse("20191125 12:23:23", DateTimeFormatter.ofPattern("yyyyMMdd HH:mm:ss"));
        System.out.println(dateTime);

        //Mon Nov 25 12:23:23 CST 2019
        ZonedDateTime cnZonedDateTime = dateTime.atZone(ZoneId.of("UTC+08:00"));
        System.out.println(Date.from(cnZonedDateTime.toInstant()));

        //Mon Nov 25 20:23:23 CST 2019
        ZonedDateTime utcZonedDateTime = dateTime.atZone(ZoneId.of("UTC+00:00"));
        System.out.println(Date.from(utcZonedDateTime.toInstant()));

    }


    /**
     * https://www.liaoxuefeng.com/wiki/1252599548343744/1303871087444002
     * ZoneOffset utcZoneOffset = ZoneOffset.ofHours(0);
     * ZoneOffset cnZoneOffset = ZoneOffset.ofHours(8);
     * <p>
     * ZoneId utcZoneId = ZoneId.of("UTC+00:00");
     * <p>
     * ZoneId cnZoneId = ZoneId.of("UTC+08:00");
     * System.out.println(cnZoneId);
     * System.out.println(ZoneId.systemDefault());
     */

    private static void toDate(LocalDateTime dateTime) {
        ZonedDateTime zonedDateTime = dateTime.atZone(ZoneId.systemDefault());
        Date date = Date.from(zonedDateTime.toInstant());
        System.out.println(date);
    }

    private static void toLocal(Date date) {
        Instant instant = date.toInstant();
        LocalDateTime localDateTime = instant.atZone(ZoneId.systemDefault()).toLocalDateTime();
        System.out.println(localDateTime);
    }

    public static void main(String[] args) {
        parse();
    }
}
