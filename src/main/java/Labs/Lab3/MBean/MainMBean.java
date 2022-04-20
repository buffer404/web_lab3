package Labs.Lab3.MBean;

import java.sql.SQLException;

public interface MainMBean {
    public int getLuckyHits();
    public int getCountHits();
    public void missAlert();
    public String statistics();
}
