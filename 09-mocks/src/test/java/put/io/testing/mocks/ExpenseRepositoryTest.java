package put.io.testing.mocks;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.InOrder;

import put.io.students.fancylibrary.database.FancyDatabase;
import put.io.students.fancylibrary.database.IFancyDatabase;

public class ExpenseRepositoryTest {

    @Test
    void loadExpenses() {

        //MyDatabase db = new MyDatabase() ;
        IFancyDatabase mockDb = mock(IFancyDatabase.class);
        when(mockDb.queryAll()).thenReturn(Collections.emptyList());

        ExpenseRepository rep = new ExpenseRepository(mockDb);
        rep.loadExpenses();

        InOrder order = inOrder(mockDb);
        order.verify(mockDb).connect();
        order.verify(mockDb).queryAll();
        order.verify(mockDb).close();

        List<Expense> list = rep.getExpenses();

        assertEquals(0, list.size());

    }

    @Test
    void saveExpenses(){
        IFancyDatabase mockDb = mock(IFancyDatabase.class);
        when(mockDb.queryAll()).thenReturn(Collections.emptyList());

        ExpenseRepository rep = new ExpenseRepository(mockDb);
        rep.loadExpenses();
        Expense expense = new Expense();
        rep.addExpense(expense);
        rep.addExpense(expense);
        rep.addExpense(expense);
        rep.addExpense(expense);
        rep.addExpense(expense);
        rep.saveExpenses();

        InOrder order = inOrder(mockDb);
        order.verify(mockDb).connect();
        order.verify(mockDb).queryAll();
        order.verify(mockDb).close();
        verify(mockDb, times(5)).persist(any(Expense.class));

        //List<Expense> list = rep.getExpenses();

        //assertEquals(0, list.size());
    }
}
