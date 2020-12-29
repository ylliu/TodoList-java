public class Item {


    private final String name;
    private int index;

    public Item(String name) {
        this.name = name;
    }

    public Item(String name, int index) {
        this.name = name;
        this.index = index;
    }

    public String getName() {
        return this.name;
    }

    public int getIndex() {
        return this.index;
    }
}
