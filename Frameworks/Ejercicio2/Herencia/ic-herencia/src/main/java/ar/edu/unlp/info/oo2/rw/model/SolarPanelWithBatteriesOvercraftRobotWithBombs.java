package ar.edu.unlp.info.oo2.rw.model;

public class SolarPanelWithBatteriesOvercraftRobotWithBombs extends SolarPanelWithBatteriesOvercraftRobot {

	public SolarPanelWithBatteriesOvercraftRobotWithBombs(String name) {
		super(name);
	}

	@Override
	public void fireArms() {
		System.out.println("Robot " + this.getName() + " firing bombs");
	}

}
