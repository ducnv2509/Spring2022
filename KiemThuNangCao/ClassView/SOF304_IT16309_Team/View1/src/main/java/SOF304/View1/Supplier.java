package SOF304.View1;

public class Supplier {
	private String nameMaterial, phoneNumber, address;
	private int idSupplier;

	public Supplier() {
	}

	public Supplier(String nameMaterial, String phoneNumber, String address, int idSupplier) {
		this.nameMaterial = nameMaterial;
		this.phoneNumber = phoneNumber;
		this.address = address;
		this.idSupplier = idSupplier;
		if(phoneNumber.matches("/^[a-zA-Z]+$/")) {
			throw new IllegalArgumentException("Số điện thoại không hợp lệ");
		}else if (phoneNumber.length() > 10) {
			throw new IllegalArgumentException("Số điện thoại không hợp lệ");
		}else if (phoneNumber.isEmpty()) {
			throw new IllegalArgumentException("Số điện thoại không hợp lệ");
		}else if (nameMaterial.isEmpty()) {
			throw new IllegalArgumentException("Tên nhà cung cấp không hợp lệ");
		}else if(address.isEmpty()) {
			throw new IllegalArgumentException("Địa chỉ nhà cung cấp không hợp lệ");
		}
	}

	public String getNameMaterial() {
		return nameMaterial;
	}

	public void setNameMaterial(String nameMaterial) {
		this.nameMaterial = nameMaterial;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getIdSupplier() {
		return idSupplier;
	}

	public void setIdSupplier(int idSupplier) {
		this.idSupplier = idSupplier;
	}

}
