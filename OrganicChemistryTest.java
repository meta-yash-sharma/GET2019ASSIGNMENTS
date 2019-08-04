package organicChemistry;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class OrganicChemistryTest {

	@Test
	public void compoundMassOfValidCompoundTest() {
		OrganicChemistry obj1 =new OrganicChemistry();
		assertEquals(16, obj1.calculateCompoundMass("CH4"));
		assertEquals(180, obj1.calculateCompoundMass("C6H12O6"));
		assertEquals(791, obj1.calculateCompoundMass("C2H3(C12(OH)13)2(OH)2"));
	}
}
