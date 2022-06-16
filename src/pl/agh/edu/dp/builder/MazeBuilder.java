package pl.agh.edu.dp.builder;

import pl.agh.edu.dp.labirynth.*;
import pl.agh.edu.dp.labirynth.MapSiteObjects.Door;
import pl.agh.edu.dp.labirynth.MapSiteObjects.Room;

public interface MazeBuilder {

    void addRoom(Room room);
    void addDoor(Door door);
    void connectRooms(Room room1, Room room2, MapSite mapSite, Direction direction);

}
