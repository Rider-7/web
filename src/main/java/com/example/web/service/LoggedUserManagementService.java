package com.example.web.service;

import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

@Service
@SessionScope
public class LoggedUserManagementService {
        private String username;
        private String type;

        public void setUsername(String username) {
            this.username = username;
        }

        public String getUsername() {
            return username;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getType() {
            return type;
        }
}
