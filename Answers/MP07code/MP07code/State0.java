public class State0 extends State {
    State0 (MainWindow window) {
        super(window);
    }

    @Override
    public void addHundred() {
        addBalance(100);
        setStateLess500();
        showBalanceAndEmptyMsg();
    }

    @Override
    public void addFiveHundred() {
        addBalance(500);
        setState500();
        showBalanceAndEmptyMsg();
    }

    @Override
    public void addThousand() {
        addBalance(1000);
        setStateEqualOrMore1000();
        showBalanceAndEmptyMsg();
    }

    @Override
    public void returnChanges() {
        setMsgText("");
    }

    @Override
    public void selectBeverage() {
        setMsgText("돈을 넣은 후에 눌러주세요");
    }
}
