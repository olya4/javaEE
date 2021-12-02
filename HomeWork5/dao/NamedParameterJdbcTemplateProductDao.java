package ru.gb.dao;

import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;
import ru.gb.entity.Product;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

//@Component
@RequiredArgsConstructor
public class NamedParameterJdbcTemplateProductDao implements ProductDao {

    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Override
    public Iterable<Product> findAll() {
        String sql = "SELECT * FROM product";
        // запрос в бд, новый экземпляр мапера
        return namedParameterJdbcTemplate.query(sql, new NamedParameterJdbcTemplateProductDao.ProductMapper());
    }

    @Override
    public Product findById(Long id) {
        String sql = "SELECT * FROM product WHERE id = :productId";
        HashMap<String, Object> nameParameters = new HashMap<>();
        nameParameters.put("productId", id);
        return namedParameterJdbcTemplate.query(sql, nameParameters, new ProductExtractor());
    }

    @Override
    public String findTitleById(Long id) {
        String sql = "SELECT title FROM product WHERE id = :productId";
        HashMap<String, Object> nameParameters = new HashMap<>();
        nameParameters.put("productId", id);
        // запрос в бд, из мапы по ключу будет взято значение и подставится вместо ? в запрос, вернуть строку
        return namedParameterJdbcTemplate.queryForObject(sql, nameParameters, String.class);
    }

    @Override
    public void insert(Product product) {

    }

    @Override
    public void update(Product product) {

    }

    @Override
    public void deleteById(Long id) {

    }

    // мапер для объектов из таблицы product
    private static class ProductMapper implements RowMapper<Product> {
        @Override
        public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
            return Product.builder()
                    .id(rs.getLong("id"))
                    .title(rs.getString("title"))
                    .cost(rs.getBigDecimal("cost"))
                    .manufactureDate(rs.getDate("manufacture_date").toLocalDate())
                    .build();
        }
    }

    private static class ProductExtractor implements ResultSetExtractor<Product> {
        @Override
        public Product extractData(ResultSet rs) throws SQLException, DataAccessException {
            Product product = null;
            while (rs.next()) {
                Long productId = rs.getLong("id");
                // создать объект Product
                product = Product.builder()
                        .id(productId)
                        .title(rs.getString("title"))
                        .cost(rs.getBigDecimal("cost"))
                        .manufactureDate(rs.getDate("manufacture_date").toLocalDate())
                        .build();
            }
            return product;
        }
    }
}
