package magic.device.com.devicmagictask.data.model;

import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.util.List;

@Root(name = "downloads")
public class Downloads {

    @ElementList(entry = "item", inline = true, required = false)
    private List<String> items;

    public List<String> getItems () {
        return items;
    }
}
