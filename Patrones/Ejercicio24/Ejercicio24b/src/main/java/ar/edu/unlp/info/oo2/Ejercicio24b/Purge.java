package ar.edu.unlp.info.oo2.Ejercicio24b;

public class Purge extends ProcessStep {

	@Override
	protected boolean basicExecute(MixingTank tank) {
		if (tank.upTo() == 0) {
			return false;
		}
		else {
			tank.heatPower(0);
			tank.mixerPower(0);
			tank.purge();
			if (tank.upTo() != 0) {
				return false;
			}
			return true;
		}
	}
}
