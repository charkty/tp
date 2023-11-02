package essenmakanan.recipe;

public class Step {

    private String description;

    private Tag tag;

    private int estimatedDuration;

    public Step(String description, Tag tag) {
        this.description = description;
        this.tag = tag;
        this.estimatedDuration = 5;
    }

    public Step(String description) {
        // the parameter time has to follow the format "hours:minutes"
        this.description = description;
        this.estimatedDuration = 5;
        this.tag = Tag.ACTUAL_COOKING;
    }

    public Step(String description, Tag tag, int estimatedDuration) {
        this.description = description;
        this.tag = tag;
        this.estimatedDuration = estimatedDuration;
    }

    public Step(String description, int estimatedDuration) {
        this.description = description;
        this.estimatedDuration = estimatedDuration;
        this.tag = Tag.ACTUAL_COOKING;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Tag getTag() {
        return tag;
    }

    public void setTag(Tag tag) {
        this.tag = tag;
    }

    public int getEstimatedDuration() {
        return estimatedDuration;
    }

    public void setEstimatedDuration(int estimatedDuration) {
        this.estimatedDuration = estimatedDuration;
    }

    @Override
    public String toString() {
        return "You need to " + getDescription() + " for " + estimatedDuration + " minutes.";
    }
}
