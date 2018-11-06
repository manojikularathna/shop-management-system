package org.army.shop.conf;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

@Configuration
@ComponentScan(basePackages = {"org.army.common", "org.army.shop"})
@EntityScan(basePackages = {"org.army.common", "org.army.shop"})
@EnableFeignClients(basePackages = {"org.army.shop.inventory.client", "org.army.common.accounting.client"})
@EnableScheduling
public class ApplicationConfiguration {
}
