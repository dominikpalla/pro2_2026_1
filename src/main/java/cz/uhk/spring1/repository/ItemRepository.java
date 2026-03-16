package cz.uhk.spring1.repository;

import cz.uhk.spring1.model.Item;
import cz.uhk.spring1.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {

}
