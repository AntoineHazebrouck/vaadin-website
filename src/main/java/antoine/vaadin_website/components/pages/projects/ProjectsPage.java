package antoine.vaadin_website.components.pages.projects;

import antoine.vaadin_website.components.Page;
import antoine.vaadin_website.utils.Responsive;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.theme.lumo.LumoUtility;

public class ProjectsPage extends Composite<Page> {

    @Override
    protected Page initContent() {
        Component card1 = new VaadinWebsite();
        Component card2 = new Rythm();
        Component card3 = new EmailAlerts();
        Component card4 = new DataClassifier();
        Component card5 = new AdsSocialNetwork();
        Component card6 = new MegaStorageRemote();

        card1.addClassNames(LumoUtility.Flex.ONE);
        card2.addClassNames(LumoUtility.Flex.ONE);
        card3.addClassNames(LumoUtility.Flex.ONE);
        card4.addClassNames(LumoUtility.Flex.ONE);
        card5.addClassNames(LumoUtility.Flex.ONE);

        var page = new Page()
            .body(
                Responsive.column(
                    Responsive.row(card1, card2).build(),
                    Responsive.row(card3, card4).build(),
                    Responsive.row(card5).build(),
                    Responsive.row(card6).build()
                ).build()
            )
            .title(new Text("My projects"));

        return page;
    }
}
