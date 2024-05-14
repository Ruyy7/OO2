package ar.edu.unlp.info.oo2.Ejercicio24b;

public abstract class ProcessStep {
	private boolean result;
	
	public void execute(MixingTank tank) {
		if (this.basicExecute(tank)) {
			this.setSucces();
		}
		else this.setFailure();
	}
	
	protected abstract boolean basicExecute(MixingTank tank);
	
	public boolean isDone() {
		return this.result;
	}
	
	private void setSucces() {
		this.result = true;
	}
	
	private void setFailure() {
		this.result = false;
	}
}
