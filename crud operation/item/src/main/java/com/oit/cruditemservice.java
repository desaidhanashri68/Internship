package com.oit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class cruditemservice {
    @Autowired
    private CrudItemRepository crudItemRepository;

    public List<cruditem> getAllItems() {
        return crudItemRepository.findAll();
    }

    public cruditem getItemById(Long id) {
        return crudItemRepository.findById(id).orElse(null);
    }

    public cruditem createItem(cruditem item) {
        return crudItemRepository.save(item);
    }

    public cruditem updateItem(Long id, cruditem updatedItem) {
        cruditem existingItem = crudItemRepository.findById(id).orElse(null);
        if (existingItem != null) {
            existingItem.setName(updatedItem.getName());
            existingItem.setPrice(updatedItem.getPrice());
            return crudItemRepository.save(existingItem);
        }
        return null;
    }

    public void deleteItem(Long id) {
        crudItemRepository.deleteById(id);
    }
}
