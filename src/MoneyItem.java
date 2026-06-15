public class MoneyItem extends CheckItem {
    private int cost;

    public MoneyItem(String name, boolean completed, int cost) {
        super(name, completed);
        setCost(cost);
    }

    // getter
    @Override
    public int getCost() {
        return cost;
    }

    // setter
    public void setCost(int cost) {
        if (cost >= 0) {
            this.cost = cost;
        } else {
            this.cost = 0;
        }
    }

    @Override
    public String getInfo() {
        return "[비용] " + getName() + " - " + cost + "원 - " + getStatus();
    }
}
