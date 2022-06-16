package pl.agh.edu.dp.labirynth.MapSiteObjects;

import pl.agh.edu.dp.labirynth.Direction;
import pl.agh.edu.dp.labirynth.Player;

public class BombedRoom extends Room {
    public BombedRoom(int number) {
        super(number);
        initWalls();
    }

    @Override
    public void Enter(Player player){
        player.damage(2);
        super.Enter(player);
    }

    public void initWalls(){
        this.setSide(Direction.East, new BombedWall());
        this.setSide(Direction.West, new BombedWall());
        this.setSide(Direction.North, new BombedWall());
        this.setSide(Direction.South, new BombedWall());
    }
}
