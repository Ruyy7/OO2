package ar.edu.unlp.info.oo2.rw.model;

public class OffRoad extends Locomotion {

	@Override
	public void move(Robot r) {
		System.out.println("Robot " + r.getName() + " moving on an Off-Road");
	}

}
