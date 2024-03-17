package ru.inno.educ.repository.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import ru.inno.educ.entity.AccountPool;
import ru.inno.educ.repository.AccountPoolRepository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

@Repository
@RequiredArgsConstructor
public class JdbcAccountPoolRepository implements AccountPoolRepository, RowMapper<AccountPool> {

    private final NamedParameterJdbcTemplate namedTemplate;
    @Override
    public AccountPool findPool(String branchCode, String currencyCode, String mdmCode, String priorityCode, String registryTypeCode) {
        String sql = "select * from account_pool ap, account acc where ap.id = acc.account_pool_id " +
                "and ap.branch_code = :branchCode and ap.currency_code = :currencyCode and ap.mdm_code = :mdmCode " +
                "and ap.priority_code = :priorityCode and ap.registry_type_code = :registryTypeCode";

        var parameterSource = new MapSqlParameterSource(Map.of(
                "branchCode", branchCode,
                "currencyCode", currencyCode,
                "mdmCode", mdmCode,
                "priorityCode", priorityCode,
                "registryTypeCode", registryTypeCode
        ));

        return namedTemplate.queryForObject(
                sql,
                parameterSource,
                this
        );
    }

    @Override
    public AccountPool mapRow(ResultSet rs, int rowNum) throws SQLException {
        return null;
    }
}
