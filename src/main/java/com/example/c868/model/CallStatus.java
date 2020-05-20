package com.example.c868.model;

import java.nio.channels.ClosedByInterruptException;
import java.util.ArrayList;
import java.util.List;

public enum CallStatus {

    IN_PROGRESS("In Progress"),
    ON_HOLD("On Hold"),
    URGENT("Urgent"),
    CLOSED("Closed");

    private final String name;
    private List<CallStatus> callStatuses = new ArrayList<CallStatus>();

    CallStatus(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "CallStatus{" +
                "name='" + name + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public List<CallStatus> getCallStatuses() {
        callStatuses.add(IN_PROGRESS);
        callStatuses.add(ON_HOLD);
        callStatuses.add(URGENT);
        callStatuses.add(CLOSED);

        return callStatuses;
    }
}
