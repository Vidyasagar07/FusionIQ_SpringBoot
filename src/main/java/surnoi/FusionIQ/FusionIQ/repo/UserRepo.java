package surnoi.FusionIQ.FusionIQ.repo;


import org.springframework.data.jpa.repository.JpaRepository;
import surnoi.FusionIQ.FusionIQ.data.User;
import java.util.Optional;
public interface UserRepo extends JpaRepository<User,Long> {
    static User save() {
        return null;
    }
    User findByMail(String mail);
    boolean existsByMail(String email);
    void deleteHrById(Long id);
    Optional<User> findHrById(Long id);
    User findByMailAndPassword(String email, String password);
    User findByMailAndPasswordAndIsAdmin(String email, String password, boolean isAdmin);
}


