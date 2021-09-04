package elevator.models;

import elevator.exceptions.IncorrectFloorException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;


class ElevatorFloorsTest {

    @Test
    void testGetMinFloor() {
        ElevatorFloors elevatorFloors = new ElevatorFloors(-1, 3);
        Assertions.assertEquals(elevatorFloors.getMinFloor(), -1);
    }

    @Test
    void testGetMaxFloor() {
        ElevatorFloors elevatorFloors = new ElevatorFloors(-1, 3);
        Assertions.assertEquals(elevatorFloors.getMaxFloor(), 3);
    }

    @Test
    public void testCreateElevatorWithDefaultConstr() {
        Assertions.assertThrows(IncorrectFloorException.class, ElevatorFloors::new);
    }

    @ParameterizedTest
    @MethodSource("dataSource")
    public void testMaxFloorLessMinFloor(int minFloor, int maxFloor) {
        Assertions.assertThrows(IncorrectFloorException.class, () -> new ElevatorFloors(minFloor, maxFloor));
    }

    private static Stream<Arguments> dataSource() {
        return Stream.of(
                Arguments.of(1, -1),
                Arguments.of(2, 2),
                Arguments.of(0, 1),
                Arguments.of(-1, 0)
        );
    }
}