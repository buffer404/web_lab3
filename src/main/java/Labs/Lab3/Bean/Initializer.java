package Labs.Lab3.Bean;

import Labs.Lab3.MBean.Main;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import javax.management.*;
import java.lang.management.ManagementFactory;

@Named("Main")
@ApplicationScoped
public class Initializer {
    public static Main mbean;
    public static void init() throws MalformedObjectNameException, NotCompliantMBeanException, InstanceAlreadyExistsException, MBeanRegistrationException {
        MBeanServer mbs = ManagementFactory.getPlatformMBeanServer();
        ObjectName name = new ObjectName("Labs.Lab3.MBean:type=Main");
        mbean = new Main();
        mbs.registerMBean(mbean, name);
        System.out.println("done");
    }
}
