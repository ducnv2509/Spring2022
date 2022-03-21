package SOF304.View1;

import javax.annotation.processing.Generated;

import org.junit.Test;

@Generated(value = "org.junit-tools-1.1.0")
public class SupplierTest {

	private Supplier createTestSubject() {
		return new Supplier();
	}

	@Test
	public void testGetNameMaterial() throws Exception {
		Supplier testSubject;
		String result;

		// default test
		testSubject = createTestSubject();
		result = testSubject.getNameMaterial();
	}

	@Test
	public void testSetNameMaterial() throws Exception {
		Supplier testSubject;
		String nameMaterial = "";

		// default test
		testSubject = createTestSubject();
		testSubject.setNameMaterial(nameMaterial);
	}

	@Test
	public void testGetPhoneNumber() throws Exception {
		Supplier testSubject;
		String result;

		// default test
		testSubject = createTestSubject();
		result = testSubject.getPhoneNumber();
	}

	@Test
	public void testSetPhoneNumber() throws Exception {
		Supplier testSubject;
		String phoneNumber = "";

		// default test
		testSubject = createTestSubject();
		testSubject.setPhoneNumber(phoneNumber);
	}

	@Test
	public void testGetAddress() throws Exception {
		Supplier testSubject;
		String result;

		// default test
		testSubject = createTestSubject();
		result = testSubject.getAddress();
	}

	@Test
	public void testSetAddress() throws Exception {
		Supplier testSubject;
		String address = "";

		// default test
		testSubject = createTestSubject();
		testSubject.setAddress(address);
	}

	@Test
	public void testGetIdSupplier() throws Exception {
		Supplier testSubject;
		int result;

		// default test
		testSubject = createTestSubject();
		result = testSubject.getIdSupplier();
	}

	@Test
	public void testSetIdSupplier() throws Exception {
		Supplier testSubject;
		int idSupplier = 0;

		// default test
		testSubject = createTestSubject();
		testSubject.setIdSupplier(idSupplier);
	}
}