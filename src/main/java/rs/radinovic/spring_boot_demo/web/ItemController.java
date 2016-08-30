package rs.radinovic.spring_boot_demo.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import rs.radinovic.spring_boot_demo.domain.Item;
import rs.radinovic.spring_boot_demo.service.ItemService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/item")
public class ItemController {

    private final ItemService itemService;

    @Autowired
    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    long createItem(@RequestBody @Valid Item item) {
        return itemService.saveItem(item);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    Item findItem(@PathVariable("id") long id) {
        return itemService.findItem(id);
    }

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    List<Item> findAllItems() {
        return itemService.findAllItems();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    @ResponseBody
    Item updateItem(@PathVariable("id") long id, @RequestBody @Valid Item item) {
        item.setId(id);
        return itemService.updateItem(item);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    void deleteItem(@PathVariable("id") long id) {
        itemService.deleteItem(id);
    }
}
