import org.junit.Test;

import java.io.IOException;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class TodoTest {
    @Test
    public void should_add_an_new_item_to_todo_list() {
        int itemIndex = 1;
        Todo todo = new Todo();
        String output = todo.add(new Item("<play football>", itemIndex));
        assertThat(output, is("1.<play football> \n\nItem 1 added"));
    }

    @Test
    public void should_change_item_status_to_done_when_finished_an_item() {
        Todo todo = new Todo();
        int itemIndex = 1;
        todo.add(new Item("play football", itemIndex));
        assertThat(todo.finish(itemIndex),is("Item "+itemIndex+" done"));
        assertThat(todo.getItemStatus(itemIndex), is(ItemStatus.DONE));
    }

    @Test
    public void should_list_undo_items_in_default_situation() {
        Todo todo = new Todo();
        int itemIndex = 1;
        todo.add(new Item("<play football>", itemIndex));
        todo.add(new Item("<play basketball>", ++itemIndex));
        todo.add(new Item("<play tennis>", ++itemIndex));

        todo.finish(3);

        assertThat(todo.listTodoItem(), is("1.<play football> \n2.<play basketball> \nTotal: 2 items"));
    }

    @Test
    public void should_output_singular_form_item_when_only_one_item() {
        Todo todo = new Todo();
        int itemIndex = 1;
        todo.add(new Item("<play football>", itemIndex));

        assertThat(todo.listTodoItem(), is("1.<play football> \nTotal: 1 item"));
    }

    @Test
    public void should_list_all_items() {
        Todo todo = new Todo();
        int itemIndex = 1;
        todo.add(new Item("<play football>", itemIndex));
        todo.add(new Item("<play basketball>", ++itemIndex));
        todo.add(new Item("<play tennis>", ++itemIndex));

        todo.finish(3);

        assertThat(todo.listAll(),
                is("1.<play football> \n" +
                        "2.<play basketball> \n" +
                        "3.[Done] <play tennis> \n" +
                        "Total: 3 items,1 item done"));
    }

    @Test
    public void should_output_plural_form_when_more_than_one_items_were_done() {
        Todo todo = new Todo();
        int itemIndex = 1;
        todo.add(new Item("<play football>", itemIndex));
        todo.add(new Item("<play basketball>", ++itemIndex));
        todo.add(new Item("<play tennis>", ++itemIndex));

        todo.finish(2);
        todo.finish(3);

        assertThat(todo.listAll(),
                is("1.<play football> \n" +
                        "2.[Done] <play basketball> \n" +
                        "3.[Done] <play tennis> \n" +
                        "Total: 3 items,2 items done"));
    }

    @Test
    public void should_write_todo_list_to_local_file() throws IOException {
        Todo todo = new Todo();
        int itemIndex = 1;
        todo.add(new Item("<play football>", itemIndex));
        todo.add(new Item("<play basketball>", ++itemIndex));
        todo.add(new Item("<play tennis>", ++itemIndex));

        todo.record("todoList.txt");
        assertThat(todo.load("todoList.txt"), is("1.<play football> " +
                "2.<play basketball> " +
                "3.<play tennis> "));
    }

}
