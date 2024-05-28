package ar.edu.unlp.info.oo2.rw.model;

public abstract class SolarPanelWithBatteriesRobot extends Robot {

	public SolarPanelWithBatteriesRobot(String name) {
		super(name);
	}

	@Override
	public void consumeBattery() {
		System.out.println("Robot " + this.getName() + " solar panel energy");
	}


}
