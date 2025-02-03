package com.caribu.caribuobank2.servise;

import com.caribu.caribuobank2.domin.Office;
import com.caribu.caribuobank2.repository.OfficRepository;
import com.caribu.caribuobank2.servise.dto.OfficDto;
import com.caribu.caribuobank2.servise.mapper.OfficMaper;
import com.caribu.caribuobank2.servise.mapper.OfficMaperImpl;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class OfficeServise {

    private final OfficRepository officRepository;
    private OfficMaper officMaper;
    private  OfficDto officDto;


    public OfficeServise(OfficRepository officRepository, OfficMaper officMaper, OfficMaperImpl officMaperImpl)
    {
        this.officRepository = officRepository;

        this.officMaper = officMaper;



    }

    public OfficDto Save(OfficDto officDto) {



     Office office=officMaper.toEntity(officDto);

        Office office1=officRepository.save(office);


 OfficDto officDto1=officMaper.toDto(office);
 return officDto1;
    }

    private Office fromId(Long id) {

        if(id==null) {return null;}
        Office office=new Office();
        office.setId(id);
        return office;
    }

    public boolean exsistByid(Long id) {
      return   officRepository.existsById(id);
    }



    public List<OfficDto> getall() {
        return officRepository.findAll().stream().map(officMaper::toDto).collect(Collectors.toCollection(LinkedList::new));
    }




    public Optional<OfficDto> findByid(Long id) {
        return  officRepository.findById(id).map(officMaper::toDto);
    }

    public void deletBy(Long id) {
        officRepository.deleteById(id);
    }


    public OfficDto put(long id, OfficDto officeDto) {
        Office office=officMaper.toEntity(officeDto);
        office.setId(id);
        Office office1=officRepository.save(office);
        return officMaper.toDto(office1);
    }
}


