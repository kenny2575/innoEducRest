package ru.inno.educ.repository.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import ru.inno.educ.entity.ProductRegisterType;
import ru.inno.educ.repository.ProductRegisterTypeRepository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class JdbcProductRegisterTypeRepository implements ProductRegisterTypeRepository, RowMapper<ProductRegisterType> {

    private final NamedParameterJdbcTemplate namedTemplate;
    @Override
    public List<ProductRegisterType> findProductRegisterByCode(String productCode) {

        var parameterSource = new MapSqlParameterSource("productCode", productCode);
        parameterSource.addValue("accountType", "Клиентский");
        return namedTemplate.query(
                "select * from tpp_ref_product_register_type where account_type = :accountType and product_class_code = :productCode",
                parameterSource,
                this
        );
    }

    @Override
    public List<ProductRegisterType> findProductRegisterTypeByValue(String value) {
        var parameterSource = new MapSqlParameterSource("value", value);
        return namedTemplate.query(
                "select * from tpp_ref_product_register_type where value = :value",
                parameterSource,
                this
        );
    }

    @Override
    public ProductRegisterType mapRow(ResultSet rs, int rowNum) throws SQLException {
        var productRegister = new ProductRegisterType();
        productRegister.setId(rs.getLong("internal_id"));
        productRegister.setValue(rs.getString("value"));
        productRegister.setRegisterTypeName(rs.getString("register_type_name"));
        productRegister.setProductClassCode(rs.getString("product_class_code"));
        productRegister.setStartDate(rs.getDate("register_type_start_date"));
        productRegister.setEndDate(rs.getDate("register_type_end_date"));
        productRegister.setAccountType(rs.getString("account_type"));
        return productRegister;
    }
}
