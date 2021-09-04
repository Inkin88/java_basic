package elevator;

import elevator.exceptions.DoorsAreOpenException;
import elevator.exceptions.FloorOutOfBoundException;
import elevator.models.ElevatorFloors;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class ElevatorTest {

    @Test
    public void testMoveElevatorToTheFloor() {
        Elevator elevator = new Elevator(1, new ElevatorFloors(-1, 10), true);
        elevator.moveElevatorToTheFloor(3);
        assertEquals(3, elevator.getCurrentFloor());
    }

    @Test
    public void testMoveElevatorToTheFloorAndExpectedDoorsAreOpenException() {
        Elevator elevator = new Elevator(1, new ElevatorFloors(-1, 10), true);
        assertThrows(DoorsAreOpenException.class, () -> elevator.moveElevatorToTheFloor(2));
    }

    @ParameterizedTest
    @MethodSource("dataSourceForTestMoveElevatorFloor")
    void testMoveElevatorToTheFloorAndExpectedFloorOutOfBoundException(int destinationFloor) {
        Elevator elevator = new Elevator(1, new ElevatorFloors(-1, 10), true);
        assertThrows(FloorOutOfBoundException.class, () -> elevator.moveElevatorToTheFloor(destinationFloor));
    }

    @Test
    void testGetAvailableFloors() {
        List<Integer> expected = List.of(-1, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        Elevator elevator = new Elevator(1, new ElevatorFloors(-1, 10), false);
        Assertions.assertEquals(expected, elevator.getAvailableFloors());
    }

    @Test
    void testAreTheDoorsOpen() {
        Elevator elevator = new Elevator(1, new ElevatorFloors(1, 5), true);
        assertTrue(elevator.areTheDoorsOpen());
    }

    @Test
    void testSwitchTheDoorsStatus() {
        Elevator elevator = new Elevator(1, new ElevatorFloors(1, 5), false);
        elevator.switchTheDoorsStatus();
        assertTrue(elevator.areTheDoorsOpen());
        elevator.switchTheDoorsStatus();
        assertFalse(elevator.areTheDoorsOpen());
    }

    @ParameterizedTest
    @MethodSource("dataSource")
    void getCurrentFloor(int currentFloor, int minFloor, int maxFloor) {
        ElevatorFloors elevatorFloors = new ElevatorFloors(minFloor, maxFloor);
        Elevator elevator = new Elevator(currentFloor, elevatorFloors, false);
        Assertions.assertEquals(currentFloor, elevator.getCurrentFloor());
        Assertions.assertTrue(elevator.getCurrentFloor() <= elevatorFloors.getMaxFloor()
                && elevatorFloors.getMinFloor() <= elevator.getCurrentFloor());
    }

    private static Stream<Arguments> dataSource() {
        return Stream.of(
                Arguments.of(0, 1, 9),
                Arguments.of(1, 1, 9),
                Arguments.of(2, 1, 9),
                Arguments.of(8, 1, 9),
                Arguments.of(9, 1, 9),
                Arguments.of(10, 1, 9)
        );
    }

    private static Stream<Arguments> dataSourceForTestMoveElevatorFloor() {
        return Stream.of(
                Arguments.of(-2),
                Arguments.of(0),
                Arguments.of(11)
        );
    }
}