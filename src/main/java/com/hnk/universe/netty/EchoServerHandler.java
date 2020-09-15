package com.hnk.universe.netty;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufUtil;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import org.apache.commons.lang3.StringUtils;

/**
 * @author naikuoh
 * @DATE 2020/5/28 14:06
 */
public class EchoServerHandler extends ChannelInboundHandlerAdapter {

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) {
        ByteBuf bb = (ByteBuf) msg;
        bb.markReaderIndex();
        ctx.channel().metadata();
        System.out.println(ctx.channel().remoteAddress());
        System.out.println("Server received: " + ByteBufUtil.hexDump(bb.readBytes(bb.readableBytes())));
//        bb.resetReaderIndex();

        ByteBuf byteBuf = Unpooled.copiedBuffer("msg".getBytes());


    }

    public static void main(String[] args) {
        String property = System.getProperty("line.separator");
        String str = null;
        if(StringUtils.endsWith(str,System.getProperty("line.separator"))){
            System.out.println(">>>>>>>");
        }else {
            System.out.println("<<<<<<<<<");

        }
    }

//    @Override
//    public void channelReadComplete(ChannelHandlerContext ctx) {
//        ctx.writeAndFlush(Unpooled.EMPTY_BUFFER)
//                .addListener(ChannelFutureListener.CLOSE);
//    }

//    @Override
//    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
//        cause.printStackTrace();
//        ctx.close();
//    }
}
