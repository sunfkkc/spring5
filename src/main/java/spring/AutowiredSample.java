package spring;

public class AutowiredSample {

    private SomeInjection someInjection;

    public AutowiredSample() {
        this.someInjection = new SomeInjection();
    }

    public void setSomeInjection(SomeInjection someInjection) {
        this.someInjection = someInjection;
    }

    public void print(){

        if( someInjection == null){
            System.out.println("someInjection object is null");
        }

        else{
            someInjection.print();
        }
    }


}
