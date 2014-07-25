import java.util.concurrent.atomic.AtomicInteger;

import javax.print.attribute.standard.SheetCollate;


public class NumberGenerator {

	public static void main(String[] args) {
		AtomicInteger shared_int = new AtomicInteger(0);
		
		EvenNumberGenerator even = new EvenNumberGenerator(shared_int);
		OddNumberGenerator odd = new OddNumberGenerator(shared_int);
		new Thread(even).start();
		new Thread(odd).start();
	}

}

class OddNumberGenerator implements Runnable{
	
	private AtomicInteger shared_int;
	
	public OddNumberGenerator(AtomicInteger shared_int){
		this.shared_int = shared_int;
	}

	@Override
	public void run() {
		while(shared_int.get()<=20){
			System.out.println(shared_int.addAndGet(1));
			try{
				Thread.sleep(1000);
			}
			catch(InterruptedException ex){
				
			}
		}
		
	}
	
}

class EvenNumberGenerator implements Runnable{
	
	private AtomicInteger shared_int;
	
	public EvenNumberGenerator(AtomicInteger shared_int){
		this.shared_int = shared_int;
	}

	@Override
	public void run() {
		
		while(shared_int.get()<=20){
			System.out.println(shared_int.addAndGet(1));
			try{
				Thread.sleep(1000);
			}
			catch(InterruptedException ex){
				
			}
		}
		
	}
	
}
