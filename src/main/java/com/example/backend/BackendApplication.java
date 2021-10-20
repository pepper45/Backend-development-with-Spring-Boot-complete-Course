package com.example.backend;

import com.example.backend.dto.AddressDTO;
import com.example.backend.dto.OrderDTO;
import com.example.backend.dto.ProductDTO;
import com.example.backend.dto.UserDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.TreeMap;

@SpringBootApplication
public class BackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(BackendApplication.class, args);
    }

    @Bean
    public TreeMap<Integer, OrderDTO> generateOrderDB() {
        TreeMap<Integer, OrderDTO> orders = new TreeMap<>();
        for (int id = 1; id <= 10; id++) {
            OrderDTO order = OrderDTO.builder()
                                     .id(id)
                                     .amount(BigDecimal.valueOf(Math.random() * 9999))
                                     .deliveryDate(LocalDate.now()
                                                            .minusDays(((long) (Math.random() * 100))))
                                     .invoiceUrl("Invoice" + id)
                                     .placedAt(LocalDateTime.now()
                                                            .minusDays(((long) (Math.random() * 100))))
                                     .productList(new ArrayList<ProductDTO>())
                                     .user(new UserDTO())
                                     .deliveryAddress(new AddressDTO())
                                     .build();
            orders.put(id, order);
        }
        return orders;
    }

    @Bean
    public ObjectMapper objectMapper() {
        ObjectMapper mapper = new ObjectMapper();
        mapper.disable(SerializationFeature.FAIL_ON_EMPTY_BEANS);
        mapper.registerModule(new JavaTimeModule());
        mapper.configure(SerializationFeature.INDENT_OUTPUT, true);
        mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
        System.out.println("Mapper Configured : ");
        return mapper;
    }
}
