package fish.payara.examples.arquillian;

import javax.ejb.Stateless;
import org.eclipse.microprofile.faulttolerance.CircuitBreaker;
import org.eclipse.microprofile.faulttolerance.Fallback;

@Stateless
public class HelloWorld {

    @Fallback(fallbackMethod = "fallback")
    @CircuitBreaker
    public String sayHello(String message) {
        throw new RuntimeException("Testing the fallback method");
    }

    public String fallback(String message) {
        return "fallback";
    }
}
