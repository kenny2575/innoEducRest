package ru.inno.educ.repository.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import ru.inno.educ.entity.ProductRegister;
import ru.inno.educ.repository.ProductRegisterRepository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class JdbcProductRegisterRepository implements ProductRegisterRepository, RowMapper<ProductRegister> {

    NamedParameterJdbcTemplate namedTemplate;
    @Override
    public ProductRegister mapRow(ResultSet rs, int rowNum) throws SQLException {
        var prodRegister = new ProductRegister();
        prodRegister.setId(rs.getLong("id"));
        prodRegister.setProductId(rs.getLong("product_id"));
        prodRegister.setType(rs.getString("type"));
        prodRegister.setAccount(rs.getLong("account"));
        prodRegister.setCurrencyCode(rs.getString("currency_code"));
        prodRegister.setState(rs.getString("state"));
        prodRegister.setAccountNumber(rs.getString("account_number"));
        return prodRegister;
    }

    @Override
    public Optional<ProductRegister> findByProductIdAndType(Long productId, String typeCode) {
        var parameterSource = new MapSqlParameterSource("prodId", productId);
        parameterSource.addValue("typeCode", typeCode);
        return namedTemplate.query(
                "select * from tpp_product_register where product_id = :prodId and type = :typeCode",
                parameterSource,
                this
        ).stream().findFirst();
    }
}
