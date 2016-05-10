package sample.tomcat.jsp.entity;

import org.springframework.stereotype.Component;

import javax.persistence.*;

/**
 * Created by Utilisateur on 07/04/2016.
 */

public class ModelWizard {
    private String step1;
    private String step2;
    private String step3;

    public String getStep1() {
        return step1;
    }

    public void setStep1(String step1) {
        this.step1 = step1;
    }

    public String getStep2() {
        return step2;
    }

    public void setStep2(String step2) {
        this.step2 = step2;
    }

    public String getStep3() {
        return step3;
    }

    public void setStep3(String step3) {
        this.step3 = step3;
    }
}
