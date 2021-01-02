import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Todo {
    private final ArgumentParse argumentParse;
    private List<Item> items = new ArrayList<>();
    private int itemIndex;
    private final String TOTAL = "Total: ";
    private final String ITEMS = " items";
    private final String COMMA = ",";
    private final String ITEM = " item";
    private final String DONE = " done";

    public Todo() {
        argumentParse = null;
    }

    public Todo(ArgumentParse argumentParse) {
        this.argumentParse = argumentParse;
    }


    public String add(Item item) {
        this.items.add(item);
        return item.formatItem() + item.formatAddItem();
    }

    public String listTodoItem() {

        String result = "";
        for (Item item : items) {
            if (item.isTodo()) {
                result += item.formatItem();
            }
        }
        result += formatTotalItems(getTodoItemsNumber());
        return result;
    }

    public String listAll() {
        String result = "";
        for (Item item : items) {
            result += item.formatItem();
        }
        result += formatTotalItems(getItemsSize()) + COMMA + formatDoneItems();
        return result;
    }

    public ItemStatus getItemStatus(int itemIndex) {
        return getItemByIndex(itemIndex).getStatus();
    }

    private Item getItemByIndex(int itemIndex) {
        if(itemIndex>items.size()){
            System.out.println("Invalid done item index,please check it");
            System.out.println(listAll());
            return null;
        }
        return items.get(itemIndex - 1);
    }

    public String finish(int itemIndex) {
        Item item = getItemByIndex(itemIndex);
        if(item==null){
            return "";
        }
        item.done();
        return "Item " + itemIndex +DONE;
    }

    private String formatTotalItems(int number) {
        return TOTAL + number + chooseItemFormat(number);
    }

    private int getTodoItemsNumber() {
        int todoItemsCount = 0;
        for (Item item : items) {
            if (item.isTodo()) {
                todoItemsCount++;
            }
        }
        return todoItemsCount;
    }

    private String formatDoneItems() {
        int doneItems = getItemsSize() - getTodoItemsNumber();
        return doneItems + chooseItemFormat(doneItems) + DONE;
    }

    private String chooseItemFormat(int itemsNumber) {
        return itemsNumber < 2 ? ITEM : ITEMS;

    }

    private int getItemsSize() {
        return items.size();
    }

    public void record(String fileName) throws IOException {
        File todoListFile = new File(fileName);
        FileOutputStream fos = null;
        if (!todoListFile.exists()) {
            todoListFile.createNewFile();
        }
        fos = new FileOutputStream(todoListFile);
        String result = "";
        for (Item item : items) {
            result += item.formatItem();
        }
        fos.write(result.getBytes());
    }

    public String load(String fileName) throws IOException {
        String result = "";
        File todoListFile = new File(fileName);
        BufferedReader br = null;
        br = new BufferedReader(new FileReader(todoListFile));
        String temp;
        while ((temp = br.readLine()) != null) {
            result += temp;
        }
        return result;
    }

    public void run(String command) throws IOException {
        argumentParse.respondCommand(command);
        if(argumentParse.getCommand().equals("add")){
            itemIndex++;
            System.out.println(add(new Item(argumentParse.getName(),itemIndex)));
        }
        if(argumentParse.getCommand().equals("done")){
            int doneIndex = argumentParse.getDoneItemIndex();
            System.out.println(finish(doneIndex));
        }
        if(argumentParse.getCommand().equals("list")&&argumentParse.getListType()==ListType.TODO){
            System.out.println(listTodoItem());
        }
        if(argumentParse.getCommand().equals("list")&&argumentParse.getListType()==ListType.ALL){
            System.out.println(listAll());
        }

        record("TodoList.txt");
    }
}
