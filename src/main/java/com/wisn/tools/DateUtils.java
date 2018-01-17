package com.wisn.tools;


import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/**
 * Created by wisn on 2017/10/8.
 */

public class DateUtils {
    /**
     * Times in millions of an hour
     */
    public static final long ONE_HOUR = 3600000;
    /**
     * Times in millions of a day
     */
    public static final long ONE_DAY = ONE_HOUR * 24;

    /**
     * 将时间字符串格式化成Date
     *
     * @param str
     * @param fmt
     * @return
     */
    public static Date getDateByStr(String str, String fmt) {
        if (str == null || str.length() == 0) return null;
        if (fmt == null || fmt.length() == 0) return null;
        SimpleDateFormat format = new SimpleDateFormat(fmt, Locale.CHINA);
        try {
            Date parse = format.parse(str);
            return parse;
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 将时间字符串格式化成Calendar
     *
     * @param str
     * @param fmt
     * @return
     */
    public static Calendar getCalendarByStr(String str, String fmt) {
        Date date = getDateByStr(str, fmt);
        if (date == null) return null;
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar;
    }

    /**
     * 将时间字符串格式化成 时间戳
     *
     * @param str
     * @param fmt
     * @return
     */
    public static long getDateTimeByStr(String str, String fmt) {
        Date date = getDateByStr(str, fmt);
        if (date != null) return date.getTime();
        return -1;
    }

    /**
     * 是否是相同的一天
     *
     * @param time1
     * @param time2
     * @return
     */
    public static boolean isSameDay(long time1, long time2) {
        Calendar c1 = Calendar.getInstance();
        c1.setTimeInMillis(time1);
        Calendar c2 = Calendar.getInstance();
        c2.setTimeInMillis(time2);
        return isSameDay(c1, c2);
    }

    /**
     * @param d
     * @param day 几天后 正数 几天前 负数
     * @return
     */
    public static Date getDateAfter(Date d, int day) {
        Calendar now = Calendar.getInstance();
        now.setTime(d);
        now.set(Calendar.DATE, now.get(Calendar.DATE) + day);
        return now.getTime();
    }

    /**
     *
     * @param d
     * @param MILLISECOND
     * @return
     */
    public static Date getDateAfterMilliseconds(Date d, int MILLISECOND) {
        Calendar now = Calendar.getInstance();
        now.setTime(d);
        now.set(Calendar.MILLISECOND, now.get(Calendar.MILLISECOND) + MILLISECOND);
        return now.getTime();
    }

    /**
     *
     * @param d
     * @param hour 几天后 正数 几天前 负数
     * @return
     */
    public static Date getDateAfterHours(Date d, int hour) {
        Calendar now = Calendar.getInstance();
        now.setTime(d);
        now.set(Calendar.HOUR, now.get(Calendar.HOUR) + hour);
        return now.getTime();
    }

    /**
     * 指定的两个日期是否同一天
     *
     * @param c1 {@link Calendar}
     * @param c2 {@link Calendar}
     * @return true, 相同；false，不同。
     */
    public static boolean isSameDay(Calendar c1, Calendar c2) {
        return c1.get(Calendar.YEAR) == c2.get(Calendar.YEAR)
                && c1.get(Calendar.MONTH) == c2.get(Calendar.MONTH)
                && c1.get(Calendar.DAY_OF_MONTH) == c2.get(Calendar.DAY_OF_MONTH);
    }

    /**
     * 是否同一周
     *
     * @param c1
     * @param c2
     * @return
     */
    public static boolean isSameWeek(Calendar c1, Calendar c2) {
        return isSameYear(c1, c2)
                && c1.get(Calendar.WEEK_OF_YEAR) == c2.get(Calendar.WEEK_OF_YEAR);
    }

    /**
     * 是否为同一个月
     *
     * @param c1
     * @param c2
     * @return
     */
    public static boolean isSameMonth(Calendar c1, Calendar c2) {
        return c1.get(Calendar.YEAR) == c2.get(Calendar.YEAR)
                && c1.get(Calendar.MONTH) == c2.get(Calendar.MONTH);
    }

    /**
     * 是否为同一年
     *
     * @param c1
     * @param c2
     * @return
     */
    public static boolean isSameYear(Calendar c1, Calendar c2) {
        return c1.get(Calendar.YEAR) == c2.get(Calendar.YEAR);
    }

    /**
     * 获取用于调试的时间信息
     *
     * @param timeInMillions
     * @return
     */
    public static String getSimpleDateInfo(long timeInMillions) {
        Calendar calendar = Calendar.getInstance();
        calendar.clear();
        calendar.setTimeInMillis(timeInMillions);
        return getSimpleDateInfo(calendar);
    }

    /**
     * 获取用于调试的时间信息
     *
     * @param calendar
     * @return
     */
    public static String getSimpleDateInfo(Calendar calendar) {
        return String.format(Locale.getDefault(), "[%d/%d/%d-%d:%d:%d]",
                calendar.get(Calendar.YEAR),
                calendar.get(Calendar.MONTH) + 1,
                calendar.get(Calendar.DAY_OF_MONTH),
                calendar.get(Calendar.HOUR_OF_DAY),
                calendar.get(Calendar.MINUTE),
                calendar.get(Calendar.SECOND));
    }

    /**
     * c1是否在c2
     *
     * @param c1 {@link Calendar} 指定 Calendar
     * @param c2 {@link Calendar} 目标 Calendar
     * @return true，之前；false，之后。
     */
    public static boolean isBefore(Calendar c1, Calendar c2) {
        return c1.get(Calendar.YEAR) < c2.get(Calendar.YEAR)
                || c1.get(Calendar.MONTH) < c2.get(Calendar.MONTH)
                || c1.get(Calendar.DAY_OF_MONTH) < c2.get(Calendar.DAY_OF_MONTH)
                || c1.get(Calendar.HOUR_OF_DAY) < c2.get(Calendar.HOUR_OF_DAY)
                || c1.get(Calendar.MINUTE) < c2.get(Calendar.MINUTE)
                || c1.get(Calendar.SECOND) < c2.get(Calendar.SECOND);
    }

    /**
     * 获取两个日期间的间隔天数
     *
     * @param c1 {@link Calendar}
     * @param c2 {@link Calendar}
     * @return 返回结果是负数，表示 c1在 c2之前；反之，c1在 c2之后。
     */
    public static long getInterval(Calendar c1, Calendar c2) {
        return (c1.getTimeInMillis() - c2.getTimeInMillis()) / ONE_DAY;
    }

    /**
     * 获取两个日期的间隔年数
     *
     * @param c1 {@link Calendar}
     * @param c2 {@link Calendar}
     * @return 返回结果是负数，表示 c1在 c2之前；反之，c1在 c2之后。
     */
    public static int getIntervalYear(Calendar c1, Calendar c2) {
        return c1.get(Calendar.YEAR) - c2.get(Calendar.YEAR);
    }

    /**
     * 获取一周中的第一天
     *
     * @param thatDayInWeek
     * @param firstDayOfWeek
     * @return
     */
    public static int getFirstDayInWeek(Calendar thatDayInWeek, int firstDayOfWeek) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(thatDayInWeek.getTimeInMillis());

        calendar.setFirstDayOfWeek(firstDayOfWeek);
        calendar.set(Calendar.HOUR_OF_DAY, 1);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.DAY_OF_WEEK, firstDayOfWeek);

        return calendar.get(Calendar.DAY_OF_MONTH);
    }


    /**
     * 获取一周中的最后一天
     *
     * @param thatDayInWeek  指定周的任意一天
     * @param firstDayOfWeek 周的第一天
     * @return
     */
    public static int getEndDayInWeek(Calendar thatDayInWeek, int firstDayOfWeek) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(thatDayInWeek.getTimeInMillis());

        calendar.setFirstDayOfWeek(firstDayOfWeek);
        calendar.set(Calendar.HOUR_OF_DAY, 23);
        calendar.set(Calendar.MINUTE, 59);
        calendar.set(Calendar.SECOND, 59);
        calendar.set(Calendar.DAY_OF_WEEK, getEndDayOfWeekByFirstDay(firstDayOfWeek));

        return calendar.get(Calendar.DAY_OF_MONTH);
    }


    /**
     * 根据一周开始的天获取这周结束的天
     *
     * @param firstDay 一周开始的天
     * @return
     */
    public static int getEndDayOfWeekByFirstDay(int firstDay) {
        final int end = firstDay - 1;
        return end == 0 ? 7 : end;
    }


    /**
     * 获取一个月的第一天离周首日的间隔。
     * <p/>
     * 如，2015-05-01，周首日为周日，05-01当天是周五，此时间隔为5.
     *
     * @param thatDayInMonth 指定月份中的任意一天
     * @param firstDayOfWeek 周首日
     * @return 指定月份第一天到周首日的间隔
     */
    public static int getIndexDayInWeekOfMonth(Calendar thatDayInMonth, int firstDayOfWeek) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(thatDayInMonth.getTimeInMillis());
        calendar.setFirstDayOfWeek(firstDayOfWeek);

        calendar.set(Calendar.DAY_OF_MONTH, 1);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        final int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
        return (dayOfWeek - firstDayOfWeek + 7) % 7;
    }

    /**
     * 获取一个月的最后一天离周末日的间隔
     * <p/>
     * 如，2015－05-31，周首日为周日，05-31当天是周日，此时离周末日的间隔是6.
     *
     * @param thatDayInMonth
     * @param firstDayOfWeek
     * @return
     */
    public static int getLastDayInWeekOfMonth(Calendar thatDayInMonth, int firstDayOfWeek) {
        final Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(thatDayInMonth.getTimeInMillis());

        calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
        calendar.set(Calendar.HOUR_OF_DAY, 23);
        calendar.set(Calendar.MINUTE, 59);
        calendar.set(Calendar.SECOND, 59);
        calendar.add(Calendar.DAY_OF_MONTH, 1);
        return getEndDayInWeek(calendar, firstDayOfWeek) % 7;
    }

    /**
     * 将数字统一成两位数展示
     *
     * @param number
     * @return
     */
    public static String getNumberInTwo(int number) {
        if (number < 10) {
            return "0" + number;
        }

        return String.valueOf(number);
    }

    /**
     * 格式化当前时间
     *
     * @param formater
     * @return
     */
    public static String format(String formater) {
        return format(formater, System.currentTimeMillis());
    }

    /**
     * 格式化时间
     *
     * @param formater
     * @param timeInMillions
     * @return
     */
    public static String format(String formater, long timeInMillions) {
        if (TextUtils.isEmpty(formater)) {
            formater = "yyyy-MM-dd HH:mm:ss";
        }

        if (0 == timeInMillions) {
            timeInMillions = System.currentTimeMillis();
        }

        final DateFormat format = new SimpleDateFormat(formater, Locale.getDefault());
        return format.format(new Date(timeInMillions));
    }


}
