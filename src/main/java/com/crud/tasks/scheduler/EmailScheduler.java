package com.crud.tasks.scheduler;

import com.crud.tasks.config.AdminConfig;
import com.crud.tasks.domain.Mail;
import com.crud.tasks.repository.TaskRepository;
import com.crud.tasks.service.SimpleEmailService;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class EmailScheduler {

    private static final String SUBJECT = "Tasks: Once a day email";
    private final SimpleEmailService simpleEmailService;
    private final TaskRepository taskRepository;
    private final AdminConfig adminConfig;

    @Scheduled(cron = "0 0 10 * * *")
    public void sendInformationEmail() {
        simpleEmailService.send(Mail.builder()
                .receiverEmail(adminConfig.getAdminMail())
                .subject(SUBJECT)
                .message("Currently in database you got: " + coutTasks())
                .build());
    }

    private String coutTasks() {
        long size = taskRepository.count();
        if (size == 1) {
            return size + " task";
        }
        return size + " tasks";
    }
}