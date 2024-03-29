/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.test.tictactoeserver;

import org.jboss.netty.buffer.ChannelBuffer;
import org.jboss.netty.buffer.ChannelBuffers;
import org.jboss.netty.channel.Channel;
import org.jboss.netty.channel.ChannelHandlerContext;
import org.jboss.netty.handler.codec.oneone.OneToOneEncoder;

/**
 *
 * @author wolf
 */
public class Encoder  extends OneToOneEncoder {
    @Override
    protected Object encode(ChannelHandlerContext channelhandlercontext, Channel channel, Object obj) throws Exception {
        if(!(obj instanceof ChannelBuffer))
            return obj; 
        ChannelBuffer buffer = (ChannelBuffer)obj;
        int size = buffer.writerIndex();
        ChannelBuffer newBuffer = ChannelBuffers.buffer(size + Integer.SIZE);
        newBuffer.writeInt(size);
        newBuffer.writeBytes(buffer);
        return newBuffer; // Возвращаем буфер, который и будет записан в канал
    }
}
