package magic.device.com.devicmagictask.data.model;

import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.util.List;

@Root(name = "downloads")
public class Downloads {

    @ElementList(inline = true, required = false)
    private List<Item> items;

    public List<Item> getItem ()
    {
        return items;
    }
}
