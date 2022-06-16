package pl.agh.edu.dp.labirynth.MapSiteObjects;

import pl.agh.edu.dp.labirynth.Direction;
import pl.agh.edu.dp.labirynth.Player;

public class EnchantedRoom extends Room {
    public EnchantedRoom(int number) {
        super(number);
        initWalls();
    }

    @Override
    public void Enter(Player player){
        super.Enter(player);
    }

    public void initWalls(){
        this.setSide(Direction.East, new EnchantedWall());
        this.setSide(Direction.West, new EnchantedWall());
        this.setSide(Direction.North, new EnchantedWall());
        this.setSide(Direction.South, new EnchantedWall());
    }
}
