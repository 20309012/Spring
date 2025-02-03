package labarary.labarairy.repository;



import labarary.labarairy.domin.Bok;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BokRipository extends JpaRepository<Bok,Long> {

    Bok findByname(String name);
}
