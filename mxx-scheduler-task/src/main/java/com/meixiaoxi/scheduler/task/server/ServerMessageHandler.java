package com.meixiaoxi.scheduler.task.server;

import com.meixiaoxi.scheduler.message.Message;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

public class ServerMessageHandler extends SimpleChannelInboundHandler<Message> {
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, Message msg) throws Exception {
        // 简单地打印出server接收到的消息
        System.out.println(msg.toString());
    }
}