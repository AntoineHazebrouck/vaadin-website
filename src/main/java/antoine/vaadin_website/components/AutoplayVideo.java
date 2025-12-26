package antoine.vaadin_website.components;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.Html;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class AutoplayVideo extends Composite<Component> {

    private final String videoUrl;

    @Override
    protected Component initContent() {
        return new Html(
            """
            <video height="360" autoplay muted playsinline loop>
                <source src="%s" type="video/mp4">
                Your browser does not support the video tag.
            </video>
            """.formatted(videoUrl)
        );
    }
}
