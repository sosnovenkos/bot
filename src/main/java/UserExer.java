public class UserExer {
    int operand1;
    int operand2;
    int answer;
    String operation;
    int okCount;
    int erCount;
    String expression;

    public UserExer() {
        operand1 = (int) (Math.random() * 100);
        operand2 = (int) (Math.random() * 100);
        if (operand1<operand2)
        {
            int temp = operand2;
            operand2 = operand1;
            operand1 = temp;
        }
        if (operand1%2==0) operation="+";
        else operation="-";

        answer = (operation.equals("+")) ? (operand1+operand2) : (operand1-operand2);
        expression=""+operand1+" "+operation+" "+operand2+" "+" = ";
    }

    public int getOperand1() {
        return operand1;
    }

    public void setOperand1(int operand1) {
        operand1 = operand1;
    }

    public int getOperand2() {
        return operand2;
    }

    public void setOperand2(int operand2) {
        operand2 = operand2;
    }

    public int getAnswer() {
        return answer;
    }

    public void setAnswer(int answer) {
        answer = answer;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        operation = operation;
    }

    public int getOkCount() {
        return okCount;
    }

    public void setOkCount(int okCount) {
        okCount = okCount;
    }

    public int getErCount() {
        return erCount;
    }

    public void setErCount(int erCount) {
        erCount = erCount;
    }

    public String getExpression() {
        return expression;
    }

    public void setExpression(String checked) {
        expression = checked;
    }

    //public UserExer getNewExer(){
//        UserExer userExer = new UserExer();
//        userExer.operand1 = (int) (Math.random() * 100);
//        userExer.operand2 = (int) (Math.random() * 100);
//        if (userExer.operand1<userExer.operand2)
//        {
//            int temp = userExer.operand2;
//            userExer.operand2 = userExer.operand1;
//            userExer.operand1 = temp;
//        }
//        if (userExer.operand1%2==0) userExer.operation="+";
//        else userExer.operation="-";
//
//        userExer.answer = (userExer.operation.equals("+")) ? (userExer.operand1+userExer.operand2) : (userExer.operand1-userExer.operand2);
//        userExer.expression=""+userExer.operand1+" "+userExer.operation+" "+userExer.operand2+" "+" = ";
//        return userExer;
       // UserExer userExer = new UserExer();



}
