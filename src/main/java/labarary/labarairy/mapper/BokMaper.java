package labarary.labarairy.mapper;

import labarary.labarairy.domin.Bok;
import labarary.labarairy.dto.BookDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring",uses = {})
public interface BokMaper {
@Mapping(source = " ferstName",target = " name")
@Mapping(source = " bingTitle",target = " title")
@Mapping(source = " nameAuthor",target = " author")
@Mapping(source = " isbnCode",target = " isbn")

    Bok ToEntity(BookDto bookDto);
    @Mapping(source = " name",target = " ferstName")
    @Mapping(source = " title",target = " bingTitle")
    @Mapping(source = " author",target = " nameAuthor")
    @Mapping(source = " isbn",target = " isbnCode")
    BookDto ToDto(Bok bok);
}
