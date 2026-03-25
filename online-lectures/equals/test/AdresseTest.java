import org.junit.Test;
import static org.junit.Assert.*;
import java.lang.reflect.Method;

public class AdresseTest {
  @Test
  public void testEquals() {
    Adresse adresse1 = new Adresse("Hauptstraße", "42", "Berlin");
    Adresse adresse2 = new Adresse("Hauptstraße", "42", "Berlin");
    Adresse adresse3 = new Adresse("Nebenstraße", "1", "Hamburg");

    EasyAssert.assertTrue("Zwei Adressen mit gleichen Attributen sollten als gleich gelten.", adresse1.equals(adresse2));
    EasyAssert.assertTrue("Eine Adresse sollte mit sich selbst gleich sein.", adresse1.equals(adresse1));
    EasyAssert.assertTrue("Adressen mit unterschiedlichen Attributen sollten nicht als gleich gelten.", !adresse1.equals(adresse3));
    EasyAssert.assertTrue("Eine Adresse kann nicht gleich null sein.", !adresse1.equals(null));
    EasyAssert.assertTrue("Eine Adresse kann nicht gleich einem anderen Objekttyp sein.", !adresse1.equals("Hauptstraße 42, Berlin"));
  }

  @Test
  public void testEqualsMethodExists() {
    try {
      Method method = Adresse.class.getDeclaredMethod("equals", Object.class);
      // Wenn wir hier ankommen, existiert die Methode
    } catch (NoSuchMethodException e) {
      EasyAssert.fail("Die Klasse Adresse muss die equals-Methode implementieren.");
    }
  }
}