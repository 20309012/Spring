package labarary.labarairy.servise;


import labarary.labarairy.domin.Bok;
import labarary.labarairy.dto.BookDto;
import labarary.labarairy.mapper.BokMaper;
import labarary.labarairy.repository.BokRipository;
//import labarary.labarairy.rowMaper.BokMapper;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BokServise {

    private BokRipository bokRipository;

    private  BokMaper bokMaper;

    public BokServise(BokRipository bokRipository, BokMaper bokMaper) {
        this.bokRipository = bokRipository;

        this.bokMaper = bokMaper;
    }


 public BookDto savebook(BookDto bookDto){
      Bok bok1=bokMaper.ToEntity(bookDto);
      Bok bok2=  bokRipository.save(bok1);
      return   bokMaper.ToDto(bok2);

    }
    public BookDto updete(Long id,BookDto bookDto){
        Bok book=bokMaper.ToEntity(bookDto);
        Bok book1=bokRipository.findById(id).orElseThrow();
        book1.setAuthor(book.getAuthor());
        book1.setTitle(book.getTitle());
        book1.setIsbn(book.getIsbn());
        book1.setName(book.getName());
        Bok book2=bokRipository.save(book1);
       return bokMaper.ToDto(book2);
    }
    public List<BookDto>getAll(){
        return bokRipository.findAll().stream().map(bokMaper::ToDto).collect(Collectors.toCollection(LinkedList::new));

    }
    public BookDto getname(String name){
       Bok bok= bokRipository.findByname(name);
       return bokMaper.ToDto(bok);
    }
    public void  delete(Long id){
        bokRipository.deleteById(id);
    }


    public Optional<Bok> get(Long id) {
        Optional<Bok> bok=bokRipository.findById(id);
        return bok;
    }
}
