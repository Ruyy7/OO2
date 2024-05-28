package ar.edu.unlp.info.oo2.rw.model;

public class SolarPanelWithBatteriesCaterpillarRobotWithLasers extends SolarPanelWithBatteriesCaterpillarRobot {

	public SolarPanelWithBatteriesCaterpillarRobotWithLasers(String name) {
		super(name);
	}

	@Override
	public void fireArms() {
		if (this.canConsumeBattery(99)) {
			System.out.println("Robot " + this.getName() + " firing lasers");
		}
	}

}
