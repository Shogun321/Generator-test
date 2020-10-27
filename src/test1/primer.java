package test1;

import org.jfugue.pattern.Pattern;
import org.jfugue.player.Player;


public class primer {
    public primer() {
        org.jfugue.pattern.Pattern pattern = new Pattern("T[Allegro]");
        pattern.add("V0 E5s D#5s | E5s D#5s E5s B4s D5s C5s " + "V1 Ri | Riii ");


        Player player = new Player();
        player.play(pattern);

    }
}