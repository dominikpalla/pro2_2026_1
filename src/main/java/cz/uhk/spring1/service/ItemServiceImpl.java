package cz.uhk.spring1.service;

import cz.uhk.spring1.model.Item;
import cz.uhk.spring1.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemServiceImpl implements ItemService {

    private ItemRepository itemRepository;

    @Autowired
    public ItemServiceImpl(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @Override
    public void saveItem(Item item) {
        itemRepository.save(item);
    }

    @Override
    public Item getItem(long id) {
        return itemRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteItem(long id) {
        Item item = getItem(id);
        if(item != null){
            itemRepository.delete(item);
        }
    }

    @Override
    public List<Item> getAllItems() {
        return itemRepository.findAll();
    }

}
