package com.commandAPI.command.service;

import com.commandAPI.command.entity.Item;
import com.commandAPI.command.repository.ItemRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ItemService {
    private final ItemRepository itemRepository;

    public ItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public Item SaveItem(Item item) {
        try {
            return itemRepository.save(item);
        } catch (Exception e) {
            throw new RuntimeException("Failed to save item: "+ e.getMessage());
        }
    }

    public List<Item> fetchAllItems() {
        try {
            return itemRepository.findAll();
        } catch (Exception e) {
            throw new RuntimeException("Failed to fetch all items: " + e.getMessage());
        }
    }

    public Optional<Item> fetchItemById(Long id) {
        try {
            return itemRepository.findById(id);
        } catch (Exception e) {
            throw new RuntimeException("Failed to fetch item by ID: " + e.getMessage());
        }
    }

    public boolean deleteItem(Long id) {
        try {
            itemRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            throw new RuntimeException("Failed to delete product: " + e.getMessage());
        }
    }

    public Optional<Item> updateItem(Long id, Item updatedItem) {
        try {
            Optional<Item> existingItem = itemRepository.findById(id);
            if (existingItem.isPresent()) {
                Item item = existingItem.get();

                item.setProduct(updatedItem.getProduct());
                item.setQuantity(updatedItem.getQuantity());
                item.setObservation(updatedItem.getObservation());
                item.setState(updatedItem.getState());

                Item savedEntity = itemRepository.save(item);
                return Optional.of(savedEntity);
            } else {
                return Optional.empty();
            }
        } catch (Exception e) {
            throw new RuntimeException("Failed to update item: " + e.getMessage());
        }
    }

    public Optional<Item> updateItemState(Long id, Item.State state) {
        try {
            Optional<Item> existingItem = itemRepository.findById(id);

            if(existingItem.isPresent()) {
                Item item = existingItem.get();
                item.setState(state);

                Item savedItem = itemRepository.save(item);
                return Optional.of(savedItem);
            } else {
                return Optional.empty();
            }
        } catch (Exception e) {
            throw new RuntimeException("Failed to update item state: " + e.getMessage());
        }
    }
}
