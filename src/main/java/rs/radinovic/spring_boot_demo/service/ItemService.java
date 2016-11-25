package rs.radinovic.spring_boot_demo.service;

import rs.radinovic.spring_boot_demo.domain.Item;

import java.util.List;

public interface ItemService {

    long saveItem(Item item);

    Item findItem(long id);

    List<Item> findAllItems();

    Item updateItem(Item item);

    void deleteItem(long id);
}
