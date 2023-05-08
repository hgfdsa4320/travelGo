package com.travelgo.repository;

import com.travelgo.domain.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class UserRepository{

    private final JdbcTemplate jdbcTemplate;
    public Optional<User> findByMailAddress(String mailAddress) {
        try {
            String sql = "select * from user where mail_address = ?";
            User user = jdbcTemplate.queryForObject(sql, userRowMapper(), mailAddress);
            return Optional.of(user);
        } catch (EmptyResultDataAccessException e) {
            return Optional.empty();
        }
    }

    private RowMapper<User> userRowMapper() {
        return ((rs, rowNum) -> {
            User user = new User();
            user.setId(rs.getLong("id"));
            user.setName(rs.getString("name"));
            user.setNickName(rs.getString("nick_name"));
            user.setMailAddress(rs.getString("mail_address"));
            user.setPassword(rs.getString("password"));
            return user;
        });

    }


}
