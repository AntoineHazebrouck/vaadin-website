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
        var video = new Html(
            """
            <video height="360" autoplay muted playsinline loop>
                <source src="%s" type="video/mp4">
                Your browser does not support the video tag.
            </video>
            """.formatted(videoUrl)
        );
        addAttachListener(event -> {
            video
                .getElement()
                .executeJs(
                    "this.muted = true; " + // Ensure the JS property is true
                    "this.playsInline = true; " +
                    "this.play().catch(err => console.error('Autoplay blocked:', err));"
                );
        });
        return video;
    }
}
