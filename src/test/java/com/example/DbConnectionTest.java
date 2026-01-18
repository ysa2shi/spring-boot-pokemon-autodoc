package com.example;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class DbConnectionTest {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Test
    void testConnection() {
        // PostgreSQLに対して単純なクエリを実行
        Integer result = jdbcTemplate.queryForObject("SELECT 1", Integer.class);

        // 1が返ってくれば接続成功
        assertThat(result).isEqualTo(1);
        System.out.println("DB接続テスト成功！結果: " + result);
    }
}