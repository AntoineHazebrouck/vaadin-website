package antoine.vaadin_website.components;

import antoine.vaadin_website.utils.Responsive;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.Html;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.dialog.Dialog;

public class SongsDialog extends Composite<Dialog> {

    @Override
    protected Dialog initContent() {
        var audio = new Html(
            """
            <audio controls>
                <source src="songs/stoner-1.mp3" type="audio/mpeg">
                Your browser does not support the audio tag.
            </audio>
            """
        );
        audio.addClassName("modern-audio-player");

        var dialog = new Dialog();
        dialog.setHeaderTitle("Some of my songs");
        dialog.add(
            Responsive.column(
                new Text(
                    "Since I only play the guitar and the bass, the songs are quite raw ..."
                ),
                audio
            ).build()
        );
        return dialog;
    }

    public void open() {
        getContent().open();
    }
}
