package com.caribu.caribuobank2.rest;

import com.caribu.caribuobank2.config.HeaderUti;
import com.caribu.caribuobank2.config.ResponseUtil;
import com.caribu.caribuobank2.domin.Office;
import com.caribu.caribuobank2.repository.OfficRepository;
import com.caribu.caribuobank2.servise.OfficeServise;
import com.caribu.caribuobank2.servise.dto.OfficDto;
import com.caribu.caribuobank2.servise.mapper.OfficMaper;
import jakarta.validation.Valid;
import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

@RestController
@Controller
public class OficeResurce {
 //   private final Logger log = (Logger) LoggerFactory.getLogger(OficeResurce.class);

private final OfficeServise officeServise;
//@Value("${caribo.clintApp.name}")
private String applicationName;

private OfficRepository officRepository;

private final OfficMaper officMaper;
private static final String EntityName="Office";
    public OficeResurce(OfficeServise officeServise, OfficMaper officMaper) {
        this.officeServise = officeServise;
        this.officMaper = officMaper;
    }


    @PostMapping("/office")
    public ResponseEntity <OfficDto> createOffice(@Valid @RequestBody OfficDto officeDto ) throws URISyntaxException {
        OfficDto result= officeServise.Save(officeDto);

  ///  public  ResponseEntity<Office> creat(@RequestBody Office office) throws URISyntaxException {
      //  Office result = officRepository.save(office);
        return    ResponseEntity.created(new URI("/office" + result.getId())).headers(HeaderUti.createEntity(applicationName, true, EntityName, result.getId().toString()))
                .body(result);

    }
//@PutMapping("/port/{id}")
//public OfficDto updateOffice(  @RequestBody OfficDto officeDto ,@PathVariable long id ) {
//        //throws BadRequestException {
////        if(officeDto.getId()==null){
////            throw new BadRequestException("Office id is required");
////        }
////        if(!officeServise.exsistByid(officeDto.getId())){
////            throw new BadRequestException("Office not foundby id");
////        }
//
//        OfficDto result= officeServise.updete(officeDto,id);
//        return result;
//
//}

@PutMapping("/org/{id}")
public  OfficDto updeteOffice( @PathVariable long id ,@RequestBody OfficDto officeDto ) throws BadRequestException {
  return   officeServise.put(id, officeDto);
//        if(officeDto.getId()==null){
//            throw new BadRequestException("ای دی موجود نیست");
//        }
//        if(!officeServise.exsistByid(officeDto.getId())){
//
//            throw new BadRequestException("Office already exists");
//        }
//
//     OfficDto result=   officeServise.put(id,officeDto);
//      return result;
}




@GetMapping("/ofer")
  public List<OfficDto> getAllOfficDto(){
        return officeServise.getall();
}

@GetMapping("ast/{id}")
    public ResponseEntity <OfficDto> getOffice3(@PathVariable Long id){



      // Optional<OfficDto>officDto=officeServise.findone(id);
    Optional<OfficDto>officDto=officeServise.findByid(id);
if(officDto.isPresent()){
    return ResponseEntity.ok(officDto.get());
}
else {
    return ResponseEntity.notFound().build();
}
      //   return ResponseUtil.wrapOrNotFound(officDto);


}
@DeleteMapping("/delofic/{id}")
    public ResponseEntity <String> deleteOffice(@PathVariable Long id){
        officeServise.deletBy(id);
       return ResponseEntity.ok("deleteby"+id+"done");
}


}


//}
