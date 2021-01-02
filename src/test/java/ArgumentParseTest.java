import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ArgumentParseTest {
    @Test
    public void should_parse_add_command_type_from_argument() {
        ArgumentParse argumentParse = new ArgumentParse();
        argumentParse.respondCommand("todo add <play football>");
        assertThat(argumentParse.getCommand(),is("add"));
    }

    @Test
    public void should_parse_item_name_from_argument() {
        ArgumentParse argumentParse = new ArgumentParse();
        argumentParse.respondCommand("todo add <play football>");
        assertThat(argumentParse.getName(),is("<play football>"));
    }

    @Test
    public void should_parse_done_command_type_from_argument() {
        ArgumentParse argumentParse = new ArgumentParse();
        argumentParse.respondCommand("todo done <1>");
        assertThat(argumentParse.getCommand(),is("done"));
    }
    @Test
    public void should_parse_done_item_index_from_argument() {
        ArgumentParse argumentParse = new ArgumentParse();
        argumentParse.respondCommand("toto done <1>");
        assertThat(argumentParse.getDoneItemIndex(),is(1));
    }

    @Test
    public void should_parse_list_todo_command_from_argument() {
        ArgumentParse argumentParse = new ArgumentParse();
        argumentParse.respondCommand("todo list");
        assertThat(argumentParse.getListType(),is(ListType.TODO));
    }

    @Test
    public void should_parse_list_all_command_from_argument() {
        ArgumentParse argumentParse = new ArgumentParse();
        argumentParse.respondCommand("todo list --all");
        assertThat(argumentParse.getListType(),is(ListType.ALL));
    }

}
