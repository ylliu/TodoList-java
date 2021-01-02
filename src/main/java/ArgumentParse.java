import java.util.Arrays;
import java.util.List;

public class ArgumentParse {
    private String command;
    private String itemName;
    private int itemIndex;
    private ListType listType;

    public ArgumentParse() {
    }

    public void respondCommand(String command) {
        List<String> arguments = Arrays.asList(command.split(" "));
        this.command = arguments.get(1);
        if (this.command.equals("add"))
            this.itemName = command.substring(9);
        if (this.command.equals("done"))
            this.itemIndex = Integer.parseInt(command.substring(11, 12));
        if(this.command.equals("list")){
            if(arguments.size()==2){
                this.listType = ListType.TODO;
                return;
            }
            this.listType = ListType.ALL;
        }

    }

    public String getCommand() {
        return this.command;
    }

    public String getName() {
        return this.itemName;
    }

    public int getDoneItemIndex() {
        return this.itemIndex;
    }

    public ListType getListType() {
        return this.listType;
    }
}
