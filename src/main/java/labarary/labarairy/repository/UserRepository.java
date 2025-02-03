package labarary.labarairy.repository;

import labarary.labarairy.domin.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    Optional<User> findByname(String name);

    Optional<Object> findByRole(String admin);

//   Optional<User> findname(String name);

   /// Optional<User> findByRole(String admin);
}