
package com.lostfound.lost_and_found_management_system.Controller;

import com.lostfound.lost_and_found_management_system.Model.LostItem;
import com.lostfound.lost_and_found_management_system.Service.LostItemService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/items")
public class LostItemController {

    private final LostItemService lostItemService;

    public LostItemController(LostItemService lostItemService) {
        this.lostItemService = lostItemService;
    }

    @PostMapping
    public LostItem addItem(@RequestBody LostItem lostItem) {
        return lostItemService.addItem(lostItem);
    }

    @GetMapping
    public List<LostItem> getAllItems() {
        return lostItemService.getAllItems();
    }

    @GetMapping("/{id}")
    public LostItem getItemById(@PathVariable Long id) {
        return lostItemService.getItemById(id);
    }

    @PutMapping("/{id}")
    public LostItem updateItem(
            @PathVariable Long id,
            @RequestBody LostItem lostItem) {
        return lostItemService.updateItem(id, lostItem);
    }

    @DeleteMapping("/{id}")
    public String deleteItem(@PathVariable Long id) {
        lostItemService.deleteItem(id);
        return "Item deleted successfully";
    }
}
