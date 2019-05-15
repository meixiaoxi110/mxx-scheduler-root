package com.meixiaoxi.scheduler.store;

import com.meixiaoxi.scheduler.store.dbutils.ResultSetHandler;

import java.sql.SQLException;

/**
 * @author Robert HG (254963746@qq.com) on 3/8/16.
 */
public interface SqlTemplate {

    void createTable(final String sql) throws SQLException;

    int[] batchInsert(final String sql, final Object[][] params) throws SQLException;

    int[] batchUpdate(final String sql, final Object[][] params) throws SQLException;

    int insert(final String sql, final Object... params) throws SQLException;

    int update(final String sql, final Object... params) throws SQLException;

    int delete(final String sql, final Object... params) throws SQLException;

    <T> T query(final String sql, final ResultSetHandler<T> rsh, final Object... params) throws SQLException;

    <T> T queryForValue(final String sql, final Object... params) throws SQLException;
}
