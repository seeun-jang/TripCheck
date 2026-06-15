public class PackingItem extends CheckItem {

    public PackingItem(String name, boolean completed) {
        super(name, completed);
    }

    @Override
    public String getInfo() {
        return "[짐] " + getName() + " - " + getStatus();
    }
}
