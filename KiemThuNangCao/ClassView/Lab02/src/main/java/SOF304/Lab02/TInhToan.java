package SOF304.Lab02;

public class TInhToan {
	public int Tong(int a, int b) {
		return a + b;
	}

	public int Tru(int a, int b) {
		return a - b;
	}

	public int Nhan(int a, int b) {
		return a * b;
	}

	public int Chia(int a, int b) {
		return a / b;
	}

	public int BinhPhuong(int a, int b) {
		return (int) Math.pow(a, b);
	}

	public int canBachai(int a) {
		return (int) Math.sqrt(a);
	}

	public boolean isEventNumber(int input) {
		if (input % 2 == 0) {
			return true;
		} else {
			return false;
		}
	}
}
