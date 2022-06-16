package pl.agh.edu.dp.labirynth;


public enum Direction {
    North, South, East, West;

    //ta funkcji jest bardzo przydatna poniewaz pokoje laczymy zawsze przeciwnymi scianami
    //lub sprawdzamy istnienie wspolnej sciany jako przeciwne sciany dwoch pokoi
    public static Direction oppositeDir(Direction d){
        switch (d) {
            case North:
                return South;
            case South:
                return North;
            case West:
                return East;
            case East:
                return West;
        }
        throw new IllegalArgumentException("No such direction as: "+d);
    }
}

