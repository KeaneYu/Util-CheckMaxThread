import java.util.concurrent.atomic.AtomicInteger;  
  
public class CheckMaxThread extends Thread {  
    private static final AtomicInteger count = new AtomicInteger();  
  
    public static void main(String[] args) {  
    	if(args.length==1){
    		long testCount = Long.valueOf(args[0]);
    		for(int i=0;i<testCount;i++)
    		{
    			(new CheckMaxThread()).start();
    		}
    		System.out.println("Success with "+testCount+" threads"); 
    		
    	}
    	else{
    		while (true)  
    			(new CheckMaxThread()).start();  
    	}
    }  
  
    @Override  
    public void run() {  
        System.out.println(count.incrementAndGet());  
  
        while (true)  
            try {  
                Thread.sleep(Integer.MAX_VALUE);  
            } catch (InterruptedException e) {  
                break;  
            }  
    }  
}  