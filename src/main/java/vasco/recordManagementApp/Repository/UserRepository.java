package vasco.recordManagementApp.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vasco.recordManagementApp.model.User;
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByName(String name);
}
