package ar.edu.unlp.info.oo2.Ejercicio24;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestMonitoreo {
	MixingTankStub mts;
	LightMix lm;
	Purge p;
	
	@BeforeEach
	void setUp() {
		mts = new MixingTankStub();
	}
	
	@Test
	public void stubLightMixTest() {
		lm = new LightMix();
		lm.execute(mts);
		assertTrue(lm.isDone());
	}
	
	@Test
	public void stubPurgeTest() {
		p = new Purge();
		p.execute(mts);
		assertTrue(p.isDone());
	}
}
