package com.jonas.date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 判断当前是否处于类似 2019-12-17 12:00:00-23:00:00 范围内
 *
 * @author shenjy 2019/12/17
 */
public class TimeLimitCheck {
    private Long[] dateIndex;

    public TimeLimitCheck(List<String> giftDate) {
        //现将数据缓存到数组里面
        List<Long> dateArray = new LinkedList<>();
        giftDate.forEach(line -> {
            if (!line.matches("\\d{4}-\\d{2}-\\d{2} \\d{2}:\\d{2}:\\d{2}-\\d{2}:\\d{2}:\\d{2}")) {
                return;
            }

            String date = line.substring(0, line.indexOf(" "));
            String timeStart = line.substring(line.indexOf(" ") + 1, line.lastIndexOf("-"));
            String timeEnd = line.substring(line.lastIndexOf("-") + 1);

            Long start = date2TimeStamp(date + " " + timeStart);
            Long end = date2TimeStamp(date + " " + timeEnd);

            //判断数据是否按顺序增加
            if (end > start && (dateArray.size() == 0 || start > dateArray.get(dateArray.size() - 1))) {
                dateArray.add(start);
                dateArray.add(end);
            }
        });

        this.dateIndex = new Long[dateArray.size()];
        dateArray.toArray(this.dateIndex);
    }

    /**
     * 二分查找寻找当前时间所在的范围，start为奇数时为有效范围，否则为无效范围
     *
     * @return 当前时间时否为加倍时间范围
     */
    public boolean check() {
        if (dateIndex.length == 0) {
            return false;
        }

        long current = System.currentTimeMillis();
        if (current < dateIndex[0] || current > dateIndex[dateIndex.length - 1]) {
            return false;
        }

        int start = 0;
        int end = this.dateIndex.length - 1;
        while (end - start > 1) {
            int middle = (start + end) / 2;
            if (current < dateIndex[middle]) {
                end = middle;
            } else {
                start = middle;
            }
        }

        return start % 2 == 0;
    }


    private Long date2TimeStamp(String date) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        try {
            return simpleDateFormat.parse(date).getTime();
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return 0L;
    }

    public static void main(String[] args) {
        List<String> list = Arrays.asList("2017-07-21 10:00:00-20:00:00");
        TimeLimitCheck rateDateCheck = new TimeLimitCheck(list);
        System.out.println(rateDateCheck.check());
    }
}
