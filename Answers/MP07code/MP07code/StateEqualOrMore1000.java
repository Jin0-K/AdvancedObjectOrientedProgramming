public class StateEqualOrMore1000 extends State {
    StateEqualOrMore1000(MainWindow window) {
        super(window);
    }

    @Override
    public void addHundred() {
        setMsgText("이미 충분한 돈이 투입되었습니다. 음료를 선택하세요");
    }

    @Override
    public void addFiveHundred() {
        setMsgText("이미 충분한 돈이 투입되었습니다. 음료를 선택하세요");
    }

    @Override
    public void addThousand() {
        setMsgText("이미 충분한 돈이 투입되었습니다. 음료를 선택하세요");
        setBalanceText();
    }

    @Override
    public void selectBeverage() {
        String msg = "음료를 내보냅니다. 배출구를 확인하세요.";
        setBalance(getBalance() - 1000);
        if (getBalance() > 0) {
            msg = msg + " 거스름돈 " + getBalance() + "원을 반환합니다.";
            setBalance(0);
        }
        setBalanceText();
        setMsgText(msg);
        setState0();
    }
}
