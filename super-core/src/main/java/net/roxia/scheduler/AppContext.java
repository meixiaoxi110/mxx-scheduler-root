package net.roxia.scheduler;

import net.roxia.scheduler.factory.DefaultServiceFactory;

import javax.sql.DataSource;

/**
 * Copyright: Copyright (c) 2018 meixiaoxi
 *
 * @ClassName: SchedulerContext
 * @Description:
 * @version: v1.0.0
 * @author: meixiaoxi
 * @date: 2019-04-25 14:43:22
 * Modification History:
 * Date          Author          Version          Description
 * -----------------------------------------------------------
 * 2019-04-25    meixiaoxi       v1.0.0           创建
 */
public abstract class AppContext extends DefaultServiceFactory {

    /**
     * 系统配置
     */
    private SchedulerConfig config;

    /**
     * 连接数据库的数据源
     */
    private DataSource dataSource;

    public AppContext(SchedulerConfig config) {
        this.config = config;
    }

    public SchedulerConfig getConfig() {
        return config;
    }

    public void setConfig(SchedulerConfig config) {
        this.config = config;
    }

    public DataSource getDataSource() {
        return dataSource;
    }

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }
}
