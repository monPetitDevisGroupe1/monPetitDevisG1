package sample.tomcat.jsp.entity;

/**
 * Created by Deruy on 10/05/2016.
 */
public class DevisVoiture {

    private VoitureEtape1 voitureEtape1;
    private VoitureEtape2 voitureEtape2;
    private VoitureEtape3 voitureEtape3;
    private VoitureEtape4 voitureEtape4;

    public DevisVoiture(){
        voitureEtape1 = new VoitureEtape1();
        voitureEtape2 = new VoitureEtape2();
        voitureEtape3 = new VoitureEtape3();
        voitureEtape4 = new VoitureEtape4();
    }

    public VoitureEtape1 getVoitureEtape1() {
        return voitureEtape1;
    }

    public void setVoitureEtape1(VoitureEtape1 voitureEtape1) {
        this.voitureEtape1 = voitureEtape1;
    }

    public VoitureEtape2 getVoitureEtape2() {
        return voitureEtape2;
    }

    public void setVoitureEtape2(VoitureEtape2 voitureEtape2) {
        this.voitureEtape2 = voitureEtape2;
    }

    public VoitureEtape3 getVoitureEtape3() {
        return voitureEtape3;
    }

    public void setVoitureEtape3(VoitureEtape3 voitureEtape3) {
        this.voitureEtape3 = voitureEtape3;
    }

    public VoitureEtape4 getVoitureEtape4() {
        return voitureEtape4;
    }

    public void setVoitureEtape4(VoitureEtape4 voitureEtape4) {
        this.voitureEtape4 = voitureEtape4;
    }
}
