package com.example.onlinebookstore.validation.book;

import java.math.BigDecimal;

public interface PriceValidator {
    void isPriceValid(BigDecimal price);
}
