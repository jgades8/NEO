import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.NoSuchElementException;

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

        // Test with values that should work (i.e. 1, 2, 3)
        // Set String to test and run method
        ByteArrayInputStream in1 = new ByteArrayInputStream("1".getBytes());
        System.setIn( in1 );
        assertTrue(Main.getHazardousInput().equals("1"));

        ByteArrayInputStream in2 = new ByteArrayInputStream("2".getBytes());
        System.setIn( in2 );
        assertTrue(Main.getHazardousInput().equals("2"));

        ByteArrayInputStream in3 = new ByteArrayInputStream("3".getBytes());
        System.setIn( in3 );
        assertTrue(Main.getHazardousInput().equals("3"));

        // Test with values that don't work
        assertThrows(NoSuchElementException.class, ()->
                {
                    // Set String to test and run method
                    ByteArrayInputStream in = new ByteArrayInputStream("4".getBytes());
                    System.setIn( in );
                    Main.getHazardousInput();
                });

        assertThrows(NoSuchElementException.class, ()->
        {
            // Set String to test and run method
            ByteArrayInputStream in = new ByteArrayInputStream("not a number".getBytes());
            System.setIn( in );
            Main.getHazardousInput();
        });

        assertThrows(NoSuchElementException.class, ()->
        {
            // Set String to test and run method
            ByteArrayInputStream in = new ByteArrayInputStream("0".getBytes());
            System.setIn( in );
            Main.getHazardousInput();
        });

        // Reset System.in to its original state
        System.setIn(sysInBackup);

    }
}