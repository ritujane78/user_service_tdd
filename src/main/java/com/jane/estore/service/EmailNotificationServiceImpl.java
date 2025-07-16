package com.jane.estore.service;

import com.jane.estore.model.User;

public class EmailNotificationServiceImpl implements EmailNotificationService {
    @Override
    public void scheduleEmailConfirmation(User user) {
//        Put user into email queue
        System.out.println("Scheduling email..");
    }
}
