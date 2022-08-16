package service;



import entity.Product;
import entity.ProductBuilderImpl;
import exceptions.ProductCodeException;
import exceptions.ResourceBadRequestException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import store.State;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

@ExtendWith(MockitoExtension.class)
class CalculationServiceTest {


    @Mock
    private State state;

    @Test
    @DisplayName("Test success for calculation service with correct input data")
    void testSuccessForCalculationServiceWithCorrectInputData() {
        State state = new State();
        assertDoesNotThrow(() -> CalculationService.calculateTotalCost(state,"ABCDABA"));
    }

    @Test
    @DisplayName("Test failed invoke calculation service with incorrect input data")
    void testFailedInvokeCalculationServiceWithIncorrectInputData() {
        State state = new State();
        assertThrows(ResourceBadRequestException.class,() -> CalculationService.calculateTotalCost(state," ABCDABAXXX"));
    }

    @Test
    @DisplayName("Test success for calculation service with correct input data and spaces")
    void testSuccessForCalculationServiceWithCorrectInputDataAndSpaces() {
        State state = new State();
        assertDoesNotThrow(() -> CalculationService.calculateTotalCost(state," ABCDABA "));
    }

    @Test
    @DisplayName("Test failed invoke calculation service when expression is null")
    void testFailedInvokeCalculationServiceWhenExpressionIsNull() {
        State state = new State();

        Exception exception = assertThrows(ResourceBadRequestException.class, () -> {
            CalculationService.calculateTotalCost(state,null);
        });

        String expectedMessage = "User's expressions is empty";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    @DisplayName("Test success for calculation service with expected response three")
    void testSuccessForCalculationServiceWithExpectedResponseThree() {
        State state = new State();
        assertEquals( CalculationService.calculateTotalCost(state," AAA "), 3);
    }


    @Test
    @DisplayName("Test failed invoke calculation service when state is null")
    void testFailedInvokeCalculationServiceWhenStateIsNull() {
        State state = null;

        Exception exception = assertThrows(ResourceBadRequestException.class, () -> {
            CalculationService.calculateTotalCost(state,"AAA");
        });
        String expectedMessage = "Cannot invoke \"store.State.getState()\" because \"state\" is null";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }


    @Test
    @DisplayName("Test success for calculation service with new mock state")
    void testSuccessForCalculatioServiceWithNewMockState() {

        Map<String, Product> testMap = new HashMap<>();
        testMap.put("A", new ProductBuilderImpl().setPrice(100).build());

        Mockito.when(state.getState())
                .thenReturn(testMap);

        assertTrue( CalculationService.calculateTotalCost(state,"AAA") == 300);
    }

    @Test
    @DisplayName("Test success for calculation service with empty state")
    void testSuccessForCalculatioServiceWithNEmptyState() {

        Map<String, Product> testMap = new HashMap<>();

        Mockito.when(state.getState())
                .thenReturn(testMap);

        Exception exception = assertThrows(ResourceBadRequestException.class, () -> {
            CalculationService.calculateTotalCost(state,null);
        });

        String expectedMessage = "Map with state is empty";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));

    }

}