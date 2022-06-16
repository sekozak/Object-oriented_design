package pl.agh.edu.dp.builder;
import pl.agh.edu.dp.labirynth.*;
import pl.agh.edu.dp.labirynth.MapSiteObjects.Door;
import pl.agh.edu.dp.labirynth.MapSiteObjects.Room;

public class StandardBuilderMaze implements MazeBuilder {
    private Maze currentMaze;
    public StandardBuilderMaze(){
        this.currentMaze = new Maze();
    }

    @Override
    public void addRoom(Room room) { this.currentMaze.addRoom(room); }
    @Override
    public void addDoor(Door door) {
        Room room1 = door.getRoom1();
        Room room2 = door.getRoom2();
        Direction commonDir = commonWall(room1, room2);
        connectRooms(room1, room2, door, commonDir);
    }

    //laczenie pokoi jest napisane w uniwersalny sposob, aby laczyc pokoje drzwiami lub sciana
    //lecz skutkuje to sprawdzeniem czy jako argumnet laczacy nie jest podany room
    @Override
    public void connectRooms(Room room1, Room room2, MapSite mapSite, Direction direction) {
        if( mapSite instanceof Room ) throw new IllegalArgumentException("Can't connect rooms with a room!");
        room1.setSide(direction, mapSite);
        room2.setSide(Direction.oppositeDir(direction), mapSite);
    }

    public Maze getCurrentMaze(){ return this.currentMaze; }

    //otrzymany kierunek wspolnej sciany jest dla pokoju podanego jako pierwszy argument
    private Direction commonWall(Room room1, Room room2){
        if(room1.getSide(Direction.East).equals(room2.getSide(Direction.West))) return Direction.East;
        else if(room1.getSide(Direction.West).equals(room2.getSide(Direction.East))) return Direction.West;
        else if(room1.getSide(Direction.South).equals(room2.getSide(Direction.North))) return Direction.South;
        else if(room1.getSide(Direction.North).equals(room2.getSide(Direction.South))) return Direction.North;
        throw new IllegalArgumentException("Common wall between "+room1.getRoomNumber()+" and "+room2.getRoomNumber()+" doesn't exist!");
    }
}
