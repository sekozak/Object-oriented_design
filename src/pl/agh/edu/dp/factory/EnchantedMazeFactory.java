package pl.agh.edu.dp.factory;
import pl.agh.edu.dp.labirynth.MapSiteObjects.*;


// Fabryka Enchanted zwraca tylko Enchanted objekty.
public class EnchantedMazeFactory implements MazeFactory{
    private static EnchantedMazeFactory instance;
    // Stworznie statycznego pola i sprawdzanie instancji sprawia ze klasa EnchantedMazeFactory jest singletonem
    public static EnchantedMazeFactory getInstance() {
        if(instance==null){ instance = new EnchantedMazeFactory(); }
        return instance;
    }

    @Override
    public Room createRoom(int number) {
        return new EnchantedRoom(number);
    }

    @Override
    public Wall createWall() {
        return new EnchantedWall();
    }

    @Override
    public Door createDoor(Room room1, Room room2) {
        return new EnchantedDoor(room1, room2);
    }
}
