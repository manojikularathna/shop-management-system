package org.army.shop.common.dao;

import java.util.List;

public interface CommonDAO {

    <T> T add(T entity);

    <T> List<T> get(Class<T> type);
}
