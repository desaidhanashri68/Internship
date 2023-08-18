package com.oit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/items")
public class cruditemController {
    @Autowired
    private cruditemservice crudItemService;

    @GetMapping
    public List<cruditem> getAllItems() {
        return crudItemService.getAllItems();
    }

    @GetMapping("/{id}")
    public cruditem getItemById(@PathVariable Long id) {
        return crudItemService.getItemById(id);
    }

    @PostMapping
    public cruditem createItem(@RequestBody cruditem item) {
        return crudItemService.createItem(item);
    }

    @PutMapping("/{id}")
    public cruditem updateItem(@PathVariable Long id, @RequestBody cruditem updatedItem) {
        return crudItemService.updateItem(id, updatedItem);
    }

    @DeleteMapping("/{id}")
    public void deleteItem(@PathVariable Long id) {
        crudItemService.deleteItem(id);
    }
}
