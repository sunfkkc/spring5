package spring;

public class SomeInjection {

    private String madeBy;

    public SomeInjection(String madeBy) {
        this.madeBy = madeBy;
    }

    public void print(){

        System.out.println(madeBy+ "를 통한 의존성 주입 완료");
    }
}
