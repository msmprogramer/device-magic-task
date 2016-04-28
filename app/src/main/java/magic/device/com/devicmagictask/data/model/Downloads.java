package magic.device.com.devicmagictask.data.model;

import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

@Root(name = "downloads")
public class Downloads {

    @ElementList(inline = true, required = false)
    private String[] items;

    public String[] getItem ()
    {
        return items;
    }
}
