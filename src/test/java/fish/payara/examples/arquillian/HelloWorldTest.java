package fish.payara.examples.arquillian;

import javax.inject.Inject;
import org.eclipse.persistence.jpa.jpql.Assert;
import org.jboss.arquillian.junit.Arquillian;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(Arquillian.class)
public class HelloWorldTest extends IntegrationTestSuite {

    @Inject
    HelloWorld2 helloWorld2;

    @Inject
    HelloWorld helloWorld;

    @Test
    public void sayHelloTest() {
        Assert.isEqual(helloWorld.sayHello("MyMessage"), "fallback", "Fallback message was not returned.");
    }

    @Test
    public void sayHello2Test() {
        Assert.isEqual(helloWorld2.sayHello("MyMessage"), "fallback", "Fallback message was not returned.");
    }
}