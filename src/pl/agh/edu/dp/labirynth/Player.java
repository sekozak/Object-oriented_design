package pl.agh.edu.dp.labirynth;
import pl.agh.edu.dp.labirynth.MapSiteObjects.Room;

public class Player {
    private Room currRoom;
    private int health;
    public Player(int hp){
        this.health=hp;
    }

    public void moveF(){ currRoom.getSide(Direction.North).Enter(this); }
    public void moveB(){ currRoom.getSide(Direction.South).Enter(this); }
    public void moveL(){ currRoom.getSide(Direction.West).Enter(this); }
    public void moveR(){ currRoom.getSide(Direction.East).Enter(this); }

    public void damage(int dmg){
        this.health-=dmg;
        if(this.health<0) this.health=0;
        System.out.println("Damage taken: "+dmg+" | current health: "+this.health );
    }

    public Room getCurrRoom() { return currRoom; }
    public void setCurrRoom(Room newRoom) { this.currRoom=newRoom; }
    public int getHealth() { return health; }
}
