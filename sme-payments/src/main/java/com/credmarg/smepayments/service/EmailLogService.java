package com.credmarg.smepayments.service;

import com.credmarg.smepayments.model.EmailLog;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class EmailLogService {
    private final List<EmailLog> emailLogs = new ArrayList<>();
    private final AtomicLong counter = new AtomicLong();

    public void addEmailLog(String emailContent) {
        EmailLog emailLog = new EmailLog();
        emailLog.setId(counter.incrementAndGet());
        emailLog.setContent(emailContent);
        emailLogs.add(emailLog);
    }

    public List<EmailLog> getAllEmailLogs() {
        return new ArrayList<>(emailLogs);
    }
}
