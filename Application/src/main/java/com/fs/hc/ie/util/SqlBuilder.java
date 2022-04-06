package com.fs.hc.ie.util;

import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class SqlBuilder {
    public String buildInsertSqlFromMap(String table, Map<String, String> map) throws IllegalArgumentException{
        if (table==null){
            throw new IllegalArgumentException("数据库表名不能为空！");
        }
        if (map == null || map.isEmpty()){
            throw new IllegalArgumentException("构建SQL语句的Map内容不能为空");
        }

        String sql = "insert into "+table+"(";

        for (String key : map.keySet()){
            sql = sql + key + ",";
        }

        sql = sql.substring(0, sql.length() - 1);
        sql = sql + ") values(";

        for (String value : map.values()){
            sql = sql + "'" + value + "', ";
        }

        sql = sql.trim();
        sql = sql.substring(0, sql.length() - 1);
        sql = sql + ")";

        return sql;
    }
}
