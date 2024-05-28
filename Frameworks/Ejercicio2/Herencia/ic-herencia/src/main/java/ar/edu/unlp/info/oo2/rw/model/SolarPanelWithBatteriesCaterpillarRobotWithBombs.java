package ar.edu.unlp.info.oo2.rw.model;

public class SolarPanelWithBatteriesCaterpillarRobotWithBombs extends SolarPanelWithBatteriesCaterpillarRobot {

	public SolarPanelWithBatteriesCaterpillarRobotWithBombs(String name) {
		super(name);
	}

	@Override
	public void fireArms() {
		System.out.println("Robot " + this.getName() + " firing bombs");
	}

}
