package magic.device.com.devicmagictask.data.model;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name = "item")
public class Item {

    @Element(name = "value", required = false)
    private String value;

    @Element(name = "key", required = false)
    private String key;

    public String getValue() {
        return value;
    }

    public String getKey() {
        return key;
    }
}
