package fish.payara.examples.arquillian;

import javax.inject.Singleton;
import org.eclipse.microprofile.faulttolerance.CircuitBreaker;
import org.eclipse.microprofile.faulttolerance.Fallback;

@Singleton
public class HelloWorld2 {

    @Fallback(fallbackMethod = "fallback")
    @CircuitBreaker
    public String sayHello(String message) {
        throw new RuntimeException("Testing the fallback method");
    }

    public String fallback(String message) {
        return "fallback";
    }
}
