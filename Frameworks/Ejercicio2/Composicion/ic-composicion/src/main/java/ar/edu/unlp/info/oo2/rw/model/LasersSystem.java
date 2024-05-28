package ar.edu.unlp.info.oo2.rw.model;

public class LasersSystem extends ArmsSystem
{
    public void fireArms(Robot r) {
    	if (r.getEnergySource().canConsume(80)) {
            System.out.println("Robot " + r.getName() + " firing lasers");
    	}
    } 
 
}
