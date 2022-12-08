package penjualan.transaksi.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import penjualan.transaksi.model.request.EmailRequest;
import penjualan.transaksi.service.EmailService;

@RestController
@RequestMapping("/email")
@AllArgsConstructor
public class EmailController {

    private EmailService emailService;

    @PostMapping
    public EmailRequest simpleMail(@RequestBody EmailRequest emailRequest) {
        return emailService.simpleEmail(emailRequest);
    }

    @PostMapping("/attach")
    public EmailRequest sendMessageWithAttachment(
            @RequestBody EmailRequest emailRequest
    ) {
        return emailService.sendMessageWithAttachment(emailRequest);
    }
}
