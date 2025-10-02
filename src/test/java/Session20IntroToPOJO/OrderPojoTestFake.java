/**
 * Test class for POJO getter and setter practice.
 *
 * <p>
 * Note:
 * - This test class is only for understanding and practicing how to use getter and setter methods
 *   of POJO classes located in a different package.
 * - These tests do NOT send any payloads or interact with APIs.
 * - The focus is on verifying that the getter and setter methods work as expected.
 * - If a POJO contains another POJO as a variable, you can create and set that object
 *   using its own getter/setter methods in a similar way.
 * </p>
 *
 * === POJO Reference & Setter Theory Points ===
 *
 * 1. When a class (e.g., Items) has a variable of another class type (e.g., Attributes),
 *    it means the parent object "contains" or "references" the child object.
 *
 * 2. To set or update this reference, always create the child object first,
 *    then use the setter method in the parent object.
 *    Example:
 *      Attributes att = new Attributes("Red", ...);
 *      Items item = new Items();
 *      item.setAttributes(att);
 *
 * 3. The setter method for a class-type variable always takes an object of that class as a parameter.
 *    Example:
 *      public void setAttributes(Attributes attributes) {
 *          this.attributes = attributes;
 *      }
 *
 * 4. To update the referenced object, create a new object and call the setter again.
 *    Example:
 *      Attributes newAtt = new Attributes("Blue", ...);
 *      item.setAttributes(newAtt); // Now item.attributes points to newAtt
 *
 * 5. The getter method returns the referenced object, so you can access its fields/methods.
 *    Example:
 *      String color = item.getAttributes().getColor();
 *
 * 6. This pattern is the same for any POJO reference (e.g., Customer in Order, Address in Customer, etc.).
 *
 * 7. Always use List<Type> (not &lt;Type&gt;) for collections in Java code.
 *
 * 8. Setters for class-type variables allow you to "swap out" the referenced object at any time.
 *
 * 9. In tests, create all referenced objects first, then pass them to the parent object via constructor or setter.
 *
 * 10. This approach keeps your code modular, readable, and easy to update or test.
 *
 * Extra:
 * - You can use IDE shortcuts (like Alt+Shift+S, then R in Eclipse) to auto-generate getters and setters.
 * - In real-world projects, POJO tests are rare, but practicing them helps you understand object relationships.
 * - For nested POJOs, always access inner fields via chained getters (e.g., order.getCustomer().getName()).
 */

package Session20IntroToPOJO;

import java.util.Arrays;
import java.util.List;

import org.testng.annotations.Test;
import com.restassured.pojo.orderpractice.Attributes;
import com.restassured.pojo.orderpractice.Customers;
import com.restassured.pojo.orderpractice.Items;
import com.restassured.pojo.orderpractice.Order;
import com.restassured.pojo.orderpractice.Payment;
import com.restassured.pojo.orderpractice.ShippingAddress;

public class OrderPojoTestFake {

    // Example: Creating all POJOs and linking them together
    public void testAllPojoGetterAndSetter() {
        Customers customer = new Customers("2345", "ALokSwian", Arrays.asList("slow@gmail.com", "high@gmail.com", "medium@gmail.com"));
        Attributes att = new Attributes("Red", Arrays.asList("Good For use", "Nice to have it"));
        Items item = new Items("CCD345", "Fridge", 4567.90, 789, att);
        ShippingAddress spad = new ShippingAddress("NilachalBazzar", "Paradeep", "754143");
        Payment payment = new Payment("Online", 20456.45, "Success");
        Order order = new Order("FridgeOrder", customer, spad, item, att, payment);
        // You can now use getters to verify values if needed
    }

    @Test
    public void setterAndGetterCustomers() {
        Customers customer = new Customers("2345", "ALokSwian", Arrays.asList("slow@gmail.com", "high@gmail.com", "medium@gmail.com"));
        customer.setEmails(Arrays.asList("nice@gmail.com", "good@gmail.com"));
        String customerId = customer.getCustomerId();
        List<String> emails = customer.getEmails();
        for (String email : emails) {
            System.out.println("Collected Email: " + email);
        }
    }

    @Test
    public void setterAndGetterItems() {
        Attributes att = new Attributes("Red", Arrays.asList("Good For use", "Nice to have it"));
        att.setFeatures(Arrays.asList("Better For use", "Great To Have It"));
        Items item = new Items("CCD345", "Fridge", 4567.90, 789, att);
        item.setAttributes(att);
        Attributes atr = item.getAttributes();
        System.out.println("Get Color: " + atr.getColor());
        List<String> features = atr.getFeatures();
        for (String feature : features) {
            System.out.println("Find the Stored Feature Number: " + feature);
        }
    }
}

// Example: If Customers had a variable of type Address (another POJO)
// Address address = new Address();
// address.setCity("Bangalore");
// customer.setAddress(address);
// assertEquals("Bangalore", customer.getAddress().getCity());
