import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MainWindow extends FrameWindow implements ActionListener {
    private static final int X = 250;
    private static final int Y = 100;
    private static final int WIDTH = 600;
    private static final int HEIGHT = 250;
    private static final int NUM_BUTTONS = 3;
    private static final int BUTTON_HEIGHT = 50;
    private static final String HUNDRED_BUTTON_TITLE = "100";
    private static final String THOUSAND_BUTTON_TITLE = "1000";
    private static final String FIVE_HUNDRED_BUTTON_TITLE = "500";
    private static final String RETURN_CHANGE_BUTTON_TITLE = "Return Changes";
    private static final String SELECT_BEVERAGE_BUTTON_TITLE = "Select a beverage";
    private JLabel balanceLabel;  // 현재 투입 금액을 나타내는 화면
    private JLabel msgLabel; // 기타 메시지를 보여주기 위한 화면
    private MyButton hundredButton;
    private MyButton fiveHundredButton;
    private MyButton thousandButton;
    private MyButton returnChangesButton;
    private MyButton selectBeverageButton;

    private enum STATES { STATE_0, STATE_LESS_500, STATE_500, STATE_LESS_1000, STATE_EQUAL_OR_MORE_1000};
    private STATES state;
    private int balance;

    public MainWindow(String title) {
        super();
        createWindow(title, X, Y, WIDTH, HEIGHT);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        state = STATES.STATE_0;
        balance = 0;
    }

    public JPanel createPanel(int width, int height) {
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        balanceLabel = new JLabel();
        msgLabel = new JLabel();

        // create buttons
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BorderLayout());
        JPanel coinButtonPanel = new JPanel();
        coinButtonPanel.setLayout(new BoxLayout(coinButtonPanel, BoxLayout.X_AXIS));
        coinButtonPanel.setPreferredSize(new Dimension(width, BUTTON_HEIGHT));
        hundredButton = new MyButton(HUNDRED_BUTTON_TITLE);
        hundredButton.setProperties(this, width / NUM_BUTTONS, BUTTON_HEIGHT);
        coinButtonPanel.add(hundredButton);
        fiveHundredButton = new MyButton(FIVE_HUNDRED_BUTTON_TITLE);
        fiveHundredButton.setProperties(this, width / NUM_BUTTONS, BUTTON_HEIGHT);
        coinButtonPanel.add(fiveHundredButton);
        thousandButton = new MyButton(THOUSAND_BUTTON_TITLE);
        thousandButton.setProperties(this, width / NUM_BUTTONS, BUTTON_HEIGHT);
        coinButtonPanel.add(thousandButton);
        buttonPanel.add(coinButtonPanel, BorderLayout.NORTH);
        returnChangesButton = new MyButton(RETURN_CHANGE_BUTTON_TITLE);
        returnChangesButton.setProperties(this, width / NUM_BUTTONS, BUTTON_HEIGHT);
        buttonPanel.add(returnChangesButton, BorderLayout.CENTER);
        selectBeverageButton = new MyButton(SELECT_BEVERAGE_BUTTON_TITLE);
        selectBeverageButton.setProperties(this, width / NUM_BUTTONS, BUTTON_HEIGHT);
        buttonPanel.add(selectBeverageButton, BorderLayout.SOUTH);

        panel.add(buttonPanel, BorderLayout.NORTH);
        balanceLabel.setPreferredSize(new Dimension(width, (HEIGHT - BUTTON_HEIGHT) / 2));
        panel.add(balanceLabel, BorderLayout.CENTER);
        msgLabel.setPreferredSize(new Dimension(width, (HEIGHT - BUTTON_HEIGHT) / 2));
        panel.add(msgLabel, BorderLayout.SOUTH);
        setBalanceText(); // 투입 금액 0
        return panel;
    }

    public void setBalanceText() {
        balanceLabel.setText("현재 투입 금액: " + balance + "원");
    }

    public void setMsgText(String msg) {
        msgLabel.setText(msg);
    }

    public void addHundred() {
        balance += 100;
        if (state == STATES.STATE_0) {
            state = STATES.STATE_LESS_500;
        }
        else if (state == STATES.STATE_LESS_500) {
            if (balance == 500) {
                state = STATES.STATE_500;
            }
        }
        else if (state == STATES.STATE_500) {
            state = STATES.STATE_LESS_1000;
        }
        else if (state == STATES.STATE_LESS_1000) {
            if (balance == 1000) {
                state = STATES.STATE_EQUAL_OR_MORE_1000;
            }
        }
        setBalanceText();
        setMsgText("");
    }

    public void addFiveHundred() {
        balance += 500;
        if (state == STATES.STATE_0) {
            state = STATES.STATE_500;
        }
        else if (state == STATES.STATE_LESS_500) {
            state = STATES.STATE_LESS_1000;
        }
        else if (state == STATES.STATE_500 || state == STATES.STATE_LESS_1000) {
            state = STATES.STATE_EQUAL_OR_MORE_1000;
        }
        setBalanceText();
        setMsgText("");
    }

    public void addThousand() {
        balance += 1000;
        if (state == STATES.STATE_0 || state == STATES.STATE_LESS_500
                || state == STATES.STATE_500 || state == STATES.STATE_LESS_1000) {
            state = STATES.STATE_EQUAL_OR_MORE_1000;
            setMsgText("");
        }
        else if (state == STATES.STATE_EQUAL_OR_MORE_1000) {
            setMsgText("이미 충분한 돈이 투입되었습니다. 음료를 선택하세요");
        }
        setBalanceText();
    }

    public void returnChanges() {
        if (state == STATES.STATE_LESS_500 || state == STATES.STATE_500 ||
            state == STATES.STATE_LESS_1000 || state == STATES.STATE_EQUAL_OR_MORE_1000) {
            state = STATES.STATE_0;
            setMsgText("" + balance + "원을 반환합니다");
            balance = 0;
            setBalanceText();
        }
        else {
            setMsgText("돈을 넣은 후에 눌러주세요");
        }
    }

    public void selectBeverage() {
        if (state == STATES.STATE_EQUAL_OR_MORE_1000) {
            String msg = "음료를 내보냅니다. 배출구를 확인하세요.";
            balance -= 1000;
            if (balance > 0) {
                msg = msg + " 거스름돈 " + balance + "원을 반환합니다.";
                balance = 0;
            }
            setBalanceText();
            setMsgText(msg);
            state = STATES.STATE_0;
        }
        else if (state == STATES.STATE_0) {
            setMsgText("돈을 넣은 후에 눌러주세요");
        }
        else {
            setMsgText("1000원 이상을 넣은 후에 눌러주세요");
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == hundredButton) {
            addHundred();
        }
        else if (e.getSource() == fiveHundredButton) {
            addFiveHundred();
        }
        else if (e.getSource() == thousandButton) {
            addThousand();
        }
        else if (e.getSource() == returnChangesButton) {
            returnChanges();
        }
        else if (e.getSource() == selectBeverageButton) {
            selectBeverage();
        }
    }
}
