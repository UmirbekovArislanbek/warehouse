package qr.data.warehousespring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import qr.data.warehousespring.additional.Result;
import qr.data.warehousespring.entity.Attechment;
import qr.data.warehousespring.entity.AttechmentContent;
import qr.data.warehousespring.repasitory.AttechmentContentRepasitory;
import qr.data.warehousespring.repasitory.AttechmentRepasitory;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Iterator;
import java.util.Optional;

@Service
public class AttechmentContentService {

    @Autowired
    AttechmentContentRepasitory attechmentContentRepasitory;
    @Autowired
    AttechmentRepasitory attechmentRepasitory;


    public void downloadAttachment(Integer id, HttpServletResponse response) throws IOException {
        Optional<Attechment> byId = attechmentRepasitory.findById(id);
        if(byId.isPresent()){
            Attechment attachment = byId.get();
            Optional<AttechmentContent> attachmentContentByAttachment_id = attechmentContentRepasitory.getAttechmentContentByAttechment(attachment.getId());
            if(attachmentContentByAttachment_id.isPresent()){
                AttechmentContent attachmentContent = attachmentContentByAttachment_id.get();
                response.setHeader("Content-Disposiotion",
                        "attachment; filename=\""+attachment.getName()+"\"");
                response.setContentType(attachment.getContenType());
                FileCopyUtils.copy(attachmentContent.getBytes(),response.getOutputStream());
            }

        }
    }

    public Result addFile(MultipartHttpServletRequest request) throws IOException {
        Iterator<String> fileNames = request.getFileNames();
        MultipartFile file = request.getFile(fileNames.next());
        if(file.isEmpty()){
            return new Result("File not found",false);
        }
        String originalFilename = file.getOriginalFilename();
        String contentType = file.getContentType();
        long size = file.getSize();
        Attechment save = attechmentRepasitory.save(new Attechment(null, originalFilename, size, contentType));
        byte[] bytes = file.getBytes();
        attechmentContentRepasitory.save(new AttechmentContent(null,bytes,save));
        return new Result("Successfull saved",true);
    }
}
