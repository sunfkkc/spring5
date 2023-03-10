package spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class AutowiredSample {


    private SomeInjection someInjection;

    public AutowiredSample(){
        this.someInjection = new SomeInjection("생성자");
    }

    @Autowired(required = false)
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
