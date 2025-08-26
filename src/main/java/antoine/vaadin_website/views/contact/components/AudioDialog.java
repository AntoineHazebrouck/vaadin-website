package antoine.vaadin_website.views.contact.components;

import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.Html;
import com.vaadin.flow.component.dialog.Dialog;

public class AudioDialog extends Composite<Dialog> {

    @Override
    protected Dialog initContent() {
        var video = new Html(
            """
            <audio controls>
                <source src="songs/sample-1.mp3" type="audio/mpeg">
                Your browser does not support the audio tag.
            </audio>
            """
        );
        return new Dialog(video);
    }

    public void open() {
        getContent().open();
    }
}
