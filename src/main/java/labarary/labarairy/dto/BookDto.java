package labarary.labarairy.dto;

import lombok.Getter;
import org.mapstruct.Mapper;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import java.io.Serializable;


public class BookDto implements Serializable {

    private String ferstName;
    private String bingTitle;
    private String nameAuthor;
    private String isbnCode;

    public BookDto() {
    }

    public String getBingTitle() {
        return bingTitle;
    }

    public void setBingTitle(String bingTitle) {
        this.bingTitle = bingTitle;
    }

    public String getFerstName() {
        return ferstName;
    }

    public void setFerstName(String ferstName) {
        this.ferstName = ferstName;
    }

    public String getIsbnCode() {
        return isbnCode;
    }

    public void setIsbnCode(String isbnCode) {
        this.isbnCode = isbnCode;
    }

    public String getNameAuthor() {
        return nameAuthor;
    }

    public void setNameAuthor(String nameAuthor) {
        this.nameAuthor = nameAuthor;
    }

}
