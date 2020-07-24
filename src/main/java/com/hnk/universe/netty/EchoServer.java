package com.hnk.universe.netty;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;
import io.netty.util.CharsetUtil;

import java.net.InetSocketAddress;

/**
 * @author naikuoh
 * @DATE 2020/5/28 14:04
 */
public class EchoServer {
    private int port;

    public EchoServer(int port) {
        this.port = port;
    }

    //https://www.infoq.cn/article/netty-server-create

    public void start() throws Exception {
        EventLoopGroup group = new NioEventLoopGroup();
        try {
            ServerBootstrap b = new ServerBootstrap();
            b.group(group)
                    .channel(NioServerSocketChannel.class)
                    .localAddress(new InetSocketAddress(port))
                    .childHandler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        public void initChannel(SocketChannel ch) throws Exception {
                            ch.pipeline()
                                    .addLast("encoder", new StringEncoder(CharsetUtil.US_ASCII))
                                    .addLast("decoder", new StringDecoder(CharsetUtil.US_ASCII))
                                    .addLast(new EchoServerHandler());
                        }
                    });
            // 绑定端口，开始接收连接
            ChannelFuture f = b.bind().sync();
            System.out.println("Server start listen at " + port);
            // 等待服务器socket关闭
            f.channel().closeFuture().sync();
        } finally {
            group.shutdownGracefully();
        }
    }

    public static void main(String[] args) throws Exception {
        int port;
        if (args.length > 0) {
            port = Integer.parseInt(args[0]);
        } else {
            port = 8081;
        }
        new EchoServer(port).start();
    }
}
