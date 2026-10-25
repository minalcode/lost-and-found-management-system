package com.lostfound.lost_and_found_management_system.Repository;



import com.lostfound.lost_and_found_management_system.Model.LostItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LostItemRepository extends JpaRepository<LostItem, Long> {
}
