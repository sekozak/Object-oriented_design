package pl.agh.edu.dp.factory;

import pl.agh.edu.dp.labirynth.MapSiteObjects.Door;
import pl.agh.edu.dp.labirynth.MapSiteObjects.Room;
import pl.agh.edu.dp.labirynth.MapSiteObjects.Wall;

//sugerujac sie wzorcem projektowym abstract-factory z interneru MazeFactory jest interfacem
public interface MazeFactory {
    Room createRoom(int number);
    Wall createWall();
    Door createDoor(Room room1, Room room2);
}
