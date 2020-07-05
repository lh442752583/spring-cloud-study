package com.cz.springcloud.utils;


import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 说明：日期处理
 * 创建人：HGQ
 * 修改时间：2015年11月24日
 */
public class DateUtil {

    public static final long ONE_MINU = 60000;
    public static final long ONE_HOUR = 3600000;
    public static final long ONE_DAY = 86400000;

    private final static SimpleDateFormat yue = new SimpleDateFormat("yyyy-MM");
    private final static SimpleDateFormat sdfYear = new SimpleDateFormat("yyyy");
    private final static SimpleDateFormat sdfDay = new SimpleDateFormat("yyyy-MM-dd");
    private final static SimpleDateFormat sdfDays = new SimpleDateFormat("yyyyMMdd");
    private final static SimpleDateFormat sdfTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    private final static SimpleDateFormat sdfTimes = new SimpleDateFormat("yyyyMMddHHmmss");
    private final static SimpleDateFormat sdfTimeZ = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");

    public static String getEnTimes(String day) {
        try {
            Date parse = sdfDay.parse(day);
            return sdfTime.format(parse);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }



    /**
     * 根据date生成cron表达式
     *
     * @return
     */
    public static String getCron(Date date) {

        String[] str = new SimpleDateFormat("yyyy-MM-dd").format(date).toString().split("-");

        int month = Integer.parseInt(str[1]);

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int year = calendar.get(Calendar.YEAR);
        //int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DATE);
        int hours = calendar.get(Calendar.HOUR_OF_DAY);
        int minutes = calendar.get(Calendar.MINUTE);
        int seconds = calendar.get(Calendar.SECOND);
        return seconds + " " + minutes + " " + hours + " " + day + " " + month + " ? " + year;
    }





    /**
     * 获取YYYY格式
     *
     * @return
     */
    public static String getSdfTimes(Date date) {

        return sdfDay.format(date);
    }


    /**
     * 获取YYYY-MM格式
     *
     * @return
     */
    public static String getYue() {

        return yue.format(new Date());
    }

    //java获取当前月的天数
    public static int getDayOfMonth(){
        Calendar aCalendar = Calendar.getInstance(Locale.CHINA);
        int day = aCalendar.getActualMaximum(Calendar.DATE);
        return day;
    }

    /**
     * 获取YYYY格式
     *
     * @return
     */
    public static String getYear() {
        return sdfYear.format(new Date());
    }

    /**
     * 获取YYYY-MM-DD格式
     *
     * @return
     */
    public static String getDay() {
        return sdfDay.format(new Date());
    }

    /**
     * 获取YYYY-MM-DD格式
     *
     * @return
     */
    public static String getResultToString(Date date) {
       if(date == null){
           return "";
       }
        return sdfTime.format(date);
    }

    /**
     * 获取YYYY-MM-DD格式
     *
     * @return
     */
    public static Date getDayByCurrentTime(long currentTime) {

        return fomatDate2(sdfDay.format(new Date(currentTime)));
    }


    /**
     * 格式化日期
     *
     * @return
     */
    public static Date fomatDate2(String date) {
        try {
            return sdfDay.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }




    /**
     * 获取YYYYMMDD格式
     *
     * @return
     */
    public static String getDays() {
        return sdfDays.format(new Date());
    }

    /**
     * 获取YYYY-MM-DD HH:mm:ss格式
     *
     * @return
     */
    public static String getTime() {
        return sdfTime.format(new Date());
    }

    public static String getTime(Timestamp time) {
        return sdfTime.format(time);
    }

    public static String getTime(Date time) {
        return sdfDay.format(time);
    }

    /**
     * @param s
     * @param e
     * @return boolean
     * @throws
     * @Title: compareDate
     * @Description: TODO(日期比较 ， 如果s > = e 返回true 否则返回false)
     * @author fh
     */
    public static boolean compareDate(String s, String e) {
        if (fomatDate(s) == null || fomatDate(e) == null) {
            return false;
        }
        return fomatDate(s).getTime() >= fomatDate(e).getTime();
    }

    /**
     * 格式化日期
     *
     * @return
     */
    public static Date fomatDate(String date) {
        try {
            return sdfTime.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }



    /**
     * 格式化日期
     *
     * @return
     */
    public static Date fomatDateByPassageway(String date) {
        DateFormat fmt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            return fmt.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }


    /**
     * 格式化日期(案例)
     *
     * @return
     */
    public static Date fomatDateAl(String date) {
        //DateFormat fmt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        DateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
        try {
            return fmt.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }


    public static Date fomatYue(String date) {
        //DateFormat fmt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        DateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
        try {
            return fmt.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 格式化日期
     *
     * @return
     */
    public static Date fomatDateMouse(String date) {
        DateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
        try {
            return fmt.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 校验日期是否合法
     *
     * @return
     */
    public static boolean isValidDate(String s) {
        DateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
        try {
            fmt.parse(s);
            return true;
        } catch (Exception e) {
            // 如果throw java.text.ParseException或者NullPointerException，就说明格式不对
            return false;
        }
    }

    /**
     * @param startTime
     * @param endTime
     * @return
     */
    public static int getDiffYear(String startTime, String endTime) {
        DateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
        try {
            //long aa=0;
            int years = (int) (((fmt.parse(endTime).getTime() - fmt.parse(startTime).getTime()) / (1000 * 60 * 60 * 24)) / 365);
            return years;
        } catch (Exception e) {
            // 如果throw java.text.ParseException或者NullPointerException，就说明格式不对
            return 0;
        }
    }

    /**
     * <li>功能描述：时间相减得到天数
     *
     * @param beginDateStr
     * @param endDateStr
     * @return long
     * @author Administrator
     */
    public static long getDaySub(String beginDateStr, String endDateStr) {
        long day;
        Date beginDate = null;
        Date endDate = null;

        try {
            beginDate = sdfTime.parse(beginDateStr);
            endDate = sdfTime.parse(endDateStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        day = (endDate.getTime() - beginDate.getTime()) / (24 * 60 * 60 * 1000);
        //System.out.println("相隔的天数="+day);

        return day;
    }

    /**
     * 得到n天之后的日期
     *
     * @param days
     * @return yyyy-MM-dd HH:mm:ss
     */
    public static String getBeforeDayDateTime(String days) {
        int daysInt = Integer.parseInt(days);

        Calendar canlendar = Calendar.getInstance(); // java.util包
        canlendar.add(Calendar.DATE, -daysInt); // 日期减 如果不够减会将月变动
        Date date = canlendar.getTime();

        //SimpleDateFormat sdfd = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        SimpleDateFormat sdfd = new SimpleDateFormat("yyyy-MM-dd");
        String dateStr = sdfd.format(date);

        return dateStr;
    }

    /**
     * 得到n天之后的日期
     *
     * @param days
     * @return yyyy-MM-dd HH:mm:ss
     */
    public static String getAfterDayDateTime(String days) {
        int daysInt = Integer.parseInt(days);

        Calendar canlendar = Calendar.getInstance(); // java.util包
        canlendar.add(Calendar.DATE, daysInt); // 日期减 如果不够减会将月变动
        Date date = canlendar.getTime();

        SimpleDateFormat sdfd = new SimpleDateFormat("yyyy-MM-dd");
        String dateStr = sdfd.format(date);

        return dateStr;
    }


    /**
     * 指定日期加上天数后的日期
     *
     * @return
     * @throws ParseException
     */
    public static String plusDay(String timeParam, long day) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
        try {
            date = dateFormat.parse(timeParam);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        long time = date.getTime();
        day = day * 24 * 60 * 60 * 1000;
        time += day;
        Date newDate = new Date(time);
        return dateFormat.format(newDate);
    }

    /**
     * 得到n天之后的日期
     *
     * @param days
     * @return yyyy-MM-dd
     */
    public static String getAfterDayDate(String days) {
        int daysInt = Integer.parseInt(days);

        Calendar canlendar = Calendar.getInstance(); // java.util包
        canlendar.add(Calendar.DATE, daysInt); // 日期减 如果不够减会将月变动
        Date date = canlendar.getTime();

        SimpleDateFormat sdfd = new SimpleDateFormat("yyyy-MM-dd");
        String dateStr = sdfd.format(date);

        return dateStr;
    }

    /**
     * 得到n天之前的日期
     *
     * @param days
     * @return yyyy-MM-dd
     */
    public static String getBeforeDayDate(String days) {
        int daysInt = Integer.parseInt(days);

        Calendar canlendar = Calendar.getInstance(); // java.util包
        canlendar.add(Calendar.DATE, -daysInt); // 日期减 如果不够减会将月变动
        Date date = canlendar.getTime();

        SimpleDateFormat sdfd = new SimpleDateFormat("yyyy-MM-dd");
        String dateStr = sdfd.format(date);

        return dateStr;
    }

    /**
     * 得到n天之后是周几
     *
     * @param days
     * @return
     */
    public static String getAfterDayWeek(String days) {
        int daysInt = Integer.parseInt(days);
        Calendar canlendar = Calendar.getInstance(); // java.util包
        canlendar.add(Calendar.DATE, daysInt); // 日期减 如果不够减会将月变动
        Date date = canlendar.getTime();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String dateStr = sdf.format(date);
        return dateStr;
    }



    /**
     * 获取2个时间中的每一天
     *
     * @param beginDate endDate
     * @return
     */
    public static List<String> getEveryDate(String beginDate, String endDate) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        List<String> dateList = new ArrayList<>();

        try{
            Date dateOne = dateFormat.parse(beginDate);
            Date dateTwo = dateFormat.parse(endDate);

            Calendar calendar = Calendar.getInstance();

            calendar.setTime(dateOne);

            while(calendar.getTime().before(dateTwo)){
                dateList.add(dateFormat.format(calendar.getTime()));
                calendar.add(Calendar.DAY_OF_MONTH, 1);
            }
        } catch(Exception e){
            e.printStackTrace();
        }
        return dateList;
    }



    /**
     * 获取今天的日期
     *
     * @param
     * @return yyyy-MM-dd
     */
    public static String getToday() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return dateFormat.format(new Date());
    }




    /**
     * 字符串转时间戳
     */
    public static Long dateToStamp(String str) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = null;
        try {
            date = simpleDateFormat.parse(str);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date.getTime();

    }
    






}
