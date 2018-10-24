package org.army.shop.conf;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"org.army.common", "org.army.shop"})
@EntityScan(basePackages = {"org.army.common", "org.army.shop"})
public class ApplicationConfiguration {
}
