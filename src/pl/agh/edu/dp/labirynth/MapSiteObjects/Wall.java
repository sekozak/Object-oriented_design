package pl.agh.edu.dp.labirynth.MapSiteObjects;

import pl.agh.edu.dp.labirynth.Direction;
import pl.agh.edu.dp.labirynth.MapSite;
import pl.agh.edu.dp.labirynth.Player;

public class Wall extends MapSite {
    public Wall(){}

    @Override
    public void Enter(Player player){
        System.out.println("You can't walk through walls!");
    }

    @Override
    public String toString(){
        return "WALL";
    }
}
