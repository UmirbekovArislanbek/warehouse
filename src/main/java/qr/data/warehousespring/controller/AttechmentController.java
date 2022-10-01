package qr.data.warehousespring.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import qr.data.warehousespring.additional.Result;
import qr.data.warehousespring.entity.Attechment;
import qr.data.warehousespring.service.AttechmentService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/attachment")
public class AttechmentController {

    AttechmentService attachmentService;

    @GetMapping("/{id}")
    public Attechment getAttachmentById(@PathVariable Integer id) {
        return attachmentService.getAttachmentById(id);
    }

    @PostMapping
    public Result addAttachment(@RequestBody Attechment attachment) {
        return attachmentService.addAttachment(attachment);
    }
}
