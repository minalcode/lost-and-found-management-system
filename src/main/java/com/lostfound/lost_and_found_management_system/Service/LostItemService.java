
package com.lostfound.lost_and_found_management_system.Service;

import com.lostfound.lost_and_found_management_system.Model.LostItem;
import com.lostfound.lost_and_found_management_system.Repository.LostItemRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LostItemService {

    private final LostItemRepository lostItemRepository;

    public LostItemService(LostItemRepository lostItemRepository) {
        this.lostItemRepository = lostItemRepository;
    }

    public LostItem addItem(LostItem lostItem) {
        return lostItemRepository.save(lostItem);
    }

    public List<LostItem> getAllItems() {
        return lostItemRepository.findAll();
    }

    public LostItem getItemById(Long id) {
        return lostItemRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Item not found with id: " + id));
    }

    public LostItem updateItem(Long id, LostItem lostItem) {
        LostItem existingItem = getItemById(id);

        existingItem.setItemName(lostItem.getItemName());
        existingItem.setDescription(lostItem.getDescription());
        existingItem.setCategory(lostItem.getCategory());
        existingItem.setLocation(lostItem.getLocation());
        existingItem.setStatus(lostItem.getStatus());
        existingItem.setContactInfo(lostItem.getContactInfo());

        return lostItemRepository.save(existingItem);
    }

    public void deleteItem(Long id) {
        LostItem existingItem = getItemById(id);
        lostItemRepository.delete(existingItem);
    }
}
