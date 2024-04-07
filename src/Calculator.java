import java.util.Scanner;

public class Calculator {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        double result = 0;
        char operation;
        double operand2;
        while (true) {
            if (result == 0)
                result = nextDouble();
            operation = getOperation();
            if (operation == 's') {
                System.out.println("Программа завершена.");
                break;
            }
            operand2 = nextDouble();
            result = calc(result, operand2, operation);
            System.out.println("Результат операции: " + result);
            System.out.println("Хотите продолжить? (y/n/s)");
            char continueCalculation = scanner.next().charAt(0);
            if (continueCalculation == 'n' || continueCalculation == 's') {
                if (continueCalculation == 's') {
                    System.out.println("Программа завершена.");
                }
                break;
            }
        }
    }

    public static double nextDouble() {
        System.out.println("Введите число или 's' для выхода:");
        double operand;
        if (scanner.hasNextDouble()) {
            operand = scanner.nextDouble();
        } else if (scanner.hasNext("s")) {
            return 0;
        } else {
            System.out.println("Вы допустили ошибку при вводе числа. Попробуйте еще раз.");
            scanner.next();
            operand = nextDouble();
        }
        return operand;
    }

    public static char getOperation() {
        System.out.println("Введите операцию или 's' для выхода:");
        char operation;
        if (scanner.hasNext()) {
            operation = scanner.next().charAt(0);
        } else {
            System.out.println("Вы допустили ошибку при вводе операции. Попробуйте еще раз.");
            scanner.next();
            operation = getOperation();
        }
        return operation;
    }

    public static double calc(double operand1, double operand2, char operation) {
        double result;
        switch (operation) {
            case '+':
                result = operand1 + operand2;
                break;
            case '-':
                result = operand1 - operand2;
                break;
            case '*':
                result = operand1 * operand2;
                break;
            case '/':
                if (operand2 != 0) {
                    result = operand1 / operand2;
                } else {
                    System.out.println("Делить на ноль нельзя!");
                    System.out.println("Делить на ноль нельзя!");4

                    result = calc(operand1, nextDouble(), operation);
                }
                break;
            default:
                System.out.println("Операция не распознана. Повторите ввод.");
                result = calc(operand1, operand2, getOperation());
        }
        return result;
    }
}