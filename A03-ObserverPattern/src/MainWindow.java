import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MainWindow extends FrameWindow implements ActionListener {
    private static final String MAIN_TITLE = "Main Window";
    private static final String TEXTFIELD_WINDOW_TITLE = "TextField Window";
    private static final String LABEL_WINDOW_TITLE = "Label Window";
    private static final String TEXTFIELD_OBSERVER_BUTTON_ADD_TITLE = "Add TextField Window Observer";
    private static final String TEXTFIELD_OBSERVER_BUTTON_REMOVE_TITLE = "Remove TextField Window Observer";
    private static final String LABEL_OBSERVER_BUTTON_ADD_TITLE = "Add Label Window Observer";
    private static final String LABEL_OBSERVER_BUTTON_REMOVE_TITLE = "Remove Label Window Observer";
    private static final String STOP_THREAD_BUTTON_TITLE = "Stop Generating Prime Number";
    private static final int X = 250;
    private static final int Y = 100;
    private static final int WIDTH = 600;
    private static final int HEIGHT = 200;
    private static final int GAP = 50;
    private static final int NUM_BUTTONS = 3;

    private JButton stopButton;
    private JButton TextFieldObserverButton;
    private JButton LabelObserverButton;
    private PrimeObservableThread primeThread;
    private TextFieldWindow textFieldWindow;
    private LabelWindow labelWindow;
    // Observers
    private TextFieldWindowObserver tf_observer;
    private LabelWindowObserver l_observer;

    
    public boolean text_field_state = false;
    public boolean label_state = false;

    public MainWindow(String title) {
        super(title, X, Y, WIDTH, HEIGHT);
        textFieldWindow = new TextFieldWindow(TEXTFIELD_WINDOW_TITLE, X, Y + HEIGHT + GAP, WIDTH, HEIGHT);
        labelWindow = new LabelWindow(LABEL_WINDOW_TITLE, X, Y + (HEIGHT + GAP) * 2, WIDTH, HEIGHT);
        tf_observer = new TextFieldWindowObserver(textFieldWindow); 
        l_observer = new LabelWindowObserver(labelWindow);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                primeThread.stopRunning();
                textFieldWindow.closeWindow();
                labelWindow.closeWindow();
                System.exit(0);
            }
        });

        primeThread = new PrimeObservableThread(tf_observer, l_observer); // 객체 생성
        
        primeThread.run();  // 소수 생성 시작. 이 함수가 실행된 후에는 stopButton이 눌리기 전까지 무한 반복됨
    }

    public JPanel createPanel(int width, int height) {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setPreferredSize(new Dimension(width, height));
        TextFieldObserverButton = createButton(TEXTFIELD_OBSERVER_BUTTON_ADD_TITLE, this, width, height);
        panel.add(TextFieldObserverButton);
        LabelObserverButton = createButton(LABEL_OBSERVER_BUTTON_ADD_TITLE, this, width, height);
        panel.add(LabelObserverButton);
        stopButton = createButton(STOP_THREAD_BUTTON_TITLE, this, width, height);
        panel.add(stopButton);
        return panel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    	// Text Field Button Clicked
        if (e.getSource() == TextFieldObserverButton) {
            if (text_field_state) {
            	TextFieldObserverButton.setText(TEXTFIELD_OBSERVER_BUTTON_ADD_TITLE);
            }
            else {
            	TextFieldObserverButton.setText(TEXTFIELD_OBSERVER_BUTTON_REMOVE_TITLE);
            }
            text_field_state = !text_field_state;
            tf_observer.changeState();
        }
        //Label Button Clicked
        else if (e.getSource() == LabelObserverButton) {
            if (label_state) {
            	LabelObserverButton.setText(LABEL_OBSERVER_BUTTON_ADD_TITLE);
            }
            else {
            	LabelObserverButton.setText(LABEL_OBSERVER_BUTTON_REMOVE_TITLE);
            }
            label_state = !label_state;
            l_observer.changeState();
        }
        else if (e.getSource() == stopButton) {
            primeThread.stopRunning();
        }
    }

    private JButton createButton(String text, ActionListener listener, int width, int height) {
        JButton button = new JButton(text);
        button.addActionListener(listener);
        Dimension buttonDimension = new Dimension(width, height / NUM_BUTTONS);
        button.setMaximumSize(buttonDimension);
        button.setMinimumSize(buttonDimension);
        button.setPreferredSize(buttonDimension);
        return button;
    }

    public static void main(String[] args) {
        new MainWindow(MainWindow.MAIN_TITLE);
    }
}
