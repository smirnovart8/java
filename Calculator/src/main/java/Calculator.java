import java.util.Stack;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Calculator implements SimpleCalculator {

  private String inString;
  private static Logger logger;

  public Calculator(String inString) {
    this.inString = inString;
  }

  private String ExpressionToRPN(String expr) {
    String current = ""; //строка хранения выражения
    Stack<Character> stack = new Stack<>(); //стек хранения операторов

    int priorityOperation;

    for (int i = 0; i < expr.length(); i++) {
      priorityOperation = getPriorityOperation(expr.charAt(i));

      if (priorityOperation == 0) {
        current += expr.charAt(i);
      }
      if (priorityOperation == 1) {
        stack.push(expr.charAt(i));
      }

      if (priorityOperation > 1) {
        current += ' ';

        while (!stack.empty()) {
          if ((getPriorityOperation(stack.peek()) >= priorityOperation)) {
            current += stack.pop();
          } else {
            break;
          }
        }

        stack.push(expr.charAt(i));
      }
      if (priorityOperation == -1) {
        current += ' ';
        while (getPriorityOperation(stack.peek()) != 1) {
          current += stack.pop();
        }
        stack.pop();
      }


    }
    while (!stack.empty()) {
      current += stack.pop();
    }

    return current;

  }

  private double RPNtoDouble(String rpn) {
    String operand = new String();
    Stack<Double> stack = new Stack<>();

    for (int i = 0; i < rpn.length(); i++) {
      if (rpn.charAt(i) == ' ') {
        continue;
      }

      if (getPriorityOperation(rpn.charAt(i)) == 0) {
        while (rpn.charAt(i) != ' ' && getPriorityOperation(rpn.charAt(i)) == 0) {
          operand += rpn.charAt(i++);
          if (i == rpn.length()) {
            break;
          }
        }

        stack.push(Double.parseDouble(operand));
        operand = new String();
      }

      if (getPriorityOperation(rpn.charAt(i)) > 1) {
        double a = stack.pop();
        double b = stack.pop();

        switch (rpn.charAt(i)) {

          case '+':
            stack.push(b + a);
            break;
          case '-':
            stack.push(b - a);
            break;
          case '*':
            stack.push(b * a);
            break;
          case '/':
            stack.push(b / a);
            break;

        }

      }

    }
    return stack.pop();
  }

  private int getPriorityOperation(char operation) {

    switch (operation) {
      case '*':
        return 5;
      case '/':
        return 4;
      case '-':
        return 3;
      case '+':
        return 2;
      case '(':
        return 1;
      case ')':
        return -1;
      default:
        return 0;

    }

  }

  @Override
  public double process() {
    logger = LogManager.getRootLogger();

    String tmp = ExpressionToRPN(this.inString);

    double result = RPNtoDouble(tmp);

    if (result < 0) {
      result = 0;
      logger.error("Один из результатов меньше нуля");
      logger.info("Проверьте входные данные");
    }
    return result;
  }


}
