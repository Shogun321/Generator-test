package test1;

import org.jfugue.pattern.Pattern;
import org.jfugue.player.Player;

public class CellAutomata {
    public CellAutomata() {
        Pattern pattern = new Pattern("T[Allegro]");
        int N = 30;
        int CELLS = 7;
        boolean[] cells = new boolean[CELLS];      // cellular automaton at time t
        boolean[] old   = new boolean[CELLS];      // cellular automaton at time t-1
        cells[CELLS/2] = true;
        int brojac=0;
        for (int t = 0; t < N; t++){
            for (int i = 0; i < CELLS; i++){
                if(cells[i]) Nota(i+1, pattern);
                else    {     pattern.add(" "); }
            }
            for (int i = 0; i < CELLS; i++)
                old[i] = cells[i];
            for (int i = 1; i < CELLS - 1; i++)
                cells[i] = old[i-1] ^ old[i+1] ^ old[i];
        }

        Player player = new Player();
        player.play(pattern);
    }

    private void Nota(int i, Pattern pattern){
        switch (i){
            case 1: pattern.add(" C "); break;
            case 2: pattern.add(" D "); break;
            case 3: pattern.add(" E "); break;
            case 4: pattern.add(" F "); break;
            case 5: pattern.add(" G "); break;
            case 6: pattern.add(" A "); break;
            case 7: pattern.add(" B "); break;
            case 8: pattern.add(" C6 "); break;
            default: System.out.println("JBG"); break;
        }
    }
}
