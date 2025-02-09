package labarary.labarairy.contoler;
import labarary.labarairy.domin.Loan;
import labarary.labarairy.dto.LoanDto;
import labarary.labarairy.servise.LoanService;
import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/loan")

public class LoanContolorel {

    private LoanService loanServise;

    public LoanContolorel(LoanService loanServise) {
        this.loanServise = loanServise;
    }

    @PostMapping("post")

    public ResponseEntity<LoanDto>create(@RequestBody LoanDto loanDto){
        LoanDto loanDto1=loanServise.createLoan(loanDto);
        return ResponseEntity.ok(loanDto1);

    }
    @GetMapping("all")
    public ResponseEntity<List<LoanDto>>getAll(){
        List<LoanDto>loans=loanServise.getAll();
        return ResponseEntity.ok(loans);
    }
    @GetMapping  ("/{id}")
    public ResponseEntity<LoanDto> getByid(@PathVariable Long id){
        LoanDto loanDto=loanServise.getByid(id);
        return ResponseEntity.ok(loanDto);
    }
    @PutMapping("/{id}")
    public ResponseEntity<LoanDto>updete(@RequestBody LoanDto loanDto,@PathVariable Long id){
        LoanDto loanDto1=loanServise.updete(loanDto, id);
        return ResponseEntity.ok(loanDto1);




    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delat(@PathVariable Long id){
       loanServise.DeleteLoan(id);
       return ResponseEntity.ok("loanBy"+id+"delete");


    }
}

