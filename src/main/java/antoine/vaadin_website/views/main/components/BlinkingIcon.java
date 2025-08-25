package antoine.vaadin_website.views.main.components;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;

public class BlinkingIcon extends Composite<Component> {

    @Override
    protected Component initContent() {
        var icon = new Icon(VaadinIcon.ARROW_RIGHT);
        icon.getStyle().setMarginRight("var(--lumo-space-xl)");
        icon.addClassName("right-arrow-fancy");

        UI.getCurrent()
            .getPage()
            .executeJs(
                """
                setTimeout(() => {
                    const icon = document.querySelector(`.right-arrow-fancy`)

                    gsap
                        .timeline({ 
                            repeat: -1, 
                            repeatDelay: 1,
                            delay: 1
                        })
                        .to(icon, {
                            xPercent: 200,
                            duration: 1,
                            ease: 'bounce.out',
                            yoyo: true,
                        });
                }, 10);
                """
            );

        return icon;
    }
}
