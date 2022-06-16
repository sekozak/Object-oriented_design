package pl.agh.edu.dp.labirynth.MapSiteObjects;

import pl.agh.edu.dp.labirynth.Player;

public class BombedWall extends Wall {
    public BombedWall() {
        super();
    }

    @Override
    public void Enter(Player player){
        player.damage(1);
        System.out.println("You also can't walk through bombed walls!");
    }
}
