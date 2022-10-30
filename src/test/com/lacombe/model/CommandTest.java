package src.test.com.lacombe.model;

import org.junit.jupiter.api.Test;
import src.com.lacombe.model.Command;

import java.security.InvalidParameterException;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CommandTestShould {
    @Test
    public void throw_an_error_when_invalid_char_is_add() {
        char[] moves = new char[]{'a'};

        Throwable exception = assertThrows(InvalidParameterException.class,
                () -> {new Command(moves);});
    }

    @Test
    public void receive_an_array_of_valid_character() {
        char[] moves = new char[]{'f', 'b', 'l', 'r'};

        assertDoesNotThrow(() -> new Command(moves));
    }
}