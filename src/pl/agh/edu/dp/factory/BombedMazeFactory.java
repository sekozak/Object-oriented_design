package pl.agh.edu.dp.factory;

import pl.agh.edu.dp.labirynth.MapSiteObjects.*;

// Fabryka Bombed zwraca tylko deafultowe drzwi, a reszte obiektow Bombed.
public class BombedMazeFactory implements MazeFactory{
    private static BombedMazeFactory instance;
    // Stworznie statycznego pola i sprawdzanie instancji sprawia ze klasa BombedMazeFactory jest singletonem
    public static BombedMazeFactory getInstance() {
        if(instance==null){ instance = new BombedMazeFactory(); }
        return instance;
    }

    @Override
    public Room createRoom(int number) {
        return new BombedRoom(number);
    }

    @Override
    public Wall createWall() {
        return new BombedWall();
    }

    @Override
    public Door createDoor(Room room1, Room room2) {
        return new Door(room1, room2);
    }
}
