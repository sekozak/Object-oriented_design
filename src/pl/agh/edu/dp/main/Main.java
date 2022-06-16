package pl.agh.edu.dp.main;
import pl.agh.edu.dp.builder.CountingMazeBuilder;
import pl.agh.edu.dp.builder.StandardBuilderMaze;
import pl.agh.edu.dp.factory.BombedMazeFactory;
import pl.agh.edu.dp.factory.EnchantedMazeFactory;
import pl.agh.edu.dp.factory.MazeFactory;
import pl.agh.edu.dp.labirynth.*;
import java.io.IOException;

// Moja wersja gry polega na tym ze wersja enchanted sluzy do zwiedzania labiryntu,
// wersja bombed za kazde dotkniecie sciany zabiera 1hp, w wejscie do pokoju 2hp
// co ma byc utrudnieniem gdyz nie mozna bladzic za duzo po labiryncie i beztrosko szukac wyjscia.
// Gra zaczyna sie w pierwszym pokoju, a konczy po dotarciu do ostatniego.

public class Main {

    public static void main(String[] args) throws IOException {
        MazeGame mazeGame = new MazeGame();
        StandardBuilderMaze standardBuilderMaze = new StandardBuilderMaze();
        Player player = new Player(10);

        mazeGame.createMazeWithBombedFactory(standardBuilderMaze);
        Maze maze = standardBuilderMaze.getCurrentMaze();
        InitGame initGame = new InitGame(maze, player);
        initGame.startGame();


//        testSingletons();
    }

    private static void testSingletons(){
        // TEST na poprawnosc singletonow
        MazeFactory BombedMazeFactory1 = BombedMazeFactory.getInstance();
        MazeFactory BombedMazeFactory2 = BombedMazeFactory.getInstance();
        MazeFactory EnchantedMazeFactory1 = EnchantedMazeFactory.getInstance();
        MazeFactory EnchantedMazeFactory2 = EnchantedMazeFactory.getInstance();
        if( BombedMazeFactory1.equals(BombedMazeFactory2) ){
            System.out.println("BombedMazeFactory Singleton work!");
        }
        if( EnchantedMazeFactory1.equals(EnchantedMazeFactory2) ){
            System.out.println("EnchantedMazeFactory Singleton work!");
        }
    }
}
