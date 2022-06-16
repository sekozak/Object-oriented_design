package pl.agh.edu.dp.labirynth.MapSiteObjects;

import pl.agh.edu.dp.labirynth.Direction;
import pl.agh.edu.dp.labirynth.MapSite;
import pl.agh.edu.dp.labirynth.Player;

import java.util.EnumMap;
import java.util.Map;

public class Room extends MapSite {
    private final int roomNumber;
    private Map<Direction, MapSite> sides;

    public Room(int number){
        this.sides = new EnumMap<>(Direction.class);
        this.roomNumber = number;
        this.initWalls();
    }

    //podczas tworzenia pokoju zakladam ze ma on 4 sciany i odrazu je tworze, drzwi moga pojawic sie dopiero
    //przy laczeniu dwoch pokoi
    public void initWalls(){
        this.setSide(Direction.East, new Wall());
        this.setSide(Direction.West, new Wall());
        this.setSide(Direction.North, new Wall());
        this.setSide(Direction.South, new Wall());
    }

    public MapSite getSide(Direction direction){
        return this.sides.get(direction);
    }
    public void setSide(Direction direction, MapSite ms){
        this.sides.put(direction, ms);
    }
    public int getRoomNumber(){
        return this.roomNumber;
    }

    @Override
    public void Enter(Player player){
        player.setCurrRoom(this);
        System.out.println("You are in room: "+roomNumber);
    }

    @Override
    public String toString(){
        String str="";
        for(Direction direction : Direction.values()){
            str+=direction+" "+getSide(direction)+"\n";
        }
        return str;
    }
}
