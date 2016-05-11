package sample.tomcat.jsp.entity;

/**
 * Created by Deruy on 10/05/2016.
 */
public class DevisHabitation {

    private HabitationEtape1 habitationEtape1;
    private HabitationEtape2 habitationEtape2;
    private HabitationEtape3 habitationEtape3;
    private HabitationEtape4 habitationEtape4;

    public DevisHabitation(){
        habitationEtape1 = new HabitationEtape1();
        habitationEtape2 = new HabitationEtape2();
        habitationEtape3 = new HabitationEtape3();
        habitationEtape4 = new HabitationEtape4();
    }

    public HabitationEtape1 getHabitationEtape1() {
        return habitationEtape1;
    }

    public void setHabitationEtape1(HabitationEtape1 habitationEtape1) {
        this.habitationEtape1 = habitationEtape1;
    }

    public HabitationEtape2 getHabitationEtape2() {
        return habitationEtape2;
    }

    public void setHabitationEtape2(HabitationEtape2 habitationEtape2) {
        this.habitationEtape2 = habitationEtape2;
    }

    public HabitationEtape3 getHabitationEtape3() {
        return habitationEtape3;
    }

    public void setHabitationEtape3(HabitationEtape3 habitationEtape3) {
        this.habitationEtape3 = habitationEtape3;
    }

    public HabitationEtape4 getHabitationEtape4() {
        return habitationEtape4;
    }

    public void setHabitationEtape4(HabitationEtape4 habitationEtape4) {
        this.habitationEtape4 = habitationEtape4;
    }
}
