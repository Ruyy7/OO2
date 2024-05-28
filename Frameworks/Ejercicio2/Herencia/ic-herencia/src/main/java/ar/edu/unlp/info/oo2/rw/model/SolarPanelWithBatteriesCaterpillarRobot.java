package ar.edu.unlp.info.oo2.rw.model;

public abstract class SolarPanelWithBatteriesCaterpillarRobot extends SolarPanelWithBatteriesRobot {

	public SolarPanelWithBatteriesCaterpillarRobot(String name) {
		super(name);
	}

	@Override
	public void move() {
		System.out.println("Robot " + this.getName() + " moving on caterpillar");
	}


}
