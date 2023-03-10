package spring;

public class AutowiredSample {

    private SomeInjection someInjection;

    public void setSomeInjection(SomeInjection someInjection) {
        this.someInjection = someInjection;
    }

    public void print(){

        someInjection.print();
    }
}
