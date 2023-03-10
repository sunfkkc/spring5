package spring;

import org.springframework.beans.factory.annotation.Autowired;

public class AutowiredSample {


    private SomeInjection someInjection;

    @Autowired
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
