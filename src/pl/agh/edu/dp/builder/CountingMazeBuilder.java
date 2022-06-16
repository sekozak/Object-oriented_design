package pl.agh.edu.dp.builder;

import pl.agh.edu.dp.labirynth.Direction;
import pl.agh.edu.dp.labirynth.MapSiteObjects.Door;
import pl.agh.edu.dp.labirynth.MapSite;
import pl.agh.edu.dp.labirynth.MapSiteObjects.Room;

public class CountingMazeBuilder implements MazeBuilder{
    private int roomCount, doorCount, wallCount;

    public CountingMazeBuilder(){
        this.roomCount=0;
        this.doorCount=0;
        this.wallCount=0;
    }

    public int getCounts(){ return this.roomCount+this.doorCount+this.wallCount; }

    //pokoj dodaje mi deafultowo 4 sciany przez modyfikacje klasy room
    @Override
    public void addRoom(Room room) {
        this.roomCount+=1;
        this.wallCount+=4;
    }

    //drzwi sie wstawia w miejsce sciany polaczonych pokoi
    @Override
    public void addDoor(Door door) {
        this.doorCount+=1;
        this.wallCount-=1;
    }

    //pokoje lacza sie i jedna sciana staje sie wspolna
    @Override
    public void connectRooms(Room room1, Room room2, MapSite mapSite, Direction direction) {
        this.wallCount-=1;
    }

}