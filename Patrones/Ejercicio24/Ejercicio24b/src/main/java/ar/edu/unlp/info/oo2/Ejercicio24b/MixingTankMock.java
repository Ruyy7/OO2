package ar.edu.unlp.info.oo2.Ejercicio24b;

public class MixingTankMock extends MixingTank {

	@Override
	public Boolean heatPower(int percentage) {
		return true;
	}

	@Override
	public Boolean mixerPower(int percentage) {
		return true;
	}

	@Override
	public Boolean purge() {
		return true;
	}

	@Override
	public double upTo() {
		return 77;
	}

	@Override
	public double temperature() {
		return 88;
	}

}
