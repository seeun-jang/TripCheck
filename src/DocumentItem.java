public class DocumentItem extends CheckItem {

    public DocumentItem(String name, boolean completed) {
        super(name, completed);
    }

    @Override
    public String getInfo() {
        return "[서류] " + getName() + " - " + getStatus();
    }
}
