package com.meixiaoxi.scheduler.store.jdbc.builder;

import com.meixiaoxi.scheduler.store.jdbc.SQLFormatter;
import com.meixiaoxi.scheduler.store.jdbc.SqlTemplate;
import com.meixiaoxi.scheduler.store.jdbc.exception.JdbcException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Robert HG (254963746@qq.com) on 3/9/16.
 */
public class DropTableSql {

    private static final Logger LOGGER = LoggerFactory.getLogger(DropTableSql.class);

    private SqlTemplate sqlTemplate;
    private StringBuilder sql = new StringBuilder();

    public DropTableSql(SqlTemplate sqlTemplate) {
        this.sqlTemplate = sqlTemplate;
    }

    public DropTableSql drop(String table) {
        sql.append("DROP TABLE IF EXISTS ").append(table);
        return this;
    }

    public boolean doDrop() {

        String finalSQL = sql.toString();

        try {
            if (LOGGER.isDebugEnabled()) {
                LOGGER.debug(SQLFormatter.format(finalSQL));
            }

            sqlTemplate.update(sql.toString());
        } catch (Exception e) {
            throw new JdbcException("Drop Table Error:" + SQLFormatter.format(finalSQL), e);
        }
        return true;
    }

}
