package com.vozup.givemetaxi.others;

import com.vozup.givemetaxi.views.operator.TakeOrder;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.ArrayList;
import java.util.List;

@Named
public class CallList {
    private List<Call> calls;
    private Call selectedCall;
    @Inject
    TakeOrder takeOrder;

    @PostConstruct
    void init() {
        calls = new ArrayList<>();
        calls.add(new Call("+380931234512"));
        calls.add(new Call("+380971235612"));
        calls.add(new Call("+380971235612"));
        calls.add(new Call("+380631211562"));
        calls.add(new Call("+380931231111"));
        calls.add(new Call("+380971234562"));
    }

    public void answer() {
        //System.out.println(selectedCall.getPhoneNumber() + " removed");
        takeOrder.setClientPhoneNumber(selectedCall.getPhoneNumber());
        calls.remove(selectedCall);
    }

    public Call getSelectedCall() {
        return selectedCall;
    }

    public void setSelectedCall(Call selectedCall) {
        this.selectedCall = selectedCall;
    }

    public List<Call> getCalls() {
        return calls;
    }

    public void setCalls(List<Call> calls) {
        this.calls = calls;
    }
}
