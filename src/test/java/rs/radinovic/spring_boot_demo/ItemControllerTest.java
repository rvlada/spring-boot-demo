package rs.radinovic.spring_boot_demo;

import org.junit.Before;
import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;
import rs.radinovic.spring_boot_demo.domain.Item;
import rs.radinovic.spring_boot_demo.service.ItemService;
import rs.radinovic.spring_boot_demo.web.ItemController;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

public class ItemControllerTest {

    private ItemService itemService;
    private MockMvc mockMvc;

    @Before
    public void setup() {
        itemService = mock(ItemService.class);
        this.mockMvc = standaloneSetup(new ItemController(itemService)).build();
    }

    @Test
    public void testFindAllItems() throws Exception {
        List<Item> items = createDummyItemsList(4);
        when(itemService.findAllItems()).thenReturn(items);
        this.mockMvc.perform(get("/api/items"))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json;charset=UTF-8"))
                .andExpect(jsonPath("$", hasSize(items.size())))
                .andExpect(jsonPath("$[0].id", is(Math.toIntExact(items.get(0).getId()))))
                .andExpect(jsonPath("$[0].name", is(items.get(0).getName())))
                .andExpect(jsonPath("$[0].description", is(items.get(0).getDescription())));

    }

    private List<Item> createDummyItemsList(int listSize) {
        List<Item> items = new ArrayList<>();
        for (int i = 0; i < listSize; i++) {
            Item item = new Item();
            item.setId(i + 1L);
            item.setName("item name " + i);
            item.setDescription("item description " + i);
            items.add(item);
        }
        return items;
    }
}
