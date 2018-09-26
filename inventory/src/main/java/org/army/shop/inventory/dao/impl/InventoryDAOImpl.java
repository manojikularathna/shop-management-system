package org.army.shop.inventory.dao.impl;

import com.google.common.base.Joiner;
import org.army.shop.inventory.dao.InventoryDAO;
import org.army.shop.inventory.entity.ItemBatch;
import org.army.shop.inventory.to.InventorySearchTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

@Repository
public class InventoryDAOImpl implements InventoryDAO {

    @Autowired
    private EntityManager entityManager;

    @Override
    public List<ItemBatch> search(InventorySearchTO inventorySearch) {

        boolean conditionsInitiated = false;
        AtomicInteger counter = new AtomicInteger(0);
        StringBuilder content = new StringBuilder();
        content.append(" select ib from ItemBatch ib where ib.branchId = :branchId and ib.stock.remainingQuantity.quantity > 0 ");

        Map<String, Object> params = new LinkedHashMap<>();

        params.put("branchId", inventorySearch.getBranchId());

        if (! (inventorySearch.getBrandName().isEmpty() && inventorySearch.getItemCategoryCode().isEmpty())) {
            content.append(" and ( ");

            if (!inventorySearch.getBrandName().isEmpty()) {
                content.append(" ( ");
                counter.set(0);
                content.append(Joiner.on(" or ")
                        .join(inventorySearch.getBrandName()
                                .stream()
                                .map(brand -> {
                                    params.put("brand_" + counter.incrementAndGet(), "%" + brand + "%");
                                    return " ib.itemBrand.brandName like :brand_" + counter.get() + " ";
                                })
                                .collect(Collectors.toList())));
                content.append(" ) ");
                conditionsInitiated = true;
            }

            if (!inventorySearch.getItemCategoryCode().isEmpty()) {

                if (conditionsInitiated) {
                    content.append(" or ");
                }
                content.append(" ( ");
                counter.set(0);
                content.append(Joiner.on(" or ")
                        .join(inventorySearch.getItemCategoryCode()
                                .stream()
                                .map(category -> {
                                    params.put("category_code_" + counter.incrementAndGet(), "%" + category + "%");
                                    params.put("category_desc_" + counter.get(), "%" + category + "%");
                                    return " ib.itemBrand.category.itemCategoryCode like :category_code_" + counter.get() + " or " +
                                        " ib.itemBrand.category.description like :category_desc_" + counter.get() + " ";
                                })
                                .collect(Collectors.toList())));
                content.append(" ) ");
            }
            content.append(" ) ");
        }

        Query query = entityManager
                .createQuery(content.toString());
        params.forEach((k, v) -> {
            query.setParameter(k, v);
        });

        List<ItemBatch> items = query.getResultList();

        return items;
    }
}
