## Problem Definition -
An **Elevator System** is a critical transportation mechanism in multi-story buildings that enables vertical movement of people and goods between floors. Modern elevator systems are complex, requiring efficient algorithms to handle multiple requests while optimizing for factors like waiting time, energy consumption, and passenger comfort.

Elevator systems are found in virtually all multi-story buildings including residential apartments, office buildings, hotels, and shopping malls. They need to efficiently manage multiple elevator cars, process requests from different floors, and determine optimal car assignments to minimize wait times.

## Requirements - 
1. The system should support multiple elevator cars within a building.
2. Each elevator car should maintain information about its current floor, direction, and state (idle, moving, door open).
3. Passengers should be able to request an elevator from any floor (external request) by pressing up or down buttons.
4. Passengers inside the elevator should be able to request to go to specific floors (internal request).
5. The system should efficiently assign elevator cars to service requests based on factors like current location and direction.
6. Each elevator car should have a display showing its current floor and direction.
7. Elevator doors should open when arriving at a requested floor and close before moving.
8. The system should handle both internal and external requests through appropriate dispatchers.
9. The system should prioritize requests based on the current direction of travel to improve efficiency.
10. The elevator system should be scalable to accommodate buildings with different numbers of floors.

## System Design -

### Class Structure
The elevator system is implemented using the following classes:

1. **Main**: Entry point of the application that initializes the building and elevator system.
2. **Building**: Represents the physical building with multiple floors.
3. **Floor**: Represents a floor in the building with floor number and external request buttons.
4. **ElevatorCar**: Core class representing an elevator car with its current state, floor, and direction.
5. **ElevatorController**: Controls the movement of an elevator car and processes requests.
6. **ExternalDispatcher**: Handles external requests (from floors) and assigns them to appropriate elevator cars.
7. **InternalDispatcher**: Handles internal requests (from inside the elevator) and communicates with the elevator controller.
8. **ElevatorDisplay**: Displays the current floor and direction of the elevator.
9. **ElevatorDoor**: Controls the opening and closing of elevator doors.
10. **InternalButtons**: Represents the panel of buttons inside the elevator car.
11. **Direction**: Enum representing the direction of the elevator (UP, DOWN).
12. **ElevatorState**: Enum representing the state of the elevator (IDLE, MOVING).
13. **ElevatorCreator**: Factory class for creating elevator cars.

### Design Patterns Used

1. **Factory Pattern**: Used for creating elevator cars through the ElevatorCreator class.
2. **Singleton Pattern**: Used for dispatchers to ensure a single point of control for elevator requests.
3. **Command Pattern**: Used for handling elevator requests as commands.
4. **State Pattern**: Used to manage different states of the elevator (idle, moving).
5. **Observer Pattern**: Used for notifying components about elevator state changes.

### System Flow

1. External requests are made from floors using up/down buttons and processed by the ExternalDispatcher.
2. Internal requests are made from inside the elevator using the InternalButtons and processed by the InternalDispatcher.
3. The ElevatorController determines the optimal movement strategy for each elevator car.
4. Priority queues are used to efficiently process requests based on the current direction of travel.
5. The elevator display is updated as the elevator moves between floors.
6. When an elevator reaches a requested floor, the doors open to allow passengers to enter or exit.

## How to Use -

1. Initialize a building with the desired number of floors.
2. Create elevator cars and add them to the building.
3. Submit external requests (from floors) using the ExternalDispatcher.
4. Submit internal requests (from inside the elevator) using the InternalButtons.
5. The elevator system will automatically process these requests and move elevators accordingly.
6. The system optimizes elevator movements to minimize waiting time and maximize efficiency.