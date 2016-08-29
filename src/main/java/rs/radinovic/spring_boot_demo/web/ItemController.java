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
    @ResponseBody long createItem(@RequestBody @Valid Item item) {
        return itemService.saveItem(item);
    }

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    List<Item> findAllItems() {
        return itemService.findAllItems();
    }
}
