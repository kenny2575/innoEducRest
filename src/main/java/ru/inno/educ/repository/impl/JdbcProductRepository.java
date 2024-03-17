package ru.inno.educ.repository.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import ru.inno.educ.entity.Product;
import ru.inno.educ.repository.ProductRepository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class JdbcProductRepository implements ProductRepository, RowMapper<Product> {

    private final JdbcTemplate template;
    private final NamedParameterJdbcTemplate namedTemplate;

    @Override
    public Optional<Product> findByContractNumber(String contactNumber) {
        return namedTemplate.query(
                "select * from tpp_product prod where prod.number = :id ",
                Map.of("id", contactNumber),
                this
        ).stream().findFirst();
    }

    @Override
    public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
        var product = new Product();
        product.setId(rs.getLong("id"));
        product.setProductCode(rs.getLong("product_code_id"));
        product.setClientId(rs.getLong("client_id"));
        product.setType(rs.getString("type"));
        product.setNumber(rs.getString("number"));
        product.setPriority(rs.getLong("priority"));
        product.setDateOfConclusion(rs.getTimestamp("date_of_conclusion"));
        product.setStartDateTime(rs.getTimestamp("start_date_time"));
        product.setEndDateTime(rs.getTimestamp("end_date_time"));
        product.setDays(rs.getLong("days"));
        product.setPenaltyRate(rs.getBigDecimal("penalty_rate"));
        product.setNso(rs.getBigDecimal("nso"));
        product.setThresholdAmount(rs.getBigDecimal("threshold_amount"));
        product.setRequisiteType(rs.getString("requisite_type"));
        product.setInterestRateType(rs.getString("interest_rate_type"));
        product.setTaxRate(rs.getBigDecimal("tax_rate"));
        product.setReasonClose(rs.getString("reasone_close"));
        product.setState(rs.getString("state"));
        return null;
    }
}
