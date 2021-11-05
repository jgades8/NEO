import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @Test
    void main() {
    }

    @Test
    void getDateInput() {
        // Backup System.in
        InputStream sysInBackup = System.in;

        // Set String to test and run method
        ByteArrayInputStream in = new ByteArrayInputStream("2021-10-10".getBytes());
        System.setIn( in );
        Main.getDateInput();

        // Reset System.in to its original state
        System.setIn(sysInBackup);
    }

    @Test
    void verifyDateFormat() {
        assertTrue(Main.verifyDateFormat("2021-10-10"));
        assertTrue(Main.verifyDateFormat("1905-01-30"));
        assertTrue(Main.verifyDateFormat("2021-10-10"));
        assertFalse(Main.verifyDateFormat("20"));
        assertFalse(Main.verifyDateFormat("2020-14-01"));
        assertFalse(Main.verifyDateFormat("Not a Date"));
    }

    @Test
    void getHazardousInput() {
        // Backup System.in
        InputStream sysInBackup = System.in;

        // Set String to test and run method
        ByteArrayInputStream in = new ByteArrayInputStream("3".getBytes());
        System.setIn( in );
        Main.getHazardousInput();

        // Reset System.in to its original state
        System.setIn(sysInBackup);
    }
}