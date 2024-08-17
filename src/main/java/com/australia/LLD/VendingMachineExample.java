package com.australia.LLD;

// States
enum State {
    IDLE,
    SELECTED_PRODUCT,
    PAID,
    DISPENSING
}

// Events
enum Event {
    SELECT_PRODUCT,
    INSERT_COIN,
    DISPENSE,
    RESET
}

// State Machine
class VendingMachine {
    private State state;

    public VendingMachine() {
        this.state = State.IDLE;
    }

    public void handleEvent(Event event) {
        switch (state) {
            case IDLE:
                handleIdleState(event);
                break;
            case SELECTED_PRODUCT:
                handleSelectedProductState(event);
                break;
            case PAID:
                handlePaidState(event);
                break;
            case DISPENSING:
                handleDispensingState(event);
                break;
        }
    }

    private void handleIdleState(Event event) {
        switch (event) {
            case SELECT_PRODUCT:
                state = State.SELECTED_PRODUCT;
                break;
            default:
                // Ignore other events
        }
    }

    private void handleSelectedProductState(Event event) {
        switch (event) {
            case INSERT_COIN:
                state = State.PAID;
                break;
            default:
                // Ignore other events
        }
    }

    private void handlePaidState(Event event) {
        switch (event) {
            case DISPENSE:
                state = State.DISPENSING;
                break;
            default:
                // Ignore other events
        }
    }

    private void handleDispensingState(Event event) {
        switch (event) {
            case RESET:
                state = State.IDLE;
                break;
            default:
                // Ignore other events
        }
    }
}

public class VendingMachineExample {
    public static void main(String[] args) {
        VendingMachine vendingMachine = new VendingMachine();
        vendingMachine.handleEvent(Event.SELECT_PRODUCT);
        vendingMachine.handleEvent(Event.INSERT_COIN);
        vendingMachine.handleEvent(Event.DISPENSE);
        vendingMachine.handleEvent(Event.RESET);
    }
}
