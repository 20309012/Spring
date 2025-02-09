package labarary.labarairy.servise;

import labarary.labarairy.domin.Loan;
import labarary.labarairy.dto.LoanDto;
import labarary.labarairy.mapper.LoanMaper;
import labarary.labarairy.repository.BokRipository;


import labarary.labarairy.repository.LoanRipositor;
import labarary.labarairy.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
@Service
public class LoanService {

   private final LoanRipositor loanRipositor;
    private final UserRepository userRepository;
    private final BokRipository bokRipository;
    private final BokServise bookServise;
        private LoanMaper loanMaper;

    public LoanService(BokRipository bokRipository, BokServise bookServise, LoanMaper loanMaper, LoanRipositor loanRipositor, UserRepository userRepository) {
        this.bokRipository = bokRipository;
        this.bookServise = bookServise;
        this.loanMaper = loanMaper;
        this.loanRipositor = loanRipositor;
        this.userRepository = userRepository;
    }

    public LoanDto createLoan(LoanDto loanDto){
    Loan loan=loanMaper.ToEntity(loanDto);
  Loan loan1= loanRipositor.save(loan);
       return loanMaper.ToDto(loan1);
    }
    public LoanDto getByid(Long id){
        Loan loan=loanRipositor.findById(id).orElseThrow(()-> {
            return new RuntimeException("Loan by id notfound");

        });
        return loanMaper.ToDto(loan);
    }
    public List<LoanDto> getAll(){
      List<LoanDto>loanDtos=loanRipositor.findAll().stream().map(loanMaper::ToDto).collect(Collectors.toCollection(LinkedList::new));

       return loanDtos;
    }

    public void DeleteLoan(Long  id){
        Optional<Loan> loan=loanRipositor.findById(id);
        if(loan.isPresent()){
            loanRipositor.deleteById(id);
        }else {
            new RuntimeException("not by id");
        }

    }
    public LoanDto updete(LoanDto loanDto,Long id){

        Loan loan1=loanRipositor.findById(id).orElseThrow();
        Loan loan=loanMaper.ToEntity(loanDto);


        loan1.setReturnDate(loan.getReturnDate());
        loan1.setLoanDate(loan.getLoanDate());
        Loan loan2=loanRipositor.save(loan1);
        return loanMaper.ToDto(loan2);


    }

}