package xyz.zerotone.explore.bio.client;

import xyz.zerotone.explore.bio.ChannelAdapter;
import xyz.zerotone.explore.bio.ChannelHandler;

import java.net.Socket;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.Date;

public class BioClientHandler extends ChannelAdapter {

    public BioClientHandler(Socket socket, Charset charset) {
        super(socket, charset);
    }

    @Override
    public void channelActive(ChannelHandler ctx) {
        System.out.println("链接报告LocalAddress：" + ctx.socket().getLocalAddress());
        ctx.writeAndFlush("hi! 我是Maloong BioClient to msg for you \r\n");
    }

    @Override
    public void channelRead(ChannelHandler ctx, Object msg) {
        System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()) + "接收到消息：" + msg);
        ctx.writeAndFlush("hi 我已经收到你的消息Success！ \r\n");
    }
}
