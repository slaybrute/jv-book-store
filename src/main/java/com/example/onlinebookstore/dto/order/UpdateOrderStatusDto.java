package com.example.onlinebookstore.dto.order;

import com.example.onlinebookstore.model.enums.StatusName;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class UpdateOrderStatusDto {
    @NotNull
    private StatusName status;
}
