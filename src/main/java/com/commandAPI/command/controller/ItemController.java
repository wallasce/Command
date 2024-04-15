package com.commandAPI.command.controller;

import com.commandAPI.command.entity.Item;
import com.commandAPI.command.service.ItemService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("command/api")
public class ItemController {
    private final ItemService itemService;

    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @PostMapping("/item/product-{productID}")
    public ResponseEntity<Item> saveItem(@PathVariable Long productID, @RequestBody Item item) {
        Item itemSaved = itemService.SaveItem(item, productID);
        return ResponseEntity.ok(itemSaved);
    }

    @GetMapping("/items")
    public ResponseEntity<List<Item>> getAllItems() {
        List<Item> items = itemService.fetchAllItems();
        return ResponseEntity.ok(items);
    }
}
