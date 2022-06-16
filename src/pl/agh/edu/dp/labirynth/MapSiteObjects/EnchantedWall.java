package pl.agh.edu.dp.labirynth.MapSiteObjects;

import pl.agh.edu.dp.labirynth.Player;

public class EnchantedWall extends Wall {
    public EnchantedWall() {
        super();
    }

    @Override
    public void Enter(Player player){
        System.out.println("You also can't walk through enchanted walls!");
    }
}
