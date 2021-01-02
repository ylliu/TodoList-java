public class Item {


    private final String name;
    private int index;
    private ItemStatus status;

    public Item(String name) {
        this.name = name;
    }

    public Item(String name, int index) {
        this.name = name;
        this.index = index;
        this.status = ItemStatus.TODO;
    }

    public String getName() {
        return this.name;
    }

    public int getIndex() {
        return this.index;
    }

    public void done() {
        this.status = ItemStatus.DONE;
    }

    public ItemStatus getStatus() {
        return this.status;
    }

    public boolean isDone() {
        return this.status == ItemStatus.DONE;
    }

    public boolean isTodo() {
        return this.status == ItemStatus.TODO;
    }

    public String formatItem() {
        if (isTodo()) {
            return this.index + "." + this.name + " \n";
        }
        if (isDone()) {
            return this.index + ".[Done] " + this.name + " \n";
        }
        return "";
    }

    public String formatAddItem() {
        return "\n" + "Item " + this.index + " added";
    }
}
