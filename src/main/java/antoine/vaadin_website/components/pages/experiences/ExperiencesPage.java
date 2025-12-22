package antoine.vaadin_website.components.pages.experiences;

import antoine.vaadin_website.components.Page;
import antoine.vaadin_website.utils.Responsive;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment;
import com.vaadin.flow.component.orderedlayout.FlexComponent.JustifyContentMode;
import com.vaadin.flow.i18n.LocaleChangeEvent;
import com.vaadin.flow.i18n.LocaleChangeObserver;

public class ExperiencesPage
    extends Composite<Page>
    implements LocaleChangeObserver {

    private final H3 academicTitle = new H3();
    private final H3 professionalTitle = new H3();

    @Override
    protected Page initContent() {
        var education = Responsive.column(
            academicTitle,
            new ButInformatiqueCard(),
            new IngenieurInformatiqueCard()
        )
            .alignement(Alignment.CENTER)
            .padding("0")
            .build();

        var professional = Responsive.column(
            professionalTitle,
            new SocgenCard()
        )
            .alignement(Alignment.CENTER)
            .justify(JustifyContentMode.BETWEEN)
            .padding("0")
            .build();

        var page = new Page()
            .body(Responsive.row(education, professional).build());

        return page;
    }

    @Override
    public void localeChange(LocaleChangeEvent event) {
        academicTitle.setText(getTranslation("experiences.title.academic"));
        professionalTitle.setText(
            getTranslation("experiences.title.professional")
        );
    }
}
