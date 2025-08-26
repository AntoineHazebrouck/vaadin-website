package antoine.vaadin_website.views.main.components;

import antoine.vaadin_website.utils.Responsive;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment;
import com.vaadin.flow.component.orderedlayout.FlexComponent.JustifyContentMode;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class PointingArrows extends Composite<Component> {

    private final Component middle;

    @Override
    protected Component initContent() {
        var right = new Icon(VaadinIcon.ARROW_RIGHT);
        right.getStyle().setMarginRight("var(--lumo-space-xl)");
        right.addClassName("right-arrow-fancy");

        var left = new Icon(VaadinIcon.ARROW_LEFT);
        left.getStyle().setMarginLeft("var(--lumo-space-xl)");
        left.addClassName("left-arrow-fancy");

        UI.getCurrent()
            .getPage()
            .executeJs(
                """
                setTimeout(() => {
                    const right = document.querySelector(`.right-arrow-fancy`)
                    const left = document.querySelector(`.left-arrow-fancy`)

                    gsap
                        .timeline({
                            repeat: -1,
                            repeatDelay: 1,
                            delay: 1
                        })
                        .to(right, {
                            xPercent: 200,
                            duration: 1,
                            ease: 'bounce.out',
                            yoyo: true,
                        });
                    gsap
                        .timeline({
                            repeat: -1,
                            repeatDelay: 1,
                            delay: 1
                        })
                        .to(left, {
                            xPercent: -200,
                            duration: 1,
                            ease: 'bounce.out',
                            yoyo: true,
                        });
                    
                }, 10);
                """
            );

        return Responsive.row(right, middle, left)
            .alignement(Alignment.CENTER)
            .justify(JustifyContentMode.CENTER)
            .wrap()
            .build();
    }
}
