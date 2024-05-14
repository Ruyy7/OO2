package ar.edu.unlp.info.oo2.Ejercicio24b;

public class LightMix extends ProcessStep {

	@Override
	protected boolean basicExecute(MixingTank tank) {
		double temp = tank.temperature();
		tank.heatPower(100);
		if (tank.temperature()-temp == 10) {
			tank.mixerPower(5);
			return true;
		}
		else return false;
	}
}
