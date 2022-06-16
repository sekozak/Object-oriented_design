package pl.agh.edu.dp.labirynth;
import java.io.IOException;

public class InitGame {
    private Maze maze;
    private Player player;
    public InitGame(Maze maze, Player player){
        this.maze=maze;
        this.player=player;
        this.player.setCurrRoom(maze.getFirstRoom());
    }

    public void startGame() throws IOException {
        System.out.println(player.getCurrRoom());
        char input='x';
        while(input!='q'){
            input=(char) System.in.read();
            switch (move(input)){
                case 0:
                    System.out.println("You lost!!");
                    return;
                case 1:
                    System.out.println("You won!!");
                    return;
                case 2:
                    System.out.println(player.getCurrRoom());
            }
        }
    }

    public int move(char input){
        switch(input) {
            case 'w':
                player.moveF();
                break;
            case 's':
                player.moveB();
                break;
            case 'a':
                player.moveL();
                break;
            case 'd':
                player.moveR();
                break;
            default:
                return -1;
        }
        if(player.getHealth()==0) return 0;
        if(player.getCurrRoom().equals(maze.getLastRoom())) return 1;
        return 2;
    }

}
