package magic.device.com.devicmagictask.data.model;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name = "download")
public class Download {

    @Element(name = "item", required = false)
    private Item item;

    public Item getItem ()
    {
        return item;
    }
}
