/**
 * Created by I076057 on 7/23/2017.
 */
public class Hello {

    private final IHelloListen listen;

    public Hello(IHelloListen listen) {

        this.listen = listen;
    }

    public String say(String words) {

        return  this.listen.sayHello(words) +
                this.listen.sayWorld(words);
    }
}
