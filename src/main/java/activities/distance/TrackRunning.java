package activities.distance;

import activities.DistanceAct;

public class TrackRunning extends DistanceAct {
    private boolean hurdleJump;

    //region Constructors
    public TrackRunning(int id, int idUser, int distance, boolean hurdleJump) {
        super(id, idUser, distance);
        this.hurdleJump = hurdleJump;
    }

    public TrackRunning(TrackRunning trackRunning) {
        super(trackRunning);
        this.hurdleJump = trackRunning.getHurdleJump();
    }
    //endregion

    //region Getters And Setters
    public boolean getHurdleJump() { return this.hurdleJump; }

    public void setHurdleJump(boolean hurdleJump) { this.hurdleJump = hurdleJump; }
    //endregion

    public void calculateCalories() {
        double hurdleImpact = (this.hurdleJump) ? 1.4 : 1;
        double caloriesMultiplierPerDistance = 0.07;

        int calories = (int) (caloriesMultiplierPerDistance*this.getDistance()*hurdleImpact); // 0.07*1000*1.4 = 98
        this.setBurnedCalories(calories);
    }

    @Override
    public String toString() {
        return  "TrackRunning -{ ID: " + this.getId() +
                " | NAME: " + this.getName() +
                " | BEGIN: " + this.getBegin().toString() +
                " | END: " + this.getEnd().toString() +
                " | BURNED CALORIES: " + this.getBurnedCalories() +
                " | ID_USER: " + this.getIdUser() +
                " | HEART_RATE: " + this.getHeartRate() +
                " | DISTANCE: " + this.getDistance() +
                " | HURDLE JUMP: " + this.getHurdleJump() +
                " }-\n";
    }

    public TrackRunning clone() { return new TrackRunning(this); }

}
