package org.army.shop.sales.repository;

import org.army.shop.sales.entity.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories
public interface InvoiceRepository extends JpaRepository<Invoice, Long> {

}