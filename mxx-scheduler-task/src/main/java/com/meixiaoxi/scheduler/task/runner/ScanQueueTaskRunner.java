package com.meixiaoxi.scheduler.task.runner;


import com.meixiaoxi.scheduler.task.TaskAppContext;

/**
 * Copyright: Copyright (c) 2018 meixiaoxi
 *
 * @ClassName: TaskRunner
 * @Description:
 * @version: v1.0.0
 * @author: meixiaoxi
 * @date: 2019-04-25 14:29:43
 * Modification History:
 * Date          Author          Version          Description
 * -----------------------------------------------------------
 * 2019-04-25    meixiaoxi       v1.0.0           创建
 */
public class ScanQueueTaskRunner extends TaskRunner<TaskAppContext> {

    public ScanQueueTaskRunner(TaskAppContext context) {
        this.context = context;
    }

    @Override
    public void run() {
        runNext();
    }
}