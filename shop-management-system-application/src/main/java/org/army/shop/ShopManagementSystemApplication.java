package org.army.shop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
public class ShopManagementSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShopManagementSystemApplication.class, args);
    }
}
