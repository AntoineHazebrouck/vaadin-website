package antoine.vaadin_website.views.main.components;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.dependency.JavaScript;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.dom.Style.Display;
import com.vaadin.flow.dom.Style.Overflow;
import com.vaadin.flow.dom.Style.Position;
import com.vaadin.flow.dom.Style.WhiteSpace;
import java.util.List;

@JavaScript("https://cdnjs.cloudflare.com/ajax/libs/gsap/3.12.5/gsap.min.js")
public class AutoplayCarousel extends Composite<Div> {

    private List<Component> items;

    public AutoplayCarousel(Component... items) {
        this(List.of(items));
    }

    public AutoplayCarousel(List<Component> items) {
        this.items = items;
    }

    @Override
    protected Div initContent() {
        var container = new Div();
        container.addClassName("banner-container");
        container
            .getStyle()
            .setWidth("50%")
            .setOverflow(Overflow.HIDDEN)
            .setPosition(Position.RELATIVE);

        var content = new Div();
        content.addClassName("banner-content");
        content
            .getStyle()
            .setDisplay(Display.FLEX)
            .setWhiteSpace(WhiteSpace.NOWRAP);

        var asSlides = items
            .stream()
            .map(item -> {
                Component wrap = new Div(item);
                wrap.getStyle().setPaddingLeft("10px").setPaddingRight("10px");
                return wrap;
            })
            .toList();

        content.add(asSlides);
        container.add(content);

        UI.getCurrent()
            .getPage()
            .executeJs(
                """
                setTimeout(() => {
                    const banner = document.querySelector('.banner-content')

                    gsap.to(banner, {
                        // x: () => scrollDistance,
                        xPercent: -100,
                        duration: 10,
                        ease: 'power1.inOut',
                        repeat: -1,
                        yoyo: true,
                        yoyoEase: 'power4.out',
                    });

                }, 10);
                """
            );
        return container;
    }
}
