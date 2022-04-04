package fish.payara.examples.arquillian;

import javax.inject.Inject;
import javax.inject.Named;
import org.eclipse.persistence.jpa.jpql.Assert;
import org.eu.ingwar.tools.arquillian.extension.suite.annotations.ArquillianSuiteDeployment;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(Arquillian.class)
public class HelloWorldTest extends IntegrationTestSuite {

    @Inject
    HelloWorld2 helloWorld2;

    @Inject
    HelloWorld helloWorld;

    @Test(expected = RuntimeException.class)
    public void sayHelloTest() {
        Assert.isEqual(helloWorld.sayHello("MyMessage"), "fallback", "Fallback message was not returned.");
    }

    @Test
    public void sayHello2Test() {
        Assert.isEqual(helloWorld2  .sayHello("MyMessage"), "fallback", "Fallback message was not returned.");
    }
}