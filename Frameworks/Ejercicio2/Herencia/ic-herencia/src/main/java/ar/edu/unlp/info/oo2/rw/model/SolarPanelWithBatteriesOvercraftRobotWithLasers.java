package ar.edu.unlp.info.oo2.rw.model;

public class SolarPanelWithBatteriesOvercraftRobotWithLasers extends SolarPanelWithBatteriesOvercraftRobot {

	public SolarPanelWithBatteriesOvercraftRobotWithLasers(String name) {
		super(name);
	}

	@Override
	public void fireArms() {
		if (this.canConsumeBattery(80)) {
	        System.out.println("Robot " + this.getName() + " firing lasers");
		}
	}

}
