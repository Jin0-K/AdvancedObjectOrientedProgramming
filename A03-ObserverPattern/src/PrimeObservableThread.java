
public class PrimeObservableThread implements Runnable {
    private static final int SLEEPTIME = 500;

    private int primeNumber;
    private int numCount = 1;
    private boolean stopRunning = false;
    
    // Observers
    private TextFieldWindowObserver tf_observer; 
    private LabelWindowObserver l_observer;
    
    public PrimeObservableThread(TextFieldWindowObserver tf_observer, LabelWindowObserver l_observer) {
    	this.tf_observer = tf_observer;
    	this.l_observer = l_observer;
    }

    public int getPrimeNumber() { return primeNumber; }

    public void stopRunning() { stopRunning = true; }

    public void startRunning() {
        stopRunning = false;
        run();
    }
    
    /*
    // Add observer to observers
    public void addObserver(TextFieldWindowObserver tf_observer) {
    	observers.add(tf_observer);
    }
    public void addObserver(LabelWindowObserver l_observer) {
    	observers.add(l_observer);
    }
    // Remove observer from observers
    public void removeObserver(TextFieldWindowObserver tf_observer){
    	int i = 0;
    	for (Observer observer : observers) {
    		if (observer instanceof TextFieldWindowObserver) {
    			observers.remove(i);
    		}
    		i++;
    	}
    }
    public void removeObserver(LabelWindowObserver l_observer){
    	int i = 0;
    	for (Observer observer : observers) {
    		if (observer instanceof LabelWindowObserver) {
    			observers.remove(i);
    		}
    		i++;
    	}
    }
    */
    
    public void notify(int num) {
    	Integer data = Integer.valueOf(num); 
    	if (tf_observer.getState()) {
    		tf_observer.update(data);
    	}
    	if (l_observer.getState()) {
    		l_observer.update(data);
    	}
    }

    private void generatePrimeNumber() {
        primeNumber = 2;
        System.out.println(primeNumber);
        while (stopRunning == false) {
            numCount += 2; // 2를 제외한 짝수는 소수가 될 수 없음. 따라서 홀수만 검사
            if (isPrimeNumber(numCount)) {
                primeNumber = numCount;
                System.out.println(primeNumber);
                notify(numCount);
            }
            try {
                Thread.sleep(SLEEPTIME); // 1초 쉼
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private boolean isPrimeNumber(int n) {
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    @Override
    public void run() { generatePrimeNumber(); }
}
