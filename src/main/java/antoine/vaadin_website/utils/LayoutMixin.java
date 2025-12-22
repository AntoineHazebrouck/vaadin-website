package antoine.vaadin_website.utils;

import com.vaadin.flow.component.html.ListItem;
import com.vaadin.flow.component.html.UnorderedList;

public interface LayoutMixin {
    default UnorderedList list(String... text) {
        var list = new UnorderedList();
        list.getStyle().setMargin("0");
        for (String string : text) {
            list.add(new ListItem(string));
        }
        return list;
    }
}
