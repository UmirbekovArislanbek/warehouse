package qr.data.warehousespring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import qr.data.warehousespring.additional.Result;
import qr.data.warehousespring.entity.Attechment;
import qr.data.warehousespring.repasitory.AttechmentRepasitory;

import java.util.List;
import java.util.Optional;

@Service
public class AttechmentService {
    @Autowired
    AttechmentRepasitory attechmentRepasitory;


    public Result addAttachment(Attechment attachment){
        attechmentRepasitory.save(attachment);
        return new Result("Successfull saved",true);
    }

    public Attechment getAttachmentById(Integer id){
        Optional<Attechment> byId = attechmentRepasitory.findById(id);
        return byId.orElse(null);
    }
}
