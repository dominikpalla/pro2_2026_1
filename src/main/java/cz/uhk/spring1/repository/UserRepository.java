package cz.uhk.spring1.repository;

import cz.uhk.spring1.model.User;
import cz.uhk.spring1.model.dto.UserBasicsDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    UserBasicsDTO findByEmail(String email);
}
