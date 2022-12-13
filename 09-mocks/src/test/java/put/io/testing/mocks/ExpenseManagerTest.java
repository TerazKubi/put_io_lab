package put.io.testing.mocks;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.net.ConnectException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;
import put.io.students.fancylibrary.service.FancyService;

public class ExpenseManagerTest {

    @Test
    void calculateTotal() {
        ExpenseRepository mockRep = mock(ExpenseRepository.class);

        ArrayList<Expense> expenses = new ArrayList<Expense>();

        Expense exp1 = new Expense();
        Expense exp2 = new Expense();
        Expense exp3 = new Expense();

        exp1.setAmount(100);
        exp2.setAmount(10);
        exp3.setAmount(33);

        expenses.add(exp1);
        expenses.add(exp2);
        expenses.add(exp3);

        when(mockRep.getExpenses()).thenReturn(expenses);

        ExpenseManager manager = new ExpenseManager(mockRep, new FancyService());

        double result = manager.calculateTotal();

        assertEquals(143, result);

    }
}
