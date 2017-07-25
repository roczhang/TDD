import org.hamcrest.core.AnyOf;
import org.jmock.*;
import org.jmock.integration.junit4.JMock;
import org.jmock.integration.junit4.JUnit4Mockery;
import org.jmock.integration.junit4.JUnitRuleMockery;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.jmock.Mockery;

import static org.hamcrest.CoreMatchers.endsWith;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Created by I076057 on 7/22/2017.
 */


public class TestMockHello {

    //Mockery mokery = new JUnit4Mockery();

    @Rule
    public  JUnitRuleMockery mokery = new JUnitRuleMockery();

    @Test
    public void test1() throws Exception {

        IHelloListen listen = mokery.mock(IHelloListen.class);
        Hello hello = new Hello(listen);

        mokery.checking( new Expectations(){
                {

                    final Sequence step = mokery.sequence("first-hello-then-world");
                    final States states = mokery.states("hello-states").startsAs("on");

                    oneOf(listen).sayHello(with(equal("hello")));
                    will(returnValue( "hello"));
                    when( states.is("on"));
                    inSequence(step);
                    then( states.is("off"));


                    oneOf(listen).sayWorld(with(equal("hello")));
                    will(returnValue( "hello"));
                    when( states.is("off"));
                    inSequence(step);

                }
        });
        assertThat(hello.say("hello"), endsWith("hello"));
    }
}