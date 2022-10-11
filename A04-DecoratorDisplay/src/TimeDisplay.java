import java.awt.Dimension;
import javax.swing.BoxLayout;
import javax.swing.JPanel;

public class TimeDisplay extends DisplayDecorator {
	private Display displayComponent;
	JPanel panel;
	LabelPanel label;
	
	public TimeDisplay(Display display, int width, int height) {
		super(display, width, height);
		displayComponent = display;
	}

	@Override
	public JPanel create() {
		panel = new JPanel();
		// Set layout
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        // Set size of panel
        panel.setMinimumSize(new Dimension(getWidth(), getHeight()));
        panel.setPreferredSize(new Dimension(getWidth(), getHeight()));
        // Add panel of previous display
        panel.add(displayComponent.create());
        // Attach label to panel
        label = new LabelPanel();
        panel.add(label.createPanel(getWidth(), getHeight()));
        
		return panel;
	}

	@Override
	public void show() {
		displayComponent.show();
		label.updateText(java.time.LocalDateTime.now().toString());
	}

    @Override
    public int getHeight(){
        return  super.getHeight() + displayComponent.getHeight();
    }
}
