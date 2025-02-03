package labarary.labarairy.mapper;

import labarary.labarairy.domin.Bok;
import labarary.labarairy.domin.Loan;
import labarary.labarairy.domin.User;
import labarary.labarairy.dto.LoanDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring",uses = {})
public interface LoanMaper {
@Mapping(source = "userId",target = "user.id ")
@Mapping(source = "bookId",target = "book.id ")
    Loan ToEntity(LoanDto loanDto);
@Mapping(source ="user.id" ,target = "userId")
@Mapping(source =" book.id" ,target = "bookId")
    LoanDto ToDto(Loan loan);
}
