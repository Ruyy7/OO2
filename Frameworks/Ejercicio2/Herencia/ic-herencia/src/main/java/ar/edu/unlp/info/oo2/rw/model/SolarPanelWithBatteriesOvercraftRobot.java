package ar.edu.unlp.info.oo2.rw.model;

public abstract class SolarPanelWithBatteriesOvercraftRobot extends SolarPanelWithBatteriesRobot {

	public SolarPanelWithBatteriesOvercraftRobot(String name) {
		super(name);
	}

	@Override
    public void move() {
        System.out.println("Robot " + this.getName() + " moving on overcraft");
    }

}
