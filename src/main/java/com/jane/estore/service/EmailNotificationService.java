package com.jane.estore.service;

import com.jane.estore.model.User;

public interface EmailNotificationService {
    void scheduleEmailConfirmation(User user);
}
