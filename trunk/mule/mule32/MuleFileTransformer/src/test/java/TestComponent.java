

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.mule.api.MuleEventContext;
import org.mule.api.lifecycle.Callable;
import org.mule.api.config.MuleProperties;
import java.io.File;
import java.util.Iterator;
import java.util.Set;
import org.mule.api.transport.PropertyScope;

public class TestComponent implements Callable {

    private static Logger log = LogManager.getLogger(TestComponent.class);

    public TestComponent() {
        log.debug("creating test component");
    }

    @Override
    public Object onCall(MuleEventContext eventContext) throws Exception {

        Object o = eventContext.getMessage().getPayload();
        //
        // this is the property on the message that corresponds to the 
        // size of a correlation group
        //MuleProperties.MULE_CORRELATION_GROUP_SIZE_PROPERTY;

        log.debug("class " + o.getClass().getName());

        if (o instanceof File) {
            File f = (File) o;
            log.debug("file is " + f.getAbsolutePath());
        }

        Set<String> inboundSet = eventContext.getMessage().getPropertyNames(PropertyScope.INBOUND);

        Iterator<String> iS = inboundSet.iterator();
        while (iS.hasNext()) {
            String key = iS.next();
            Object prop = eventContext.getMessage().getProperty(key, PropertyScope.INBOUND);
            log.debug("inbound " + key + "--> " + prop.toString());
        }

        Set<String> outboundSet = eventContext.getMessage().getPropertyNames(PropertyScope.OUTBOUND);

        iS = outboundSet.iterator();
        while (iS.hasNext()) {
            String key = iS.next();
            Object prop = eventContext.getMessage().getProperty(key, PropertyScope.OUTBOUND);
            log.debug("outbound " + key + "--> " + prop.toString());
        }


        return null;
    }
}
