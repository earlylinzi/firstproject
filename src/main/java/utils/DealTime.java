package utils;


import java.util.Calendar;

public class DealTime {

    /** 空则符合时间段逻辑，不为空分别判断 */
    private static boolean inTimeSegment(String timeSegments) {
        if(null != timeSegments && !timeSegments.isEmpty()){
            /// 有可能有多个时间段  先split再遍历  限时抢购有可能有多个时间段
            String[] timeArray = timeSegments.split(";"); //time  10:00-12:00
            for(String time : timeArray){
                String[] periodArray = time.split("-");  // 10:00 12:00
                Calendar calStart=Calendar.getInstance();
                Calendar calEnd=Calendar.getInstance();

                String[] hourMini = periodArray[0].split(":");
                calStart.set(Calendar.HOUR_OF_DAY, Integer.parseInt(hourMini[0]));
                calStart.set(Calendar.MINUTE, Integer.parseInt(hourMini[1]));
                calStart.set(Calendar.SECOND, 0);

                hourMini = periodArray[1].split(":");
                calEnd.set(Calendar.HOUR_OF_DAY, Integer.parseInt(hourMini[0]));
                calEnd.set(Calendar.MINUTE, Integer.parseInt(hourMini[1]));
                calEnd.set(Calendar.SECOND, 0);
                long now = System.currentTimeMillis();
                if(now>=(calStart.getTime().getTime()/1000) && now<(calEnd.getTime().getTime()/1000) ){
                    return true ;
                }
            }
            return false ;
        }
        return true ;
    }
}
