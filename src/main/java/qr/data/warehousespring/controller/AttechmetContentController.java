package qr.data.warehousespring.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import qr.data.warehousespring.additional.Result;
import qr.data.warehousespring.service.AttechmentContentService;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
@RequiredArgsConstructor
@RequestMapping("/attachmentcontent")
public class AttechmetContentController {
    AttechmentContentService attechmentContentService;

    @GetMapping("/{id}")
    public void downloadAttachment(@PathVariable Integer id, HttpServletResponse response) throws IOException {
        attechmentContentService.downloadAttachment(id, response);
    }

    @PostMapping
    public Result addAttachment(MultipartHttpServletRequest request) throws IOException {
        return attechmentContentService.addFile(request);
    }
}
