import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(Parameterized.class)
public class Param {
    int so;
    long ketquagiaithua;
    TinhGiaThua giaithua;

    @Before
    public void setup() {
        giaithua = new TinhGiaThua();
    }

    public Param(int sotinh, long ketqua) {
        this.so = sotinh;
        this.ketquagiaithua = ketqua;
    }

    @Parameterized.Parameters
    public static Collection input() {
        return Arrays.asList(new Object[][]{
                {1, 1},
                {2, 2},
                {3, 6},
                {4, 24},
                {5, 120},
                {6, 120},
                {10, 840}
        });
    }

    @Test
    public void kiemtragiaithuavoinhieuthamso() {
        System.out.println("Tham số: thực ");
        long ketqua = giaithua.Giaithua(so);
        assertEquals(ketquagiaithua, ketqua);
    }
}


