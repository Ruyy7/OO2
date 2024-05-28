package ar.edu.unlp.info.oo2.rw.model;

public abstract class EnergySource{
	private int energy = 100;
	
    public abstract void consumeBattery(Robot r);
    
    protected boolean canConsume(int energy) {
    	return (this.energy - energy >= 0);
    }

	public int getEnergy() {
		return energy;
	}

	public void setEnergy(int energy) {
		this.energy = energy;
	}
    
}
