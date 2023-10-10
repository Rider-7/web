package com.example.web.model;

import org.springframework.data.annotation.Id;

public record Account(@Id long id, String username, String password, String type) {}
