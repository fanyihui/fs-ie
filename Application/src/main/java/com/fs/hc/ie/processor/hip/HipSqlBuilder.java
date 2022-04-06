package com.fs.hc.ie.processor.hip;

import com.fs.hc.ie.util.SqlBuilder;
import org.apache.camel.Exchange;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Map;

public class HipSqlBuilder {
    @Autowired
    SqlBuilder sqlBuilder;

    public void buildSql(Exchange exchange){
        Map<String, String> map = exchange.getIn().getBody(Map.class);
        String tableName = exchange.getIn().getHeader("TABLE_NAME", String.class);

        String sql = sqlBuilder.buildInsertSqlFromMap(tableName, map);
        exchange.getIn().setBody(sql);
    }
}
