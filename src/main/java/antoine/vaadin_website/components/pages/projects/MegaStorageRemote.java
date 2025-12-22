package antoine.vaadin_website.components.pages.projects;

import antoine.vaadin_website.components.InnerPage;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.html.Paragraph;

public class MegaStorageRemote extends Composite<InnerPage> {

    @Override
    protected InnerPage initContent() {
        var card = new InnerPage()
            .title(new Text("Android remote for MegaStorage 300CD"))
            .subtitle(
                new Text("Allows me to control my 'jukebox' CD player easily")
            )
            .body(
                new Paragraph(
                    "This CD player lets you add 300 CDs, yet you need to keep paper notes of which CD is at which position inside e.g. : 'Depeche Mode - Music for the Masses' is at position 23. Paper means you cannot modify it, search for names, and so on."
                ),
                new Paragraph(
                    "I wanted to software-ize this paper list, so I looked through a few ways to control the CD player using code. I had three options : simulating a keyboard via PS/2, using a dedicated data port, or simulating a remote via infrared. The keyboard option was tricky because it is mostly dedicated to entering CD metadata. The data port was too proprietary to figure out (connectics, protocols, ...). So the only option left was infrared, and it turned ou that my Xiaomi phone has an infrared emitter."
                ),
                new Paragraph(
                    "It looks easy on the surface, however infrared handling was a real challenge. There are no standards in infrared, everything is proprierary and this device especially is niche. Finding the proper infrared codes that correspond to the official remote buttons definitly had to be done through retro-engineering."
                ),
                new Paragraph(
                    "To retrieve all the infrared codes, I wired an infrared emitter component to a RaspberryPi and set up the necessary software on the Raspberry. Then I could press the remote's buttons, and the codes would show up in the ssh console. I had to make sure to get the codes in straight 'binary' (up/down times) and reformat them so that I could use them in my own code."
                ),
                new Paragraph(
                    "I managed to turn on and off my CD player through a button in my android app. From that point onward, it was just software implementation. Still, the aim was not to reproduce the remote but to replace the paper list to turn it into a 'Spotify-like' app. I used C# with .NET for Android to build the application to learn the language. The only challenge was the precision of the infrared blasts, espacially with combined instructions. For example, if I want to play 'Depeche Mode - Music for the Masses' which is at position 23, the app actually blasts 5 commands in a sequence : 'Choose disc', 'Two', 'Three', 'Enter', 'Play'. This is tackled by sending the given code 2 to 3 times in a row to make sure, but even with that the precision is not 100%."
                ),
                new Paragraph()
            );

        return card;
    }
}
