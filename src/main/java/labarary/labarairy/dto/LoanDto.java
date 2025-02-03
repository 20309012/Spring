package labarary.labarairy.dto;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;




import java.time.LocalDateTime;

public class LoanDto {

    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime loanDate;
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime returnDate;
    private Long userId ;
    private Long bookId;
    public LoanDto() {
    }

    public LoanDto(LocalDateTime returnDate, LocalDateTime loanDate) {
        this.returnDate = returnDate;
        this.loanDate = loanDate;
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

    public void setReturnDate(LocalDateTime returnDate) {
        this.returnDate = returnDate;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getBookId() {
        return bookId;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }
}