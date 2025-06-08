package com.kakeibo.expense_checker.response;

import java.time.Instant;
import java.util.UUID;

public record MetaData(
    String requestId,   
    Instant timestamp     
) {
    public MetaData() {
        this(UUID.randomUUID().toString(), Instant.now());
   
    }
}
