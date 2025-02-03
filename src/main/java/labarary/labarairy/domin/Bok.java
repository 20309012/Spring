package labarary.labarairy.domin;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.mapstruct.Mapper;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity

public class Bok implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String title;
    private String author;
    private String isbn;

    public String getName() {
        return name;
    }

    public Bok() {
    }
    @OneToMany(mappedBy = "book")
   private List<Loan>loans=new ArrayList<>();

    public List<Loan> getLoans() {
        return loans;
    }
//
//    public void setLoans(List<Loan> loans) {
//        this.loans = loans;
//    }

    public Bok(String author, Long id, String isbn, String name, String title) {
        this.author = author;
        this.id = id;
        this.isbn = isbn;
        this.name = name;
        this.title = title;
    }


    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setLoans(List<Loan> loans) {
        this.loans = loans;
    }
}
