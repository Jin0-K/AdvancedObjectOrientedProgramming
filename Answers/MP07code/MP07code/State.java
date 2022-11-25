public abstract class State {
    MainWindow mainWindow;

    State(MainWindow window) {
        mainWindow = window;
    }

    public void addBalance(int balance) {
        mainWindow.addBalance(balance);
    }

    public void setBalance(int balance) {
        mainWindow.setBalance(balance);
    }

    public int getBalance() {
        return mainWindow.getBalance();
    }

    public void setState0() {
        mainWindow.setState(mainWindow.getState0());
    }

    public void setState500() {
        mainWindow.setState(mainWindow.getState500());
    }

    public void setStateLess500() {
        mainWindow.setState(mainWindow.getStateLess500());
    }

    public void setStateLess1000() {
        mainWindow.setState(mainWindow.getStateLess1000());
    }

    public void setStateEqualOrMore1000() {
        mainWindow.setState(mainWindow.getStateStateEqualOrMore1000());
    }

    public void setBalanceText() {
        mainWindow.setBalanceText();
    }

    public void setMsgText(String msg) {
        mainWindow.setMsgText(msg);
    }

    public void showBalanceAndEmptyMsg() {
        setBalanceText();
        setMsgText("");
    }

    public abstract void addHundred();
    public abstract void addFiveHundred();
    public abstract void addThousand();

    public void returnChanges() {
        setState0();
        setMsgText("" + getBalance() + "원을 반환합니다");
        setBalance(0);
        setBalanceText();
    }

    public abstract void selectBeverage();
}
