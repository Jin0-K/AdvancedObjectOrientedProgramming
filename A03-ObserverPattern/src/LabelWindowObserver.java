
public class LabelWindowObserver implements Observer {
	private LabelWindow label_window;
	private boolean observer_state = false;
	
	public LabelWindowObserver(LabelWindow label_window) {
		this.label_window = label_window;
	}
	
	@Override
	public void update(Integer num) {
		String data = num.toString();
		label_window.updateText(data);
	}
	
	public boolean getState() { return observer_state; }
	
	public void changeState() {
		observer_state = !observer_state;
	}
}
