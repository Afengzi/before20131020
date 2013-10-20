package com.klov.tcp_ip;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Set;

public class Service {

	public ServerSocketChannel initalAddr(String hostname,int port){
		
		ServerSocketChannel serviceCh = null;
		try {
			serviceCh = ServerSocketChannel.open();
			ServerSocket serviceSo = serviceCh.socket() ;
			serviceSo.bind(new InetSocketAddress(hostname, port)) ;
			serviceCh.configureBlocking(false) ;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return serviceCh ;
	}
	
	public boolean resolve(ServerSocketChannel channel){
		
		Selector select;
	    boolean stop = false ;
		try {
			select = Selector.open();
			channel.register(select, SelectionKey.OP_ACCEPT) ;
			while(!stop){
				if(select.select()==0){
					continue ;
				}
				Set<SelectionKey> keys = select.selectedKeys();
				for(SelectionKey key : keys){
					if(key.isValid()&&key.isAcceptable()){
						SocketChannel clientCh = ((ServerSocketChannel)key.channel()).accept() ;
						clientCh.configureBlocking(false) ;
						clientCh.register(select, SelectionKey.OP_READ) ;
						ByteBuffer.allocate(1024) ;
					}
					if(key.isValid()&&key.isReadable()){
						 handleRead(key) ;
					}
					if(key.isWritable()){
						handleWrite(key) ;
					}
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return true ;
	}
	
	public void handleRead(SelectionKey key){
		
	}
	public void handleWrite(SelectionKey key){
		
	}
}
