package antoine.vaadin_website.components.pages.projects;

import antoine.vaadin_website.components.InnerPage;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.Text;

public class MegaStorageRemote extends Composite<InnerPage> {

    @Override
    protected InnerPage initContent() {
        var card = new InnerPage().title(new Text("qsdqsd"));

        return card;
    }
}
