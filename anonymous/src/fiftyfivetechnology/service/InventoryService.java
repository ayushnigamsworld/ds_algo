package fiftyfivetechnology.service;

import fiftyfivetechnology.model.Item;

public class InventoryService {

    public Boolean isItemAvailable(String itemId) {
        // check for totalCount > 0 for itemId
        return true;
    }

    public void addItem(Item id, Integer quantity) {
        // increment the count by 1
    }

    public void removeItem(Item id) {
        // decrement the count by 1
    }
}
