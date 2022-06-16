package pl.agh.edu.dp.labirynth;
import pl.agh.edu.dp.builder.MazeBuilder;
import pl.agh.edu.dp.factory.BombedMazeFactory;
import pl.agh.edu.dp.factory.EnchantedMazeFactory;
import pl.agh.edu.dp.factory.MazeFactory;
import pl.agh.edu.dp.labirynth.MapSiteObjects.Door;
import pl.agh.edu.dp.labirynth.MapSiteObjects.Room;
import pl.agh.edu.dp.labirynth.MapSiteObjects.Wall;

public class MazeGame {
    // Mechanizm ktory zapewnia z pozycji kodu, ktory tworzy poszczegolne czesci labiryntu ze MazeFactory bedzie singletonem,
    // z racji ze MazeFactory jest interfacem to BombedMazeFactory i EnchantedMazeFactory sa singletonami.
    public void createMazeWithBombedFactory(MazeBuilder builder){
        createMaze( builder, BombedMazeFactory.getInstance() );
    }
    public void createMazeWithEnchantedFactory(MazeBuilder builder){
        createMaze( builder, EnchantedMazeFactory.getInstance() );
    }

    public void createMaze(MazeBuilder builder, MazeFactory mazeFactory){
        Room room1 = mazeFactory.createRoom(1);
        Room room2 = mazeFactory.createRoom(2);
        Room room3 = mazeFactory.createRoom(3);
        Wall wall12 = mazeFactory.createWall();
        Door door12 = mazeFactory.createDoor(room1, room2);
        Wall wall23 = mazeFactory.createWall();
        Door door23 = mazeFactory.createDoor(room2, room3);

        builder.addRoom(room1);
        builder.addRoom(room2);
        builder.addRoom(room3);
        builder.connectRooms(room1, room2, wall12, Direction.East);
        builder.addDoor(door12);
        builder.connectRooms(room2, room3, wall23, Direction.South);
        builder.addDoor(door23);


        //4.2.2
        // Teraz createMaze dostaje gotowe obiekty od factory i nie musi widziec jaka dokladnie fabryka
        // zwroci mu ten obiekt.
//
//        Room room1 = mazeFactory.createRoom(1);
//        Room room2 = mazeFactory.createRoom(2);
//        Wall wall12 = mazeFactory.createWall();
//        Door door12 = mazeFactory.createDoor(room1, room2);
//
//        builder.addRoom(room1);
//        builder.addRoom(room2);
//        builder.connectRooms(room1, room2, wall12, Direction.East);
//        builder.addDoor(door12);

        //4.1.3
        // Po tych zmianach kod stał się dużo bardziej przejrzysty, klasa mazeGame jedynie tworzy obiekty i daje je builderowi
        // aby on się nimi zajął i utworzył labirynt.
//
//        Room room1 = new Room(1);
//        Room room2 = new Room(2);
//        Wall wall12 = new Wall();
//        Door door12 = new Door(room1, room2);
//
//        builder.addRoom(room1);
//        builder.addRoom(room2);
//        builder.connectRooms(room1, room2, wall12, Direction.East);
//        builder.addDoor(door12);

    }
}
