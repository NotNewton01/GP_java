import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import org.junit.Test;

public class UTestLedger extends Helper {
	@Test
	public void test_structure_00() {
		try {
			Class<?> testClass = UTestLedger.class.getClassLoader().loadClass("Ledger");
			Method deposit = checkMethod(testClass, void.class, "deposit", double.class);
			Method withdraw = checkMethod(testClass, void.class, "withdraw", double.class);
			Method printBalance = checkMethod(testClass, void.class, "printBalance");
			
			Field id = checkField(testClass, "id", String.class, false);
			checkField(testClass, "balance", double.class, true);
			checkField(testClass, "pin", int.class, true);
			
			assertTrue("Die Klasse Ledger sollte public sein", Modifier.isPublic(testClass.getModifiers()));
			assertTrue("Attribut Ledger.id sollte protected sein", Modifier.isProtected(id.getModifiers()));
			assertTrue("Die Methode Ledger.deposit sollte keine Sichtbarkeit haben", isInternal(deposit));
			assertTrue("Die Methode Ledger.withdraw sollte keine Sichtbarkeit haben", isInternal(withdraw));
			assertTrue("Die Methode Ledger.printBalance sollte keine Sichtbarkeit haben", Modifier.isPublic(printBalance.getModifiers()));
			
		} catch (ClassNotFoundException e) {
			fail("Keine Klasse mit dem Namen Ledger");
		}
	}

	private boolean isInternal(Method m) {
		return !Modifier.isPrivate(m.getModifiers()) && !Modifier.isPublic(m.getModifiers()) && !Modifier.isProtected(m.getModifiers());
	}
}