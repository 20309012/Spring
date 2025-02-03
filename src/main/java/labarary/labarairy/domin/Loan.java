package labarary.labarairy.domin;



import jakarta.persistence.*;
import org.springframework.lang.Nullable;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity

public class Loan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name = "user-id")
    private User user;

    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)

    @JoinColumn(name = "book-id",nullable = false)
    private Bok book;
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime  loanDate;
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime  returnDate;

    public Loan() {

    }

    public Loan(Long id, LocalDateTime loanDate, LocalDateTime returnDate) {
        this.id = id;
        this.loanDate = loanDate;
        this.returnDate = returnDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getLoanDate() {
        return loanDate;
    }

    public void setLoanDate(LocalDateTime loanDate) {
        this.loanDate = loanDate;
    }

    public LocalDateTime getReturnDate() {
        return returnDate;
    }

    public Bok getBook() {
        return book;
    }

    public void setBook(Bok book) {
        this.book = book;
    }

    public void setReturnDate(LocalDateTime returnDate) {
        this.returnDate = returnDate;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
