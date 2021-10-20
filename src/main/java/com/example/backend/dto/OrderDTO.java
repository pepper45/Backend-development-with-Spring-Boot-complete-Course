package com.example.backend.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class OrderDTO {

    private Integer id;
    private BigDecimal amount;
    private LocalDateTime placedAt;
    private LocalDate deliveryDate;
    private String status;
    private String invoiceUrl;
    private UserDTO user;
    private AddressDTO deliveryAddress;
    private List<ProductDTO> productList;

}
