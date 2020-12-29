import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ItemTest {
    @Test
    public void should_create_an_item() {
        assertThat(new Item("taskName").getName(),is("taskName"));
    }
    
    @Test
    public void should_return_item_index() {
        assertThat(new Item("taskName",1).getIndex(),is(1));
    }
    
}
