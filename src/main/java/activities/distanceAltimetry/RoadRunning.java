package activities.distanceAltimetry;

import activities.DistanceAndAltimetryAct;

public class RoadRunning extends DistanceAndAltimetryAct {
    private boolean windAgainst;

    //region Constructors
    public RoadRunning(int id, int idUser, int distance, int altimetry, boolean windAgainst) {
        super(id, idUser, distance, altimetry);
        this.windAgainst = windAgainst;
    }

    public RoadRunning(RoadRunning roadRunning) {
        super(roadRunning);
        this.windAgainst = roadRunning.getWindAgainst();
    }
    //endregion

    //region Getters And Setters
    public boolean getWindAgainst() { return this.windAgainst; }

    public void setWindAgainst(boolean windAgainst) { this.windAgainst = windAgainst; }
    //endregion

    public void calculateCalories() {
        double windImpact = (this.windAgainst) ? 1.5 : 1;
        double caloriesMultiplier = 0.05; // 0.05*(1000+2.2*200)*1.2 = 86.4

        int calories = (int) (caloriesMultiplier*(this.getDistance() + 2.2*this.getAltimetry())*windImpact);
        this.setBurnedCalories(calories);
    }

    @Override
    public String toString() {
        return  "RoadRunning -{ ID: " + this.getId() +
                " | NAME: " + this.getName() +
                " | BEGIN: " + this.getBegin().toString() +
                " | END: " + this.getEnd().toString() +
                " | BURNED CALORIES: " + this.getBurnedCalories() +
                " | ID_USER: " + this.getIdUser() +
                " | HEART_RATE: " + this.getHeartRate() +
                " | DISTANCE: " + this.getDistance() +
                " | ALTIMETRY: " + this.getAltimetry() +
                " | WIND AGAINST: " + this.getWindAgainst() +
                " }-\n";
    }

    public RoadRunning clone() { return new RoadRunning(this); }

}
