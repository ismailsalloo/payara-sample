package fish.payara.examples.arquillian;

import javax.ejb.Stateless;
import javax.enterprise.inject.Default;
import org.eclipse.microprofile.faulttolerance.CircuitBreaker;
import org.eclipse.microprofile.faulttolerance.Fallback;

@Stateless
@Default
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
