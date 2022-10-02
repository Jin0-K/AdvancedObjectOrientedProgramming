
public class TextFieldWindowObserver implements Observer {
	
	private TextFieldWindow text_field_window;

    private boolean observer_state = false;
	
	public TextFieldWindowObserver(TextFieldWindow text_field_window) {
		this.text_field_window = text_field_window;
	}
	
	@Override
	public void update(Integer num) {
		String data = num.toString();
		text_field_window.updateText(data);
	}
	
	public boolean getState() { return observer_state; }
	
	public void changeState() {
		observer_state = !observer_state;
	}
}
