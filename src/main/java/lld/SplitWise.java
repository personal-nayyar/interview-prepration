package lld;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SplitWise {
}

class User{
    int id;
    String name;
    String email;
    String phone;
}

enum ExpenseType{
    EQUAL,
    EXACT,
    PERCENTAGE
}
class Split{}

class ExactSplit extends Split{}

class EqualSplit extends Split{}

class PercentageSplit extends Split{}

class Expense{
    Expense createExpense(User paidBy, int amount, ExpenseType expenseType, List<Split> splits){
        if (expenseType.equals(ExpenseType.PERCENTAGE)){
            int totalPer = 0;
            for (Split split: splits){
//                totalPer += split.getePercentage;
            }
        }
        return null;
    }
}

class ExpenseManager{
    Expense addExpense(User paidBy, int amount, ExpenseType expenseType, List<Split> splits){
        // validate splits
        // create Expense

        // manage balanceSheet
            // get balance for splits user and decrement amount for that user
            // get balance for paidBy and add amount to owe
      // send notifications
        return null;
    }
}

class BalanceSheet{
    Map<User, Map<User, Integer>> balanceSheet =  new HashMap<>();

    void showBalance(User user){
        balanceSheet.get(user);
    }
}