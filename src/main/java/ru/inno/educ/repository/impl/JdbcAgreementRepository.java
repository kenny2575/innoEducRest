package ru.inno.educ.repository.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import ru.inno.educ.entity.Agreement;
import ru.inno.educ.repository.AgreementRepository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class JdbcAgreementRepository implements AgreementRepository, RowMapper<Agreement> {

    private final NamedParameterJdbcTemplate namedTemplate;

    @Override
    public List<Agreement> findAgreementsByNumber(List<String> number) {
        var parameterSource = new MapSqlParameterSource("number", number);
        return namedTemplate.query(
                "select * from agreement agr where agr.number in (:number)",
                parameterSource,
                this
        );
    }

    @Override
    public Agreement mapRow(ResultSet rs, int rowNum) throws SQLException {
        var agreement = new Agreement();
        agreement.setId(rs.getLong("id"));
        agreement.setProductId(rs.getLong("product_id"));
        agreement.setGeneralAgreementId(rs.getString("general_agreement_id"));
        agreement.setSupplementaryAgreementId(rs.getString("supplementary_agreement_id"));
        agreement.setArrangementType(rs.getString("arrangement_type"));
        agreement.setScheduledJobId(rs.getLong("sheduler_job_id"));
        agreement.setNumber(rs.getString("number"));
        agreement.setOpenningDate(rs.getDate("opening_date"));
        agreement.setClosingDate(rs.getDate("closing_date"));
        agreement.setCancelDate(rs.getDate("cancel_date"));
        agreement.setValidityDuration(rs.getLong("validity_duration"));
        agreement.setCancellationReason(rs.getString("cancellation_reason"));
        agreement.setStatus(rs.getString("status"));
        agreement.setInterestCalculationDate(rs.getDate("interest_calculation_date"));
        agreement.setInterestRate(rs.getBigDecimal("interest_rate"));
        agreement.setCoefficient(rs.getBigDecimal("coefficient"));
        agreement.setCoefficientAction(rs.getString("coefficient_action"));
        agreement.setMinimumInterestRate(rs.getBigDecimal("minimum_interest_rate"));
        agreement.setMinimumInterestRateCoefficient(rs.getBigDecimal("minimum_interest_rate_coefficient"));
        agreement.setMinimumInterestRateCoefficientAction(rs.getString("minimum_interest_rate_coefficient_action"));
        agreement.setMaximumInterestRate(rs.getBigDecimal("maximal_interest_rate"));
        agreement.setMaximumInterestRateCoefficient(rs.getBigDecimal("maximal_interest_rate_coefficient"));
        agreement.setMaximumInterestRateCoefficientAction(rs.getString("maximal_interest_rate_coefficient_action"));
        return agreement;
    }
}
