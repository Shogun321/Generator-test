package test1;

import org.jfugue.pattern.Pattern;
import org.jfugue.player.Player;
import org.staccato.ReplacementMapPreprocessor;

import java.util.HashMap;
import java.util.Map;

public class Lindermier_primer_sajt {
    public Lindermier_primer_sajt() {
        // Specify the transformation rules for this Lindenmayer system
        Map rules = new HashMap() {{
            put("Cmajw", "Cmajw Fmajw");
            put("Fmajw", "Rw Bbmajw");
            put("Bbmajw", "Rw Fmajw");
            put("C5q", "C5q G5q E6q C6q");
            put("E6q", "G6q D6q F6i C6i D6q");
            put("G6i+D6i", "Rq Rq G6i+D6i G6i+D6i Rq");
            put("axiom", "axiom V0 I[Flute] Rq C5q V1 I[Tubular_Bells] Rq Rq Rq G6i+D6i V2 I[Piano] Cmajw E6q " +
                    "V3 I[Warm] E6q G6i+D6i V4 I[Voice] C5q E6q");
        }};

        // Set up the ReplacementMapPreprocessor to iterate 3 times
        // and not require brackets around replacements
        ReplacementMapPreprocessor rmp = ReplacementMapPreprocessor.getInstance();
        rmp.setReplacementMap(rules);
        rmp.setIterations(4);
        rmp.setRequireAngleBrackets(false);

        // Create a Pattern that contains the L-System axiom
        /*Pattern axiom = new Pattern("T120 " + "V0 I[Flute] Rq C5q "
                + "V1 I[Tubular_Bells] Rq Rq Rq G6i+D6i "
                + "V2 I[Piano] Cmajw E6q "
                + "V3 I[Warm] E6q G6i+D6i "
                + "V4 I[Voice] C5q E6q");
        */
        Pattern axiom = new Pattern("T120 " + "V0 I[Flute] C5q "
                + "V1 I[Tubular_Bells] G6i+D6i "
                + "V2 I[Piano] E6q "
                + "V3 I[Warm] G6i+D6i "
                + "V4 I[Voice] E6q C5q Bbmajw Rq Rq Fmajw");

        Player player = new Player();
        System.out.println(rmp.preprocess(axiom.toString(), null));
        player.play(axiom);
    }
}
