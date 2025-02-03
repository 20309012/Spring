package labarary.labarairy.contoler;

import labarary.labarairy.domin.Bok;
import labarary.labarairy.dto.BookDto;
import labarary.labarairy.servise.BokServise;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
//import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
//@RequestMapping("/aps/book")
//@RequiredArgsConstructor
public class BocController {

   private BokServise bookServise;

    public BocController(BokServise bookServise) {
        this.bookServise = bookServise;
    }


    @PostMapping("/post")

    public ResponseEntity<BookDto>crateBook(@RequestBody BookDto bookDto){
        BookDto bookDto1=bookServise.savebook(bookDto);
        return new ResponseEntity<BookDto>(bookDto1, HttpStatus.CREATED);

    }
    @PutMapping("/id/{id}")

    public ResponseEntity<BookDto> updete(@RequestBody BookDto bookDto,@PathVariable Long id){
        BookDto bookDto1=bookServise.updete(id, bookDto);
        return ResponseEntity.ok(bookDto1);
    }
    @GetMapping("/name/{name}")

    public ResponseEntity<BookDto> getId(@PathVariable String name){
       BookDto bookDto =  bookServise.getname(name);
        return ResponseEntity.ok(bookDto);
    }
    @GetMapping("/all")

    public ResponseEntity <List<BookDto>> getAll(Long id){
        List<BookDto>books=bookServise.getAll();
        return ResponseEntity.ok(books);

    }
    @DeleteMapping("/id/{id}")

    public ResponseEntity<String>delite(@PathVariable Long id){
        bookServise.delete(id);
        return   ResponseEntity.ok("book by id"+id+"delete");
    }
}
