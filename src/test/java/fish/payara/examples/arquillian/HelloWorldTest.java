package fish.payara.examples.arquillian;

import javax.inject.Inject;
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
    HelloWorld helloWorld;

    @Test
    public void sayHelloTest() {
        Assert.isEqual(helloWorld.sayHello("MyMessage"), "fallback", "Fallback message was not returned.");
    }
}