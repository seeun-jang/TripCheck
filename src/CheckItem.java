public class CheckItem {
    private String name;
    private boolean completed;

    public CheckItem(String name, boolean completed) {
        this.name = name;
        this.completed = completed;
    }

    // getter
    public String getName() {
        return name;
    }

    public boolean isCompleted() {
        return completed;
    }

    // setter
    public void setName(String name) {
        this.name = name;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public String getStatus() {
        if (completed) {
            return "완료";
        } else {
            return "미완료";
        }
    }

    public int getCost() {
        return 0;
    }

    public String getInfo() {
        return name + " - " + getStatus();
    }
}
