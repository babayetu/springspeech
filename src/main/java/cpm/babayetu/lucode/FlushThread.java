package cpm.babayetu.lucode;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class FlushThread<T> implements Runnable {
	private final String name;
	//队列大小
	private final int bufferSize;
	//操作间隔
	private int flushInterval;
	
	//上次提交视角
	private volatile long lastFlushTime;
	private volatile Thread thWriter;
	
	//拥有数据的拥塞队列
	private final BlockingQueue<T> queue;
	
	//达成条件后的处理器
	private final Processor<T>	processor;
	
	
	public FlushThread(String name, int bufferSize, int flushInterval, long lastFlushTime, 
			Thread thWriter,
			int queueSize,
			 Processor<T> processor) {
		this.name = name;
		this.bufferSize = bufferSize;
		this.flushInterval = flushInterval;
		this.lastFlushTime = lastFlushTime;
		this.thWriter = thWriter;
		
		this.processor = processor;
		
		this.queue = new ArrayBlockingQueue<T>(queueSize);
	}


	@Override
	public void run() {
		// TODO Auto-generated method stub

	}

}
