package TrainingPlan;

import activities.Activity;
import activities.Hard;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class TrainingPlan implements Serializable {
    private int id;
    private List<Activity> activities;
    private LocalDate doDate;
    private boolean[] repeat;
    private int calories;

    //region Constructors
    public TrainingPlan(int id, List<Activity> activities, LocalDate doDate, boolean[] repeat) {
        this.id = id;
        this.activities = new ArrayList<>(activities);
        this.doDate = doDate;
        this.repeat = Arrays.copyOf(repeat, repeat.length);
        this.calories = activities.stream().mapToInt(Activity::getBurnedCalories).sum();
    }
    //endregion

    //region Getters And Setters
    public int getId() {
        return this.id;
    }
    public List<Activity> getActivities() { return new ArrayList<>(this.activities); }
    public LocalDate getDoDate() { return this.doDate; }
    public boolean[] getRepeat() { return Arrays.copyOf(this.repeat, this.repeat.length); }
    public int getCalories() { return this.calories; }
    public boolean containsHardActivity() {
        return this.getActivities().stream().anyMatch(a -> a instanceof Hard);
    }
    //endregion


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{TRAINING PLAN}--{");
        sb.append(" | ID: ");
        sb.append(id);
        sb.append(" | DO DATE: ");
        sb.append(doDate);
        sb.append(" | REPEAT: ");
        sb.append(Arrays.toString(repeat));
        sb.append(" | CALORIES: ");
        sb.append(calories);
        sb.append(" | ACTIVITIES: \n");
        this.activities.forEach(act -> sb.append("\t").append(act.toString()));
        sb.append("}\n");

        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TrainingPlan that = (TrainingPlan) o;
        return getId() == that.getId() &&
                getCalories() == that.getCalories() &&
                Objects.equals(getActivities(), that.getActivities()) &&
                Objects.equals(getDoDate(), that.getDoDate()) &&
                Objects.deepEquals(getRepeat(), that.getRepeat());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getActivities(), getDoDate(), Arrays.hashCode(getRepeat()), getCalories());
    }
}
