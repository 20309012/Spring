package labarary.labarairy.repository;

import labarary.labarairy.domin.Loan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoanRipositor extends JpaRepository<Loan,Long> {
}
