package Labs.Lab3.MBean;

import Labs.Lab3.DBhits;

import javax.management.AttributeChangeNotification;
import javax.management.MBeanNotificationInfo;
import javax.management.Notification;
import javax.management.NotificationBroadcasterSupport;

public class Main extends NotificationBroadcasterSupport implements MainMBean {
    static int sequenceNumber = 0;
    @Override
    public int getLuckyHits() {
        return DBhits.getLuckyShots();
    }

    @Override
    public int getCountHits() {
        return DBhits.getCountHits();
    }

    @Override
    public void missAlert() {

        Notification notification = new AttributeChangeNotification(this,
                sequenceNumber++, System.currentTimeMillis(),
                "Miss hit((((((((((((((((((((((((((((((((", "hit", "String",
                "Lucky", "Miss");

        sendNotification(notification);
    }

    @Override
    public String statistics() {
        double ratio = DBhits.getCountHits();
        ratio -= DBhits.getLuckyShots();
        ratio /= DBhits.getCountHits();
        ratio *= 100;
        System.out.println(ratio + "<<<<<<<<<<<<<<");
        return "Процентное отношение промахов к общему числу точек: " + ratio + "%";
    }

    @Override
    public MBeanNotificationInfo[] getNotificationInfo(){
        String[] types = new String[]{
                AttributeChangeNotification.ATTRIBUTE_CHANGE
        };
        String name = AttributeChangeNotification.class.getName();
        String description = "Notification";
        MBeanNotificationInfo mBeanNotificationInfo = new MBeanNotificationInfo(types, name, description);
        return new MBeanNotificationInfo[]{mBeanNotificationInfo};
    }

}
