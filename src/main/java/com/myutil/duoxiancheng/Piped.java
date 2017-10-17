package com.myutil.duoxiancheng;

import java.io.IOException;
import java.io.PipedReader;
import java.io.PipedWriter;

/**
 * 管道输入流   管道输出流
 * @author 80002523
 * 这个例子能够证明管道流的读写
 * 对于Piped类型的流，必须要进行绑定，也就是调用connect()方法，如果没有将输入、输出绑定起来，对于该流的访问将会抛出异常
 */
public class Piped {
	public static void main(String[] args) throws Exception {
		PipedWriter out = new PipedWriter();
		PipedReader in = new PipedReader();
		//将输入流和输出流连接，否则在使用时会抛出IOException
		out.connect(in);
		Thread printThread = new Thread(new Print(in),"PrintThread");
		printThread.start();
		int receive = 0;
		try {
			while((receive = System.in.read()) != -1){
				out.write(receive);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	static class Print implements Runnable{
		private PipedReader in;
		public Print(PipedReader in){
			this.in = in;
		}

		public void run() {
			int receive = 0;
			try {
				while((receive = in.read()) != -1){
					System.out.print((char)receive);
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		
	}
	
	
	
}
